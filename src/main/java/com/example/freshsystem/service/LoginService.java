package com.example.freshsystem.service;
/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 11:00
 */
public interface LoginService {
    //对账户进行验证
    boolean validateAccount(String staffId, String password);
    int getAccountPermission(String staffId,String password);
}
