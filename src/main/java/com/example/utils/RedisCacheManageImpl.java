package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheManageImpl implements CacheManage {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public <V> void set(String key, V value) {

        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public <V> void set(String key, V value, Long timeSpan) {

        redisTemplate.opsForValue().set(key,value,timeSpan,TimeUnit.MILLISECONDS);
    }

    @Override
    public <V> V get(String key) {

        ValueOperations<String,V> connect = redisTemplate.opsForValue();
        return connect.get(key);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public boolean expire(String key, Long timeSpan) {
        return redisTemplate.expire(key, timeSpan,TimeUnit.MILLISECONDS);
    }
}
