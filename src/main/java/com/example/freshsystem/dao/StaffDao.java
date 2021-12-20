package com.example.freshsystem.dao;

import com.example.freshsystem.domain.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-03 15:23
 */


@Repository
@Component
@Mapper
public interface StaffDao {

    //获取所有职员
    @Select("select * from staff")
    List<Staff> selectAllStaff();

    //获取所有的配送员
//    @Select("SELECT `staffid`,`staffname`,`password`,`permission`" +
//            "FROM `freshsystem`.`staff`" +
//            "WHERE `permission` = 1;")
    @Select("select * from staff where permission = 1")
    List<Staff> selectAllDeliverMan();

    //获取所有员工
    @Select("")
    List<Staff> selectAllYuanGong();
    //获取所有系统管理员（系统管理员只有一个，用户名 admin ）
    @Select("")
    List<Staff> selectAllAdmin();

    //添加员工
    @Insert("insert into staff(staffId,staffName,password,permission)"+"values(#{staffId},#{staffName},#{password},#{permission})")
    boolean addStaff(Staff staff);

    //修改员工信息
    @Update("update staff set staffId = #{staffId},staffName = #{staffName},password = #{password},permission = #{permission} where staffId = #{staffId}")
    boolean updateStaff(Staff staff);

    //删除员工      工号
//    @Delete("")
//    int delete(String staffId);

    @Delete("delete from staff where staffId = #{staffId}")
    boolean deleteStaff(String staffId);
}
