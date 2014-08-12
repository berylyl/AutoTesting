package jm.bean;

public class User {
	private Integer uid;
	private String  uname;
	private String  passwd;
	private String  fulname;
	private String  email;
	
	
	
	public String getFulname() {
		return fulname;
	}
	public void setFulname(String fulname) {
		this.fulname = fulname;
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
