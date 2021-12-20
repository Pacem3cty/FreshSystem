package com.example.freshsystem.controller;

import com.example.freshsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 11:18
 */

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
        public String doLogin(String staffId, String password ) {
        if (loginService.getAccountPermission(staffId, password)==1) {//权限为配送员
            return "";
        }
        else if(loginService.getAccountPermission(staffId, password)==2){//权限为员工
            return "staffOperation";
        }
        else if(loginService.getAccountPermission(staffId, password)==3){//权限为系统管理员
            return "systemAdministrator";
        }
        else {
            return "error";
        }
    }
}
