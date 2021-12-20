package person.chenyuwen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.chenyuwen.entity.*;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 21:08
 */

@Service
public class LentAndReturnServiceImpl implements LentAndReturnService {

    @Autowired
    UserDao userDao;
    @Autowired
    LockerDao lockerDao;
    @Autowired
    LockerUnitDao lockerUnitDao;

    @Override
    public boolean lentLockerUnit(String userName, String LockerId,int serialNum) {
        boolean returnStatus = false;
        try {
            //获取存储单元
            LockerUnit lockerUnit = lockerUnitDao.getLockerUnit(LockerId, serialNum);
            System.out.println("before update ***");
            System.out.println(lockerUnit);
            //设置已借出
            lockerUnit.setIsOccupied(1);
            //设置柜子占用者
            lockerUnit.setOccupyId(userName);
            //更新数据
            lockerUnitDao.updateLockerUnit(lockerUnit);
            System.out.println("after update ***");
            System.out.println(lockerUnit);
            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return returnStatus;
        }
    }

    @Override
    public boolean returnLockerUnit(String userName) {
        boolean returnStatus = false;
        try {
            //获取用户的存储单元
            System.out.println("do service");
            LockerUnit lockerUnit = lockerUnitDao.getLockerUnitByUser(userName);
            System.out.println(lockerUnit);
            //把存储单元的占用者改成柜号，占用情况变0
            lockerUnit.setIsOccupied(0);
            lockerUnit.setOccupyId(lockerUnit.getLockerId());
            System.out.println("do update");
            lockerUnitDao.updateLockerUnit(lockerUnit);
            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return returnStatus;
        }
    }

    @Override       //获取用户借的柜子
    public LockerUnit getUserLockerUnit(String userName) {
        LockerUnit lockerUnit = lockerUnitDao.getLockerUnitByUser(userName);
        return lockerUnit;
    }

    @Override       //获取柜子id内的所有柜子
    public List<LockerUnit> getLockerUnitByLockerId(String LockerId) {
        //获取所有柜子单元
        List<LockerUnit> lockerUnitList = lockerUnitDao.getAllLockerUnitByLockerId(LockerId);
        return lockerUnitList;
    }

    @Override
    public List<String> getAllLockerId() {
        //返回链表，里面的是柜子id链表
        return lockerDao.getAllLockerId();
    }

    @Override
    public List<LockerUnit> getAllLockerUnit() {
        List<LockerUnit> lockerUnitList = lockerUnitDao.selectAllLockerUnit();
        return lockerUnitList;
    }

    public static boolean isNumber(String str){
        char[] chars = str.toCharArray();
        for(int i = 0;i < chars.length;i++){
            if(chars[i] < '0' && chars[i] > '9'){
                return false;
            }
        }
        return true;
    }


}
