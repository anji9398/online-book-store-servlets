package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable {
	private String uname, password, fName, lName, address, Mailid;
	private long phno;

	public AdminBean() {

	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailid() {
		return Mailid;
	}

	public void setMailid(String mailid) {
		Mailid = mailid;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

}
