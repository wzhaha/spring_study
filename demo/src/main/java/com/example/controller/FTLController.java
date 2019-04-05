package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * freemarker视图层
 */

@Controller
public class FTLController {

    @RequestMapping("/ftlIndex")
    public String ftlIndex() {
        return "ftlIndex";
    }

}
