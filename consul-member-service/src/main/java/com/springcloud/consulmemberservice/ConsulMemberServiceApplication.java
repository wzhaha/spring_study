package com.springcloud.consulmemberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsulMemberServiceApplication {

	@Autowired
	private RestTemplateBuilder builder;

	public static void main(String[] args) {
		SpringApplication.run(ConsulMemberServiceApplication.class, args);
	}


	//ribbon是客户端负载均衡器（rest请求中加loadbalance:开启别名方式，本地实现rpc远程调用）
	//	底层实现：
	//
	@Bean
	@LoadBalanced
	public RestTemplate get(){
		return builder.build();
	}



}
