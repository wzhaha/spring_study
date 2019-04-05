package com.member.service.impl;

import api.entity.User;
import api.service.IMemberService;
import com.common.BaseApiService;
import com.common.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService{

    @Value("${server.port}")
    private String portNumber;

    @RequestMapping("/")
    public String init(){
        return "这是会员模块";
    }

    @RequestMapping("/getMember")
    public Object getMember(@RequestParam("name") String name){
        System.out.println("getMember线程池:"+Thread.currentThread().getName());
        User user=new User();
        user.setName(name+" 端口号是"+portNumber);
        user.setAge(20);
        return user;
    }


    @Override
    @RequestMapping("/getUserInfo")
//    @HystrixCommand(fallbackMethod = "toManyRequest")
    public ResponseBase getUserInfo(){
        System.out.println("getUserInfo:"+Thread.currentThread().getName());
        User user=new User();
        user.setAge(20);
        user.setName("hha");
        return setResultSuccess(user);
    }

    public ResponseBase toManyRequest(){
        return setResultSuccess("服务器忙，稍后再试");
    }

}
