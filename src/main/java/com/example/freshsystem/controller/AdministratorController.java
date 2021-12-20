package com.example.freshsystem.controller;


import com.example.freshsystem.dao.StaffDao;
import com.example.freshsystem.domain.Staff;
import com.example.freshsystem.service.impl.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ᛟ
 * @date 2021/6/7 - 16:31
 */
@RestController
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @RequestMapping(value = "/printAllStaff",produces = "application/json;charset=UTF-8")
    public List<Staff> printAllStaff(){//获取员工信息
        return administratorService.getStaffInfo();
    }

    @RequestMapping(value = "/updateStaff",produces = "application/json;charset=UTF-8")
        public List<Staff> updateStaff(String staffId,String staffName,String password,Integer permission){//修改员工信息
            administratorService.updateStaff(staffId,staffName,password,permission);
            return administratorService.getStaffInfo();
        }

    @RequestMapping(value = "/insertStaff",produces = "application/json;charset=UTF-8")
    public List<Staff> insertStaff(String staffId,String staffName,String password,Integer permission){//增加员工信息
        administratorService.insertStaff(staffId,staffName,password,permission);
        return administratorService.getStaffInfo();
    }

    @RequestMapping(value = "/deleteStaff",produces = "application/json;charset=UTF-8")
    public List<Staff> deleteStaff(String staffId){//删除员工信息
        administratorService.deleteStaff(staffId);
        return administratorService.getStaffInfo();
    }
}
