package com.eitas.herman;

import com.eitas.herman.redis.RedisConfig;
import com.eitas.herman.redis.RedisMessage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Created by Ramesh on 5/19/18.
 */
@ContextConfiguration(classes = {RedisConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisMessageTest {

    @Inject
    private RedisMessage message;

    @Inject
    private StringRedisTemplate redis;

    @After
    public void tearDown() {
        redis.getConnectionFactory().getConnection().flushDb();
    }

    @Test
    public void testAddWordWithItsMeaningToDictionary() {
        Long index = message.addKeyValue("key", "value");
        assertThat(index, is(notNullValue()));
        assertThat(index, is(equalTo(1L)));
    }
}
