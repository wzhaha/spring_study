package com.springcloud.zkmemberservice.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {


    @RequestMapping("/getMember")
    public String getMember(){
        return "我是会员";
    }
}
