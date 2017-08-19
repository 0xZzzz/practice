package zkClient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 5000);
        System.out.println("Zookeeper session established.");

        String path = "/zq";

        /* node operation */
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s + "'s child changed, currentChildren: " + list);
            }
        });

        zkClient.createPersistent(path + "/node1", true);
        zkClient.writeData(path + "/node1", "data1");
        TimeUnit.SECONDS.sleep(1);

//        zkClient.deleteRecursive(path);
//        TimeUnit.SECONDS.sleep(1);

        /* data operation */
        zkClient.subscribeDataChanges(path + "/node1", new IZkDataListener() {
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("node" + s + " changed, new data: " + o);
            }

            public void handleDataDeleted(String s) throws Exception {
                System.out.println("node" + s + " deleted.");
            }
        });
        System.out.println(zkClient.readData(path + "/node1"));
        zkClient.writeData(path + "/node1", "data2");
        TimeUnit.SECONDS.sleep(1);
    }

}
