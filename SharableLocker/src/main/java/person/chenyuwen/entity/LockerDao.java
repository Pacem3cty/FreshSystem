package person.chenyuwen.entity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-20 11:55
 */

@Repository
@Mapper
public interface LockerDao {

    //有个num属性，在初始化的时候直接设为0
    @Insert("INSERT INTO `powersupply`.`locker`(`locker_id`,`capacity`)VALUES (#{lockerId},#{capacity});")
    boolean addOneLocker(String lockerId,int capacity);

    //获取柜子容量
    @Select("SELECT `capacity`FROM `powersupply`.`locker` WHERE `locker_id`= #{lockerId} ;")
    int getLockerCapacity(String lockerId);

    //删去一个柜子
    @Delete("DELETE FROM `powersupply`.`locker` WHERE `locker_id` = #{lockerId};")
    int deleteLocker(String lockerId);

    //获取所有柜子id
    @Select("SELECT  `locker_id` FROM `powersupply`.`locker`;")
    List<String> getAllLockerId();

    //查看某个柜子的存储单元
    @Select("SELECT  `lockerId`,  `serialNum`,  `isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` WHERE `lockerId` = #{lockerId};")
    List<LockerUnit> selectLockerUnit(String lockerId);



}
