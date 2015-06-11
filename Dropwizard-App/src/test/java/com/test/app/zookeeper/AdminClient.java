package com.test.app.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zc on 2015/6/11.
 */
public class AdminClient implements Watcher {
    private ZooKeeper zk;
    private String hostPort;

    public AdminClient(String hostPort) {
        this.hostPort = hostPort;
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public void start() throws IOException {
        zk = new ZooKeeper(hostPort,15000,this);

    }

    public void stop(){
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void listState(){
        Stat stat = new Stat();
        try {
            byte mstaerData[] = zk.getData("/master",false,stat);
            System.out.println("Version: "+stat.getVersion());
            Date statDate = new Date(stat.getCtime());
            System.out.println("Master: " + new String(mstaerData)
                    + " since " + statDate);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Workers: " );
        try {
            for(String w: zk.getChildren("/workers",false)){
                byte data[] = zk.getData("/workers/" + w, false,null);
                String state = new String(data);
                System.out.println("\t" + w + ": " + state);

            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tasks: " );
        try {
            for(String t: zk.getChildren("/tasks",false)){
                System.out.println(t);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private AsyncCallback.StatCallback masterExistsCallback = new AsyncCallback.StatCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (KeeperException.Code.get(rc)){
                case CONNECTIONLOSS:
                    System.out.println("CONNECTIONLOSS");
                    break;
                case OK:
                    System.out.println("OK");
                    break;
                case NODEEXISTS:
                    System.out.println("Exist");
                    break;
                default:
                    System.out.println("error");
            }
        }

    };

    public void masterExists(){
        zk.exists("/master",
                masterExistsWather,
                masterExistsCallback,
                null);
    }

    private Watcher masterExistsWather = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if(event.getType() == Event.EventType.NodeDeleted){
                assert "/master".equals(event.getPath());
            }
        }
    };

    public static void main(String args[]) throws IOException {
        AdminClient client = new AdminClient("");
        client.start();
        client.listState();
        client.masterExists();

        client.stop();
    }
}
