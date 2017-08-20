package curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").sessionTimeoutMs(5000).retryPolicy(retryPolicy).build();
        client.start();

        String path = "/zq";
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path + "/node2", "data2".getBytes());

//        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(); //异步

        final NodeCache nodeCache = new NodeCache(client, path + "/node2", false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            public void nodeChanged() throws Exception {
                System.out.println("node data update, new data: " + new String(nodeCache.getCurrentData().getData()));
            }
        });

        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path + "/node2", true);
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                switch (pathChildrenCacheEvent.getType()) {
                    case CHILD_ADDED:
                        System.out.println("CHILD_ADDED, " + pathChildrenCacheEvent.getData());
                        break;
                    case CHILD_UPDATED:
                        System.out.println("CHILD_UPDATED, " + pathChildrenCacheEvent.getData());
                        break;
                    case CHILD_REMOVED:
                        System.out.println("CHILD_REMOVED, " + pathChildrenCacheEvent.getData());
                        break;
                    default:
                        System.out.println("unknown event.");
                        break;
                }
            }
        });

//        client.delete().deletingChildrenIfNeeded().forPath(path + "/node2");
        Stat stat = new Stat();
        System.out.println(new String(client.getData().storingStatIn(stat).forPath(path + "/node2")) + ", " + stat);

        client.setData().withVersion(stat.getVersion()).forPath(path + "/node2", "/data3".getBytes());
        TimeUnit.SECONDS.sleep(1);

        System.out.println("end");
    }

}
