package com.example.redisdemo.controllers;

import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test_redis")
public class RedisController {


    private final Jedis jedis;

    public RedisController(Jedis jedis) {
        this.jedis = jedis;
    }

    @PostMapping("/addKey")
    public String addKey(@RequestParam(name = "key") String key,
                         @RequestParam(name = "value") String value) {
        return jedis.set(key, value);
    }


    @GetMapping("/getKey")
    public String getKey(@RequestParam(name = "key") String key) {
        return jedis.get(key);
    }

}
