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

    /**
     * @Description 
     * @author luzy
     * @date 2018/7/14 14:42
     * @param [model]
     * @return java.lang.String
     */
    @RequestMapping("/index")
    public String index(Model model){
      
        System.out.println("首页1");
        model.addAttribute("name","world");
        return "index";
    }
}
