package com.y3.entity;

/**
 * 用户实体类
 * @author Entity-G
 */
public class User {

	private int uid;//用户id
	private String uname;//用户姓名
	private String upwd;//用户密码
	private int usex;//用户性别
	private int uage;//用户年龄
	private String uaddress;//家庭住址
	private String uphone;//用户电话
	private String uemail;//用户email
	private String ubirthday;//用户出生年月
	
	public User() {}

	public User(int uid, String uname, String upwd, int usex, int uage, String uaddress, String uphone, String uemail,
			String ubirthday) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.uage = uage;
		this.uaddress = uaddress;
		this.uphone = uphone;
		this.uemail = uemail;
		this.ubirthday = ubirthday;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getUsex() {
		return usex;
	}

	public void setUsex(int usex) {
		this.usex = usex;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String string) {
		this.uphone = string;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	@Override
	public String toString() {
		char sex;
		if(this.usex == 0) {
			sex = '女';
		}else {
			sex = '男';
		}
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + sex + ", uage=" + uage
				+ ", uaddress=" + uaddress + ", uphone=" + uphone + ", uemail=" + uemail + ", ubirthday=" + ubirthday
				+ "]";
	}
	
}
