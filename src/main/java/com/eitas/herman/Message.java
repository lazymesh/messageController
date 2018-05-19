package com.eitas.herman;

/**
 * Created by Ramesh on 5/19/18.
 */
public class Message {

    private final long id;
    private final String msg;

    public Message(long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return msg;
    }
}