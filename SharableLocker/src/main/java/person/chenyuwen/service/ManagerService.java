package person.chenyuwen.service;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-20 11:54
 */
public interface ManagerService {
    boolean createLocker(String lockerId,int capacity);
    boolean destroyLocker(String lockerId);
    boolean clearLocker(String lockerId);
}
