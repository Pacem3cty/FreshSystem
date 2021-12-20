package person.chenyuwen.entity;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-18 14:19
 */

public class LockerUnit {

    String lockerId;        //属于哪个柜子
    int serialNum;          //编号
    int isOccupied;         //是否被占用
    String occupyId;         //占用者

    public LockerUnit(String lockerId, int serialNum, int isOccupied, String occupyId) {
        this.lockerId = lockerId;
        this.serialNum = serialNum;
        this.isOccupied = isOccupied;
        this.occupyId = occupyId;
    }

    @Override
    public String toString() {
        return "LockerUnit{" +
                "lockerId='" + lockerId + '\'' +
                ", serialNum=" + serialNum +
                ", isOccupied=" + isOccupied +
                ", occupyId='" + occupyId + '\'' +
                '}';
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(int isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getOccupyId() {
        return occupyId;
    }

    public void setOccupyId(String occupyId) {
        this.occupyId = occupyId;
    }
}
