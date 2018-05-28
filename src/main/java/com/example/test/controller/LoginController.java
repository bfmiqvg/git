package com.example.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.test.domain.User;
import com.example.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Date:Created by luzy on 2018/4/23.
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    protected static Logger log= LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage(Model model,HttpServletRequest request) {
       /* String msg=request.getParameter("msg");
        if(msg!=null){
            model.addAttribute("msg",msg);
        }*/
        return "login";
    }

    @RequestMapping("/login")
    private String login(Model model,String userName, String password, HttpServletRequest request,RedirectAttributes attributes){
        log.info("开始登陆");
        String newPassword="";
       /* if(password!=null&&password.length()>0){
            newPassword=userService.encryptPassword(userName,password);
        }*/
        newPassword=userService.encryptPassword(userName,password);
        User user=userService.findUser(userName,newPassword);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/index";
        }else {
          //  attributes.addAttribute("msg","用户名或密码错误");
            attributes.addFlashAttribute("msg","用户名或密码错误");
            return "redirect:loginPage";
        }
    }

    @RequestMapping("/rigisterPage")
    private String rigisterPage(){
        return "rigister";
    }

    @RequestMapping("/rigister")
    @ResponseBody
    private JSONObject rigister(@RequestParam("userName")String userName, @RequestParam("password")String password, HttpServletResponse response){
        User user=userService.findUserByName(userName);
       // response.setHeader("Content-Type", "application/json;charset=UTF-8");
        JSONObject  jsonObject;
        if(user!=null){
            String json="{\"code\":-1,\"msg\":\"用户名已存在\"}";
            jsonObject= JSON.parseObject(json);
            return jsonObject;
        }else {
            user=new User();
            user.setLoginName(userName);
            user.setPassword(password);
            user.setCtime(new Date());
            userService.save(user);
            jsonObject=JSON.parseObject("{\"code\":0,\"msg\":\"注册成功\"}");
            return jsonObject;
        }
    }


    @RequestMapping("/logout")
    private String logout(Model model,HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if(user!=null){
            session.invalidate();
        }
        return "redirect:loginPage";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    private String updatePassword(Model model,HttpServletRequest request){
        log.info("更新密码");
        List<User> list=null;
        try {
            list=userService.findAll();
            for(User user:list){
                userService.updatePassword(user);
            }
            return "更新成功";
        }catch (Exception E){
            E.printStackTrace();
            return "更新失败";
        }
    }


}
