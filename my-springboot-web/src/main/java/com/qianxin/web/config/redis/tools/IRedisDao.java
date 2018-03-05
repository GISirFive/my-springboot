package com.qianxin.web.config.redis.tools;

import java.util.Map;
import java.util.Set;

public interface IRedisDao<K, HK, V> {
    boolean hashDelete(K key, HK hashKey);

    boolean hashPut(K key, HK hashKey, V value);

    boolean hashHasKey(K key, HK hashKey);

    V hashGet(K key, HK hashKey);

    Map<HK, V> hashEntries(K key);

    Set<HK> hashKeys(K key);
}
