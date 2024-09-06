public class GuestRecord {
    private String name;
    private int deskNo;
    private String entryTime;
    private String chooseMealTypee;
    private String exitTime;
    private int guestId;
    

    public GuestRecord(String name) {
        this.name = name;
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public int getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(int deskNo) {
        this.deskNo = deskNo;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setMealType(String chooseMealType) {
        this.chooseMealTypee=chooseMealType;
}

}