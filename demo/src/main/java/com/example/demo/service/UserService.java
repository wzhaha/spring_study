package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo1.mapper.UserMapper1;
import com.example.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper1 userMapper1;

    public User findByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }


    @Transactional(transactionManager = "demoTransactionManager")
    public int insert(String id, String name, String sex, int age, String mobile) {
        int res = userMapper.insert(id, name, sex, age, mobile);
        int i = 1 / age;
        //验证事务开启,方法执行完毕才提交到数据库，发生异常会自动回滚
        return res;
    }

    /**
     * 多数据源分布式事务
     */
    @Transactional(transactionManager = "demo1TransactionManager")
    public int insertDemoAndDemo1(String id, String name, String sex, int age, String mobile) {
        //传统的分布式事务解决方案使用jta+atomikos，注册到同一全局事务
        //但是性能不好

        //第一个数据源
        int res = userMapper.insert(id, name, sex, age, mobile);
        //第二个数据源
        int res1 = userMapper1.insert(id, name, sex, age, mobile);

        int result = res + res1;
        return result;
    }


    public Object getUserList(int page,int pageSize){

//        pagehelper帮助生成语句
        PageHelper.startPage(page,pageSize);
        List<User> list=userMapper.getUSerList();
        PageInfo<User> userList=new PageInfo<User>(list);

        return userList;
    }
}
