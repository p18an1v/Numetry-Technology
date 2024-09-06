package model;

public class Passenger {

    private String passName;
    private Long mobNumber;
    private int seatNum;

    public Passenger(String passName, Long mobNumber,int seatNum) {
        this.passName = passName;
        this.mobNumber = mobNumber;
        this.seatNum = seatNum;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public Long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}
