package com.example.demo;

import java.util.UUID;

public class DemoBean {
    private final String id;

    public DemoBean() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
