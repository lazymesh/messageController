package com.eitas.herman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ramesh on 5/19/18.
 */
@RestController
public class MessageController {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Autowired
    YMLSource confSource;

    @RequestMapping("/message/{msg}")
    public Message message(@PathVariable(value="msg") String msg) {
        return new Message(confSource.getName()+" "+msg+" "+confSource.getMatch());
    }
}
