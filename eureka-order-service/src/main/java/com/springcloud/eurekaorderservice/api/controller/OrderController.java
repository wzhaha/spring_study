package com.springcloud.eurekaorderservice.api.controller;

import com.springcloud.eurekaorderservice.api.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder(){
        String url="http://member-service/getMember";
        String result= restTemplate.getForObject(url,String.class);
        return result;
    }

    @RequestMapping("/judgeOrder")
    public Result judgeOrder(){
        Result result=new Result();
        result.setCode("200");
        result.setMessage("success");
        return result;
    }

}
