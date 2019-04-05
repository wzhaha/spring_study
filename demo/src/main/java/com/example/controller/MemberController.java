package com.example.controller;

import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 演示异步调用
 */

@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("/getMember")
    public Map<String, Object> getMember() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("message", "success");
        return res;
    }

    @RequestMapping("/addMember")
    public Map<String, Object> addMember() {
        log.info("1");
        String result = service.addMemberAndEmail();
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("message", "success");
        res.put("data", result);
        log.info("4");
        return res;
    }

}
