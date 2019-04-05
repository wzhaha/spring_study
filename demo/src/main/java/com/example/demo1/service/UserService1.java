package com.example.demo1.service;

import com.example.demo1.mapper.UserMapper1;
import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService1 {
    @Autowired
    private UserMapper1 userMapper1;

    public User findByName(String name) {
        User user = userMapper1.findByName(name);
        return user;
    }


    @Transactional(transactionManager = "demo1TransactionManager")
    public int insert(String id, String name, String sex, int age, String mobile) {
        int res = userMapper1.insert(id, name, sex, age, mobile);
        int i = 1 / age;
        //验证事务开启,方法执行完毕才提交到数据库，发生异常会自动回滚
        return res;
    }
}
