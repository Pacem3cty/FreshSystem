package com.example.freshsystem.service.impl;

import com.example.freshsystem.dao.StaffDao;
import com.example.freshsystem.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ᛟ
 * @date 2021/6/7 - 16:36
 */
@Service("administratorService")
public class AdministratorService {
    @Autowired
    StaffDao staffDao;

    public List<Staff> getStaffInfo(){//获取员工信息
        List<Staff> staffList = staffDao.selectAllStaff();
        return staffList;
    }

    public boolean insertStaff(String staffId,String staffName,String password,Integer permisson){//添加员工信息
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setStaffName(staffName);
        staff.setPassword(password);
        staff.setPermission(permisson);
        return staffDao.addStaff(staff);
    }

    public boolean deleteStaff(String staffId){//删除员工信息
        return staffDao.deleteStaff(staffId);
    }

    public boolean updateStaff(String staffId,String staffname,String password,Integer permission){//更新员工信息
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setStaffName(staffname);
        staff.setPassword(password);
        staff.setPermission(permission);
        return staffDao.updateStaff(staff);
    }

}
