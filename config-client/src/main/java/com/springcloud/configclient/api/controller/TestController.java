package com.springcloud.configclient.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新配置文件
public class TestController {

    @Value("${name}")
    public String name;

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }
}
