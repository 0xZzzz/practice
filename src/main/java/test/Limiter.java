package test;

import com.google.common.util.concurrent.RateLimiter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/3/24.
 */
public class Limiter {

    private final ConcurrentMap<String, RateLimiter> limiterCache = new ConcurrentHashMap<String, RateLimiter>();

    private final Jedis redis;

    public Limiter(Jedis redis) {
        this.redis = redis;
    }

    public static void main(String[] args) {
        new Limiter(new Jedis()).login("x.x.x.x");
    }

    public void login(String ip) {
        String key = getLimitCacheKey(ip);
        if (redis.get(key) != null) {
            throw new RuntimeException("您登陆的太频繁了，请稍后重试！");
        }
        RateLimiter rateLimiter = limiterCache.get(ip);
        if (rateLimiter == null) {
            rateLimiter = RateLimiter.create(30.0, 30, TimeUnit.MINUTES);
            limiterCache.putIfAbsent(ip, rateLimiter);
        }
        if (rateLimiter.tryAcquire()) {
            Transaction multi = redis.multi();
            redis.set(key, "1");
            redis.expire(key, 30 * 60);
            multi.exec();
            throw new RuntimeException("您登陆的太频繁了，请稍后重试！");
        }
    }

    /**
     * 获取限制登陆的缓存key
     */
    public static String getLimitCacheKey(String ip) {
        return "limit_" + ip;
    }

}
