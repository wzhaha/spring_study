package com.example.controller;

import com.example.demo.service.RedisService;
import com.example.model.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author 王志
 * <p>
 * 1.在微服务中基本类上都加RestController
 * 2.RestController修饰的类下的所有方法都是返回json的，不要写之前的@ResponseBody
 * 3。如果启动项目？
 */

@Api("hello controller")
@RestController
public class HelloController {
    @Autowired
    RedisService redisService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    //初始化的时候调用初始化参数
    @Value("${name}")
    private String name;
    @Value("${http_url}")
    private String url;


    @RequestMapping(method = GET, value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(greeting);
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return greeting;
    }

    @ApiOperation("默认页面")
    @RequestMapping("/")
    public String index() {
        String result = "hello "+name;
        return result;
    }

    /**
     * @param
     * @return 全局捕获异常：使用AOP技术，采用异常通知
     */
    @ApiOperation("测试全局异常")
    @ApiImplicitParam(name = "i",value = "请求参数",required = true)
    @RequestMapping("/errortest")
    public String testError(int i) {
        int j = 1 / i;
        return "success" + j;
    }

    @RequestMapping("/testLog")
    public String testLog() {
        return "success";
    }

    @RequestMapping("/getname")
    public String getName() {
        return name;
    }

    @RequestMapping("/testUrl")
    public String testUrl() {
        return url;
    }

    @RequestMapping("/redisTest")
    public Object redisTest(){
        return redisService.getKey("haha");
    }
}
