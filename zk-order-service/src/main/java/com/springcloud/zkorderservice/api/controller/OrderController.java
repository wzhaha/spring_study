package com.springcloud.zkorderservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String url = "http://zk-member/getMember";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

}
