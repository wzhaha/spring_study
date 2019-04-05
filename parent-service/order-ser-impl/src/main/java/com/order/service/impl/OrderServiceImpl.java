package com.order.service.impl;

import api.entity.Order;
import api.service.IOrderSErvice;
import com.alibaba.fastjson.JSONObject;
import com.common.BaseApiService;
import com.common.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderSErvice {

    @Autowired
    MemberServiceFeign memberServiceFeign;

    @RequestMapping("/")
    public String init(){
        return "这是订单模块";
    }

    @Override
    @RequestMapping("/getOrder")
    public Object getOrder() {
        Order order=new Order();
        order.setOrderNumber("12345678");
        order.setUserName("王志");
        Object member= memberServiceFeign.getMember("王志");

        JSONObject res=new JSONObject();
        res.put("order",order);
        res.put("member",member);
        return res;
    }


    @Override
    @RequestMapping("/orderToMember")
    public ResponseBase orderToMember(){
        System.out.println("orderToMember 线程池:"+Thread.currentThread().getName());
        ResponseBase responseBase=memberServiceFeign.getUserInfo();
        return responseBase;
    }

    //使用注解方式，不推荐
    //默认开启服务的隔离，降级，熔断
    @RequestMapping("/orderToMemberHystrix")
    @HystrixCommand(fallbackMethod = "toManyRequest")
    public ResponseBase orderToMemberHystrix(){
        System.out.println("orderToMemberHystrix 线程池:"+Thread.currentThread().getName());
        ResponseBase responseBase=memberServiceFeign.getUserInfo();
        return responseBase;
    }

    //使用类的方式
    //默认开启服务的隔离，降级，熔断
    @RequestMapping("/orderToMemberHystrix02")
    @HystrixCommand(fallbackMethod = "toManyRequest")
    public ResponseBase orderToMemberHystrix02(){
        System.out.println("orderToMemberHystrix 线程池:"+Thread.currentThread().getName());
        ResponseBase responseBase=memberServiceFeign.getUserInfo();
        return responseBase;
    }


    public ResponseBase toManyRequest(){
        return setResultSuccess("服务器忙，稍后再试");
    }
}