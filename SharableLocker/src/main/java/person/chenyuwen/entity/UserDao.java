package person.chenyuwen.entity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 17:42
 */

@Repository
@Mapper
public interface UserDao {

    @Select("SELECT`user_name`,`password`FROM `powersupply`.`user` WHERE `user_name` = #{name} AND `password` = #{psw};")
    public List<User> selectUser(String name,String psw);

    @Select("SELECT`user_name`,`password`FROM `powersupply`.`user` WHERE `user_name` = #{name};")
    @ResultType(User.class)
    public User getUser(String name);


    @Insert("INSERT INTO `powersupply`.`user`(`user_name`,`password`)VALUES (#{name},#{psw});")
    public boolean addUser(String name,String psw);

}
