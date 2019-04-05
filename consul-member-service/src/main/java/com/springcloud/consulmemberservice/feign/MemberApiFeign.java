package com.springcloud.consulmemberservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-service")
public interface MemberApiFeign {
    //feign客户端调用

    @RequestMapping("/getOrder")
    String getOrder();
}
