public class studData {
   
    private int studId;
	private String studName;
	public studData(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
}
