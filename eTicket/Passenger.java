public class Passenger {
    private String passName;
    private Long mobLong;

    public Passenger(String passName, Long mobLong) {
        this.passName = passName;
        this.mobLong = mobLong;
    }

    // getters and setters...
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	public Long getMobLong() {
		return mobLong;
	}
	public void setMobLong(Long mobLong) {
		this.mobLong = mobLong;
	}
}
