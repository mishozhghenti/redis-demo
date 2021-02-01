package com.example.redisdemo.repository;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class Repository {

    final
    Jedis jedis;

    public Repository(Jedis jedis) {
        this.jedis = jedis;
    }

    public String setKey(String key, String value) {
        return jedis.set(key, value);
    }

    public String getKey(String key) {
        return jedis.get(key);
    }
}
