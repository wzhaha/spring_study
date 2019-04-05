package com.pay.service.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayServiceImpl {


    @RequestMapping("/")
    public String init(){
        return "这是支付模块";
    }
}
