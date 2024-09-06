public class Student {

    private int  studId;
	private String studName;
	private String studAddress;
	private long studContact;
	public Student(int studId, String studName, String studAddress, long studContact) {
		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		this.studContact = studContact;
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

	public String getStudAddress() {
		return studAddress;
	}

	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}

	public long getStudContact() {
		return studContact;
	}

	public void setStudContact(long studContact) {
		this.studContact = studContact;
	}
}