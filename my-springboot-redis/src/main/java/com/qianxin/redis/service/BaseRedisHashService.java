package com.qianxin.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;

public class BaseRedisHashService<T> {

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    public boolean delete(String key, String hashKey){
        Long delete = redisTemplate.opsForHash().delete(key, hashKey);
        if(delete > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean put(String key, String hashKey, T value){
        redisTemplate.opsForHash().put(key, hashKey, value);
        return true;
    }

    public boolean hasKey(String key, String hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public T get(String key, String hashKey){
        return (T)redisTemplate.opsForHash().get(key, hashKey);
    }

    public Map<Object, Object> entries(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    public Set<Object> keys(String key){
        return redisTemplate.opsForHash().keys(key);
    }

}
