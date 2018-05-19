package com.eitas.herman.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Ramesh on 5/19/18.
 */
@Configuration
@ComponentScan(basePackages="com.eitas.herman")
public class RedisConfig {

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(1);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public StringRedisTemplate redisTemplate(){
        //SpringRedisTemplate is a specialized version of RedisTemplate for working with strings.
        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory());
        return redisTemplate;
    }
}