package com.springcloud.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springcloud默认支持三种注册中心：
 * eureka，zookeeper，consul
 * <p>
 * 客户端调用：
 * 使用rest或者feign
 */

/**
 * 客户端调用：
 *  使用rest或者feign
 */

/**
 * eureka的自我保护机制
 *
 */
@SpringBootApplication
@EnableEurekaServer //表示开启eureka注册中心服务
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}
