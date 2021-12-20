package person.chenyuwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import person.chenyuwen.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-18 14:16
 */

@Controller
public class LoginController {

    @Autowired
    LoginService loginServiceImpl;

    @RequestMapping(value = "login" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView login(String name , String psw , ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response){
        System.out.println("do login");
        modelAndView.setViewName("loginFailure");
        if(loginServiceImpl.login(name,psw)){
            HttpSession session = request.getSession();
            //在session存入userName
            session.setAttribute("userNameInSession",name);
            modelAndView.addObject("userName",name);
            modelAndView.setViewName("person_index");
        };
        return modelAndView;
    }

    @RequestMapping(value = "register" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView register( String name , String psw , ModelAndView modelAndView){
        System.out.println("do register");
        modelAndView.setViewName("loginFailure");
        if(loginServiceImpl.register(name,psw)){
            modelAndView.setViewName("registerSuccess");
        };
        return modelAndView;
    }
}
