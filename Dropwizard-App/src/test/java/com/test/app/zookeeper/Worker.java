package com.test.app.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import java.io.IOException;
import java.util.Random;

/**
 * Created by zc on 2015/6/11.
 */
public class Worker implements Watcher {
    private ZooKeeper zooKeeper;
    private String hostPort;
    private String serverid = Integer.toHexString(new Random().nextInt());
    private String name;
    private String status;

    public Worker(String hostPort) {
        this.hostPort = hostPort;
    }

    private void startZK() throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper(hostPort,15000,this);

        register();

//        String serverid = Integer.toHexString(new Random().nextInt());
//        zooKeeper.create("/test3", serverid.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        getDate();
    }

    public void register() throws KeeperException, InterruptedException {
        zooKeeper.create("/workers/worker-" + serverid,
                "Idle".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                createParentCallback,
                null);
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
        System.out.println(watchedEvent + ", " + hostPort);
        try {
            getDate();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private AsyncCallback.StatCallback statusUpdateCallbak = new AsyncCallback.StatCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    updateStatus((String) ctx);
                    return;
            }
        }
    };

    private synchronized void updateStatus(String status){
        if(status == this.status){
            zooKeeper.setData("/workers/" + name,
                    status.getBytes(),
                    -1,
                    statusUpdateCallbak,
                    status);
        }
    }


    private AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    setName(name);
                    setStatus((String) ctx);
                    try {
                        register();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case OK:
                    System.out.println("Parent created");
                    break;
                case NODEEXISTS:
                    System.out.println("Parent already registed: " + path);
                    break;
                default:
                    System.out.println("error: " +
                            KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        Worker master = new Worker("127.0.0.1:2181");

        master.startZK();

        Thread.sleep(60000);

        master.stopZK();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        updateStatus(status);
    }
}
