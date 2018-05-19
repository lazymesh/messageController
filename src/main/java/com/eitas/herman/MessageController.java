package com.eitas.herman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ramesh on 5/19/18.
 */
@RestController
public class MessageController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/message")
    public Message message(@RequestParam(value="message", defaultValue="no message") String msg) {
        return new Message(counter.incrementAndGet(), String.format(template, msg));
    }
}
