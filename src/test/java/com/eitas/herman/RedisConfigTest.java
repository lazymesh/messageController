package com.eitas.herman;

import com.eitas.herman.redis.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ramesh on 5/19/18.
 */
@ContextConfiguration(classes = RedisConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisConfigTest {

    @Inject
    private JedisConnectionFactory jedisConnectionFactory;

    @Inject
    private StringRedisTemplate redisTemplate;

    @Test
    public void testJedisConnectionFactory() {
        assertNotNull(jedisConnectionFactory);
    }

    @Test
    public void testRedisTemplate() {
        assertNotNull(redisTemplate);
    }

}
