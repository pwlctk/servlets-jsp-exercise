package com.example.mvc.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private AtomicLong id;

    public IdGenerator() {
        this.id = new AtomicLong(0);
    }

    public Long get() {
        return id.incrementAndGet();
    }
}
