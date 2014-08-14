package jm.bean;

public class User {
	private Integer uid;
	private String  uname;
	private String  passwd;
	private String  fullname;
	private String  email;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String uname,String email) {
		this.uname = uname;
		this.email = email;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
}
