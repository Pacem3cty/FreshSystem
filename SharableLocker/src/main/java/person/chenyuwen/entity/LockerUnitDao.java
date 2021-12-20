package person.chenyuwen.entity;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-20 11:58
 */

@Repository
@Mapper
public interface LockerUnitDao {

    //添加一个存储单元
    @Insert("INSERT INTO `powersupply`.`locker_unit`(`lockerId`,`serialNum`,`isOccupied`,`occupyId`)VALUES (#{lockerId},#{serialNum},0,#{occupyId});")
    boolean addLockerUnit(LockerUnit lockerUnit);

    @Delete("DELETE FROM `powersupply`.`locker_unit` WHERE `lockerId` = #{lockerId};")
    int deleteLockerUnit(String lockerId);

    //update存储单元
    @Update("UPDATE `powersupply`.`locker_unit` SET `lockerId` = #{lockerId},`serialNum` = #{serialNum},`isOccupied` = #{isOccupied} ,`occupyId` = #{occupyId} WHERE `lockerId` = #{lockerId} AND `serialNum` = #{serialNum};")
    boolean updateLockerUnit(LockerUnit lockerUnit);

    //查询用户的储存单元
    @Select("SELECT `lockerId`, `serialNum`,`isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` WHERE `occupyId` = #{userName};")
    LockerUnit getLockerUnitByUser(String userName);

    //获取存储单元
    @Select("SELECT`lockerId`,`serialNum`,`isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` WHERE `lockerId` = #{lockerId} AND `serialNum` = #{serialNum};")
    LockerUnit getLockerUnit(String lockerId,int serialNum);

    //获取所有存储单元
    @Select("SELECT`lockerId`,`serialNum`,`isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` WHERE `lockerId` = #{lockerId} AND `serialNum` = #{serialNum};")
    LockerUnit getAllLockerUnit(String lockerId,int serialNum);

    //查看所有存储单元，按位置进行排序
    @Select("SELECT`lockerId`,`serialNum`,`isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` ;")
    List<LockerUnit> selectAllLockerUnit();

    //查看LockerId对应的所有存储单元，按位置进行排序
    @Select("SELECT`lockerId`,`serialNum`,`isOccupied`,`occupyId`FROM `powersupply`.`locker_unit` WHERE `lockerId` = #{lockerId};")
    List<LockerUnit> getAllLockerUnitByLockerId(String lockerId);

}
