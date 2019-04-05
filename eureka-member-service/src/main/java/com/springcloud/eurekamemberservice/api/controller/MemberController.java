package com.springcloud.eurekamemberservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MemberController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    private String portNumber;

    @RequestMapping("/getMember")
    public String getMember(){
        return "我是会员服务,我的端口号是"+portNumber;
    }

    @RequestMapping("/charge")
    public String charge(){
        String url="http://order-service/judgeOrder";
        String result= restTemplate.getForObject(url,String.class);
        return result;
    }

}
