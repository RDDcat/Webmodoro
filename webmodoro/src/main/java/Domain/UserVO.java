package Domain;

public class UserVO {
	long userId;
	String userName;
	String passwd;
	String contact;
	
	public UserVO(String name, String passwd, String contact) {
		this.userName = name;
		this.passwd = passwd;
		this.contact = contact;
	}
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
