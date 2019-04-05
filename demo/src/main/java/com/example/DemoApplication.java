package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * EnableAutoConfiguration 自动加载配置
 * ComponentScan  添加扫包，springboot默认扫当前包
 * SpringBootApplication中有很多注解，可以自动扫包，自动注解
 * <p>
 * mybatis两种启动，一种是在mapper上加mapper，一种是在启动时扫包
 * <p>
 * springboot事务管理
 * 1.事务分类
 * 声明事务，编程事务，
 * 2。事务原理
 * 通过aop，环绕通知进行拦截
 * 3。注意事项：不要try，因为要将异常抛出给外层
 * <p>
 * 垂直业务数据库：根据业务划分具体数据库
 * 多数据源：
 * 多数据源如何划分：1。分包（业务）。2。根据注解
 * 分包比较常见
 * <p>
 * 分布式事务：
 * 产生原因：多个不同的服务
 */

/**
 * mybatis两种启动，一种是在mapper上加mapper，一种是在启动时扫包
 */

/**
 * springboot事务管理
 * 1.事务分类
 *  声明事务，编程事务，
 * 2。事务原理
 *  通过aop，环绕通知进行拦截
 * 3。注意事项：不要try，因为要将异常抛出给外层
 */

/**
 * 垂直业务数据库：根据业务划分具体数据库
 * 多数据源：
 *  多数据源如何划分：1。分包（业务）。2。根据注解
 *  分包比较常见
 */

/**
 * 分布式事务：
 *  产生原因：多个不同的服务
 */

/**
 * 热部署原理：使用类加载器classloder重新读取字节码文件到jvm内存
 *  监听class文件的改变，改变则使用classloder重新读取
 *  （版本号或者版本时间）
 *
 *  热部署不推荐用于生产环境
 *  应用场景：本地开发提高运行效率
 */

@SpringBootApplication
@EnableAsync //开启异步调用
@EnableCaching //redis缓存
//@MapperScan(basePackages = {"com.example.demo.mapper", "com.example.demo1.mapper"})
public class DemoApplication {

    public static void main(String[] args) {
        //程序入口,默认端口号是8080
        SpringApplication.run(DemoApplication.class, args);
    }

}
