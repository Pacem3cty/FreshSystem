package person.chenyuwen.service;

import person.chenyuwen.entity.LockerUnit;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 19:15
 */

public interface LentAndReturnService {

    //借一个柜子
    boolean lentLockerUnit(String userName,String LockerId,int serialNum);

    //还柜子
    boolean returnLockerUnit(String userName);

    //查看用户的存储单元
    LockerUnit getUserLockerUnit(String userName);

    //查看柜子的存储单元
    List<LockerUnit> getLockerUnitByLockerId(String LockerId);

    //获取所有的柜子号
    List<String> getAllLockerId();

    //获取所有的存储单元
    List<LockerUnit> getAllLockerUnit();


}
