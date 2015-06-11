package com.test.app.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

/**
 * Created by zc on 2015/6/11.
 */
public class Master implements Watcher {
    private ZooKeeper zooKeeper;
    private String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    private void startZK() throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper(hostPort,15000,this);

        bootstrap();

//        String serverid = Integer.toHexString(new Random().nextInt());
//        zooKeeper.create("/test3", serverid.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        getDate();
    }

    private void getDate() throws KeeperException, InterruptedException {
        Stat stat  = new Stat();
        zooKeeper.getData("/test3", true, stat);
        System.out.println(stat);
    }

    private void stopZK() throws InterruptedException {
        zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
        try {
            getDate();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bootstrap(){
        createParent("/workers",new byte[0]);
        createParent("/assign",new byte[0]);
        createParent("/tasks",new byte[0]);
        createParent("/status",new byte[0]);
    }

    public void createParent(String path, byte[] data){
        zooKeeper.create(path,data,
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                createParentCallback,
                data);
    }

    private AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    createParent(path,(byte[]) ctx);
                    break;
                case OK:
                    System.out.println("Parent created");
                    break;
                case NODEEXISTS:
                    System.out.println("Parent already registed: " + path);
                    break;
                default:
                    System.out.println("error: " +
                            KeeperException.create(KeeperException.Code.get(rc),path));
            }
        }
    };

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        Master master = new Master("127.0.0.1:2181");

        master.startZK();

        Thread.sleep(60000);

        master.stopZK();
    }
}
