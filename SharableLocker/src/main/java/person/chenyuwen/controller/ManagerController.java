package person.chenyuwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import person.chenyuwen.entity.LockerUnit;
import person.chenyuwen.service.LentAndReturnService;
import person.chenyuwen.service.ManagerService;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-20 16:46
 */

@Controller
public class ManagerController {

    @Autowired
    ManagerService managerServiceImpl;

    @RequestMapping(value = "create" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView createLocker(String lockerName, int capacity ,ModelAndView modelAndView){
        System.out.println("do create");
        modelAndView.setViewName("Success");
        managerServiceImpl.createLocker(lockerName,capacity);
        return modelAndView;
    }

    @RequestMapping(value = "remove" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView removeLocker(String lockerId ,ModelAndView modelAndView){
        System.out.println("do remove");
        if(managerServiceImpl.destroyLocker(lockerId)){
            modelAndView.setViewName("Success");
            return modelAndView;
        }else {
            modelAndView.setViewName("Failure");
            return modelAndView;
        }
    }
}
