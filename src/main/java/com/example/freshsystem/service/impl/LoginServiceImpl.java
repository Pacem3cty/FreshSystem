package com.example.freshsystem.service.impl;

import com.example.freshsystem.dao.LoginDao;
import com.example.freshsystem.domain.Staff;
import com.example.freshsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 11:10
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired

    LoginDao loginDao;

    @Override
    public boolean validateAccount(String staffId, String password) {
        Staff staff=new Staff();
        staff.setStaffId(staffId);
        staff.setPassword(password);
        List<Staff> staffs=loginDao.selectAccount(staff);
        if(staffs.isEmpty()){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public int getAccountPermission(String staffId, String password) {
        Staff staff=new Staff();
        staff.setStaffId(staffId);
        staff.setPassword(password);
        int permission = loginDao.getPermission(staff);
        return permission;
    }
}
