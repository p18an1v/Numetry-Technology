package model;
import java.util.*;
public class Train {

    private String pickUp;
    private String desti;
    private String express;
    private int trainNumber;

    private  float price;

    public Train(String pickUp,String desti,String express,int trainNumber,float price) {
        this.pickUp = pickUp;
        this.desti = desti;
        this.express=express;
        this.trainNumber=trainNumber;
        this.price=price;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
