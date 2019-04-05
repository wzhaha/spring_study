package com.springcloud.consulmemberservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DiscoveryController {

    //如何后获取注册中心的一些信息，如：服务列表
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public Object discovery(){
        List<ServiceInstance> instances=discoveryClient.getInstances("order-service");
        System.out.println(instances.get(0).getUri());
        return instances;
    }
}
