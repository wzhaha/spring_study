package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 思路：使用aop技术在运行时创建一个新的线程执行
 */
@Service
@Slf4j
public class MemberService {

    @Async
    public String addMemberAndEmail() {
        String res = null;
        log.info("2");
        try {
            res = "hahahaha";
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("3");
        return res;
    }
}
