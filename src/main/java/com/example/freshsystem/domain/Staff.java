package com.example.freshsystem.domain;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-03 15:14
 */
public class Staff {

    String staffId;     //员工工号
    String staffName;   //员工名字
    String password;    //登陆密码
    Integer permission;     //权限，3是系统管理员，2是员工，1是配送员

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Staff(){

    }
}
