package person.chenyuwen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.chenyuwen.entity.User;
import person.chenyuwen.entity.UserDao;
import person.chenyuwen.service.LoginService;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 17:57
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean login(String userName, String password) {
        if(userDao.selectUser(userName,password).isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public boolean register(String userName, String password) {
        if (isNumber(userName)){
            return userDao.addUser(userName,password);
        }
        else {
            System.err.println("用户名不是纯数字组成");
            return false;
        }
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
