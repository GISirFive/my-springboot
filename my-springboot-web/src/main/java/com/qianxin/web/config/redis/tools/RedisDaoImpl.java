package com.qianxin.web.config.redis.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedisDaoImpl<K, HK, V> implements IRedisDao<K, HK, V> {

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

    @Override
    public boolean hashDelete(K key, HK hashKey){
        Long delete = redisTemplate.opsForHash().delete(key, hashKey);
        if(delete > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean hashPut(K key, HK hashKey, V value){
        redisTemplate.opsForHash().put(key, hashKey, value);
        return true;
    }

    @Override
    public boolean hashHasKey(K key, HK hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public V hashGet(K key, HK hashKey){
        return (V)redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public Map<HK, V> hashEntries(K key){
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        HashMap<HK, V> hashEntrieMap = new HashMap<>();
        for(Map.Entry<Object, Object> entry: entries.entrySet()){
            hashEntrieMap.put((HK)entry.getKey(), (V)entry.getValue());
        }
        return hashEntrieMap;
    }

    @Override
    public Set<HK> hashKeys(K key){
        Set<Object> keys = redisTemplate.opsForHash().keys(key);
        HashSet<HK> hashKeySet = new HashSet<>();
        for (Object o : keys) {
            hashKeySet.add((HK)o);
        }
        return hashKeySet;
    }
}
