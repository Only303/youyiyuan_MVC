package com.y3.entity;

/**
 * �û�ʵ����
 * @author Entity-G
 */
public class User {

	private int uid;//�û�id
	private String uname;//�û�����
	private String upwd;//�û�����
	private int usex;//�û��Ա�
	private int uage;//�û�����
	private String uaddress;//��ͥסַ
	private String uphone;//�û��绰
	private String uemail;//�û�email
	private String ubirthday;//�û���������
	
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
			sex = 'Ů';
		}else {
			sex = '��';
		}
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + sex + ", uage=" + uage
				+ ", uaddress=" + uaddress + ", uphone=" + uphone + ", uemail=" + uemail + ", ubirthday=" + ubirthday
				+ "]";
	}
	
}
