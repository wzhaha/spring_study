package com.springcloud.consulorderservice.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/getOrder")
    public String getOrder(){
        return "我的订单已完成";
    }
}
