package com.example.controller;

import com.example.demo.service.UserService;
import com.example.demo1.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiDatasourceController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService1 userService1;

    @RequestMapping("/addUserDemo")
    public int addUserDemo(String id, String name, String sex, int age, String mobile) {
        return userService.insert(id, name, sex, age, mobile);
    }

    @RequestMapping("/addUserDemo1")
    public int addUserDemo1(String id, String name, String sex, int age, String mobile) {
        return userService1.insert(id, name, sex, age, mobile);
    }

    @RequestMapping("/addUserDemoAndDemo1")
    public int insertDemoAndDemo1(String id, String name, String sex, int age, String mobile) {
        int res = userService.insertDemoAndDemo1(id, name, sex, age, mobile);
        return res;
    }
}
