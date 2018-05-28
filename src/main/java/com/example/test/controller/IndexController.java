package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date:Created by luzy on 2018/4/23.
 * @Description: 首页
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        System.out.println("首页");
        model.addAttribute("name","world");
        return "index";
    }
}
