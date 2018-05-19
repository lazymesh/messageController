package com.eitas.herman;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.Mapping.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ramesh on 5/19/18.
 */
@RestController
public class MessageController {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    private static final String template = "Hello, %s!";

    @RequestMapping("/message/{msg}")
    public Message message(@PathVariable(value="msg") String msg) {
        return new Message(msg);
    }
}
