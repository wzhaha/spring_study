package com.springcloud.consulmemberservice.api.controller;

import com.springcloud.consulmemberservice.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberApiFeign memberApiFeign;

    @RequestMapping("/getMember")
    public String getMember(){
        String res=memberApiFeign.getOrder();
        return "我是会员"+res;
    }
}
