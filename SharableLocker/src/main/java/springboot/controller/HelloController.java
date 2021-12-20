package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.enitiy.Goods;
import springboot.service.MyService;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-18 19:30
 */

@RestController
public class HelloController {

    @Autowired
    MyService myServiceImpl1;

    @RequestMapping(value = "welcome",method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView sayHello(ModelAndView modelAndView){
        System.out.println("do select");
        modelAndView.setViewName("stock");
        List<Goods> list = myServiceImpl1.printInfo();
        modelAndView.addObject("goodList",list);
        return modelAndView;
    }
}
