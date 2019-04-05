package com.example.demo.service;

import com.example.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    RedisUtils redisUtils;

    public Object getKey(String key){
        return redisUtils.get(key);
    }

}
