package model;

public class Login {

    private Long mobNumber;
    private String pswd;

    public Login(Long mobNumber,String pswd) {
        this.mobNumber = mobNumber;
        this.pswd=pswd;
    }

    public Long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
