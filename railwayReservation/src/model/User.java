package model;

public class User {

    private  int userId;
    private String userName;
    private Long mobNumber;

    private float bal;
    private String pswd;

    public User(int userId,String userName,Long mobNumber,float bal,String pswd) {
        this.userId = userId;
        this.userName = userName;
        this.mobNumber = mobNumber;
        this.bal = bal;
        this.pswd = pswd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public float getBal() {
        return bal;
    }

    public void setBal(float bal) {
        this.bal = bal;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


}
