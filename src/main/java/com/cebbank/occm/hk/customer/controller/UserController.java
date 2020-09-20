package com.cebbank.occm.hk.customer.controller;

import com.cebbank.occm.hk.customer.pojo.User;
import com.cebbank.occm.hk.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  用户管理控制器
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    //登录功能
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        Model model){
        //提供数据查询用户的信息。
        User user = service.query(username,password);
        System.out.println(user);
        if (user != null){
            //存入session
            HttpSession session = request.getSession();
            session.setAttribute("USER_INFO",user);
            model.addAttribute("user",user);
            return "redirect:/file/showALL";
        }
     
        return "redirect:/";
    }

    //注销功能
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //删除session
        session.removeAttribute("USER_INFO");
        return "redirect:/";
    }

}
