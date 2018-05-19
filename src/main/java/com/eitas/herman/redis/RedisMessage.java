package com.eitas.herman.redis;

/**
 * Created by Ramesh on 5/19/18.
 */
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class RedisMessage {

    private StringRedisTemplate redis;

    @Inject
    public RedisMessage(StringRedisTemplate redisTemplate){
        this.redis = redisTemplate;
    }

    public Long addKeyValue(String key, String value) {
        Long index = redis.opsForList().rightPush(key, value);
        return index;
    }
}