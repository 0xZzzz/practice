package curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * master 选举
 */
public class LeaderSelectorTest {

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").sessionTimeoutMs(5000).retryPolicy(retryPolicy).build();
        client.start();

        LeaderSelector selector = new LeaderSelector(client, "/master_path", new LeaderSelectorListenerAdapter() {
            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                System.out.println("become master.");
                TimeUnit.SECONDS.sleep(1); //do logic
                System.out.println("release master.");
            }
        });
        selector.autoRequeue();
        selector.start();
        TimeUnit.SECONDS.sleep(5);
    }

}
