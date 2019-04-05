package com.example.execption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常
 * 1。json格式异常
 * 2。捕获返回页面异常
 * <p>
 * ResponseBody表示返回json
 * modeANdView 返回页面
 */

@ControllerAdvice(basePackages = "com.example.controller")
public class GlobalExecptionHandler {

    /**
     * 实际开发，错误要进行日志打印
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> errorJSON() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 500);
        res.put("message", "系统错误");
        return res;
    }
}
