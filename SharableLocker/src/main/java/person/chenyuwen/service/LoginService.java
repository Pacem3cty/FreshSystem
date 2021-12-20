package person.chenyuwen.service;

import org.springframework.stereotype.Service;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-18 14:42
 */

@Service
public interface LoginService {
    public boolean login(String userName,String password);
    public boolean register(String userName,String password);
}
