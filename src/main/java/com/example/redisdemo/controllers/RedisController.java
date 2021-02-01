package com.example.redisdemo.controllers;

import com.example.redisdemo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test_redis")
public class RedisController {

    @Autowired
    private Repository repository;


    @PostMapping("/addKey")
    public String addKey(@RequestParam(name = "key") String key,
                         @RequestParam(name = "value") String value) {
        return repository.setKey(key, value);
    }


    @GetMapping("/getKey")
    public String getKey(@RequestParam(name = "key") String key) {
        return repository.getKey(key);
    }

}
