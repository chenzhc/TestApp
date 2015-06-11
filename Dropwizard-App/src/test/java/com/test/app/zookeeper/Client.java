package com.test.app.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by zc on 2015/6/11.
 */
public class Client implements Watcher {
    private ZooKeeper zk;
    private String hostPort;

    public Client(String hostPort) {
        this.hostPort = hostPort;
    }

    public void startZK() throws IOException {
        zk = new ZooKeeper(hostPort,15000,this);
    }

    public void stopZK() throws InterruptedException {
        zk.close();
    }

    public String quereCommand(String command) throws KeeperException, InterruptedException {
        while(true){
            String name = zk.create("/tasks/task-",
                    command.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT_SEQUENTIAL);
            return name;
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public static void main(String args[]) throws KeeperException, InterruptedException, IOException {
        Client client = new Client("127.0.0.1:2181");
        client.startZK();

        String name = client.quereCommand("/test4");
        System.out.println("Created " + name);

        client.stopZK();
    }
}
