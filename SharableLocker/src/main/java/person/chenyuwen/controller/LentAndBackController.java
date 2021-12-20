package person.chenyuwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import person.chenyuwen.entity.LockerUnit;
import person.chenyuwen.entity.MyRequest;
import person.chenyuwen.service.LentAndReturnService;
import person.chenyuwen.service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 20:34
 */

 /*
  * 显示柜子
  * 借柜子
  * 还柜子
  */


@Controller
public class LentAndBackController {

    @Autowired
    LentAndReturnService lentAndReturnServiceImpl;

    //显示所有可以借的柜子
    @RequestMapping(value = "showFreeLockerUnit" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView showFreeLockerUnit(HttpServletRequest request,ModelAndView modelAndView){
        //先检查一下该用户是否已经借了
        String userName = (String) request.getSession().getAttribute("userNameInSession");
        LockerUnit lockerUnit =  lentAndReturnServiceImpl.getUserLockerUnit(userName);
        if(lockerUnit != null){     //说明已经借了
            modelAndView.setViewName("Failure");
            return modelAndView;
        }
        System.out.println("do showAllLockerUnit");
        modelAndView.setViewName("showAllLockerUnit");
        List<LockerUnit> allLockerUnit = lentAndReturnServiceImpl.getAllLockerUnit();
        for (int i = 0; i < allLockerUnit.size(); i++) {
            if(allLockerUnit.get(i).getIsOccupied() == 1){
                allLockerUnit.remove(i);
            }       //把不可借的给移除链表
        }           //在model and view加入
        modelAndView.addObject("allLockerUnit",allLockerUnit);
        return modelAndView;
    }

    //显示所有的柜子
    @RequestMapping(value = "showAllLockerUnit" , method = RequestMethod.POST)     //请求名称
    @ResponseBody
    public ModelAndView showAllLockerUnit(ModelAndView modelAndView){
        System.out.println("do showAllLockerUnit");
        modelAndView.setViewName("showAllLockerUnit");
        List<LockerUnit> allLockerUnit = lentAndReturnServiceImpl.getAllLockerUnit();
        for (LockerUnit lockerUnit : allLockerUnit) {
            System.out.println("lockerUnit = " + lockerUnit);
        }
        modelAndView.addObject("allLockerUnit",allLockerUnit);

        return modelAndView;
    }

    //显示我的借柜情况
    @RequestMapping(value = "showMyLent" ,method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView showMyLent(HttpServletRequest request, ModelAndView modelAndView) {
        String userName = (String) request.getSession().getAttribute("userNameInSession");
        LockerUnit lockerUnit =  lentAndReturnServiceImpl.getUserLockerUnit(userName);
        if(lockerUnit == null){         //没有借
            System.err.println("no locker unit you have lent");
            modelAndView.setViewName("Failure");
        }                               //借了
        modelAndView.setViewName("showMyLockerUnit");
        modelAndView.addObject("ThisLockerId",lockerUnit.getLockerId());
        modelAndView.addObject("ThisSerialId",lockerUnit.getSerialNum());
        return modelAndView;
    }

    //借柜子
    @RequestMapping(value = "lent" ,method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView lentLockerUnit(String lockerId, Integer serialNum, HttpServletRequest request, ModelAndView modelAndView){
        System.out.println("do lent unit");
        //获取用户名
        String userName = (String) request.getSession().getAttribute("userNameInSession");
        //获取借的信息
        LockerUnit userLockerUnit = lentAndReturnServiceImpl.getUserLockerUnit(userName);
        if(userLockerUnit != null){         //一次只能借一个
            modelAndView.setViewName("Failure");
        }
        System.out.println("userName = " + userName + ", lockerId = " + lockerId + ", serialNum = " + serialNum + ", modelAndView = " + modelAndView);
        //如果更新成功
        if(lentAndReturnServiceImpl.lentLockerUnit(userName, lockerId, serialNum)){
            System.out.println("lent successfully");
        }else System.out.println("lent failure");
        modelAndView.setViewName("person_index");
        return modelAndView;
    }

    //归还我所借的柜子
    @RequestMapping(value = "returnMyLent" ,method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView returnLockerUnit(HttpServletRequest request, ModelAndView modelAndView){
        System.out.println("do back unit");
        //获取用户名
        String userName = (String) request.getSession().getAttribute("userNameInSession");
        //如果归还成功
        if(lentAndReturnServiceImpl.returnLockerUnit(userName)){
            System.out.println("back successfully");
        }else System.out.println("back failure");
        modelAndView.setViewName("person_index");
        return modelAndView;
    }

}
