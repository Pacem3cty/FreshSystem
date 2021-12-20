package com.example.freshsystem.dao;

import com.example.freshsystem.domain.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 10:50
 */
import java.util.List;

@Repository //注册到spring框架上
@Mapper //使用mybatis
public interface LoginDao {

    @Select("select * from staff where staffId=#{staffId} and password=#{password}")
    List<Staff> selectAccount(Staff staff);//登录验证
    @Select("select permission from staff where staffId=#{staffId} and password=#{password}")
    int getPermission(Staff staff);//登录验证并获取权限
}
