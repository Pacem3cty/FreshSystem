package person.chenyuwen.entity;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-21 15:34
 */
public class MyRequest {

    String lockerId;    //属于哪个柜子
    int serialNum;      //编号
    int isOccupied;     //是否被占用
    String occupyId;         //占用者

    String userName;
    String url;

    @Override
    public String toString() {
        return "MyRequest{" +
                "lockerId='" + lockerId + '\'' +
                ", serialNum=" + serialNum +
                ", isOccupied=" + isOccupied +
                ", occupyId='" + occupyId + '\'' +
                ", userName='" + userName + '\'' +
                ", url='" + url + '\'' +
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MyRequest() {
    }

    public MyRequest(String lockerId, int serialNum, int isOccupied, String occupyId, String userName, String url) {
        this.lockerId = lockerId;
        this.serialNum = serialNum;
        this.isOccupied = isOccupied;
        this.occupyId = occupyId;
        this.userName = userName;
        this.url = url;
    }
}
