package person.chenyuwen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.chenyuwen.entity.Locker;
import person.chenyuwen.entity.LockerDao;
import person.chenyuwen.entity.LockerUnit;
import person.chenyuwen.entity.LockerUnitDao;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-20 11:54
 */

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    LockerDao lockerDao;
    @Autowired
    LockerUnitDao lockerUnitDao;

    @Override
    public boolean createLocker(String lockerId,int capacity) {
        boolean returnStatus = false;
        try {
            //添加一个新的柜子
            lockerDao.addOneLocker(lockerId,capacity);
            for (int i = 1; i < capacity+1; i++) {
                LockerUnit lockerUnit = new LockerUnit(lockerId,i,0,lockerId);
                //生成相应数量的存储单元
                lockerUnitDao.addLockerUnit(lockerUnit);
            }
            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("returnStatus = " + returnStatus);
            return returnStatus;
        }
    }

    @Override
    public boolean clearLocker(String lockerId) {
        boolean returnStatus = false;
        try {
            //最终目的是把lockerID对应的Unit，把状态改成0
            int lockerCapacity = lockerDao.getLockerCapacity(lockerId);
            for (int i = 1; i < lockerCapacity+1; i++) {
                //获取到存储单元
                LockerUnit lockerUnit = lockerUnitDao.getLockerUnit(lockerId,i);
                //设置为空闲
                lockerUnit.setIsOccupied(0);
                //更新到数据库
                lockerUnitDao.updateLockerUnit(lockerUnit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return returnStatus;
        }
    }

    @Override
    public boolean destroyLocker(String lockerId) {
        boolean returnStatus = false;
        try {
            int num1 = lockerDao.deleteLocker(lockerId);
            int num2 = lockerUnitDao.deleteLockerUnit(lockerId);
            System.out.println("num1 = " + num1);
            System.out.println("num2 = " + num2);
            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return returnStatus;
        }
    }

}
