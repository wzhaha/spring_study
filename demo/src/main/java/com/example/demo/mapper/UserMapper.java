package com.example.demo.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface UserMapper {

    @Select("select * from user where name=#{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(id,name,sex,age,mobile) values(#{id},#{name},#{sex},#{age},#{mobile})")
    int insert(@Param("id") String id, @Param("name") String name, @Param("sex") String sex,
               @Param("age") int age, @Param("mobile") String mobile);


    @Select("select * from user")
    List<User> getUSerList();
}
