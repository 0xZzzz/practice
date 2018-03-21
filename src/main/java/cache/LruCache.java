package cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * lru缓存
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = -1L;

    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private static final int DEFAULT_MAX_CAPACITY = 1000;

    private static final int DEFAULT_INIT_CAPACITY = 16;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /** 缓存容量 */
    private volatile int maxCapacity;

    public LruCache() {
        this(DEFAULT_MAX_CAPACITY);
    }

    public LruCache(int maxCapacity) {
        super(DEFAULT_INIT_CAPACITY, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    public V get(Object key) {
        try {
            lock.readLock().lock();
            return super.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.readLock().lock();
            return super.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.writeLock().lock();
            return super.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public V remove(Object key) {
        try {
            lock.writeLock().lock();
            return super.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.readLock().lock();
            return super.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity; //元素个数大于容量则移除最老的元素
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
