package com.y3.entity;

import java.util.Date;

/**
 * 管理员用户实体类
 * @author Entity-G
 */
public class Admin {

	private int a_id;//管理员id
	private String a_name;
	private int a_age;
	private int a_sex;
	private String a_pwd;
	private String a_phone;
	private String a_email;
	private String a_address;
	private Date a_birthday;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public int getA_age() {
		return a_age;
	}
	public void setA_age(int a_age) {
		this.a_age = a_age;
	}
	public int getA_sex() {
		return a_sex;
	}
	public void setA_sex(int a_sex) {
		this.a_sex = a_sex;
	}
	public String getA_pwd() {
		return a_pwd;
	}
	public void setA_pwd(String a_pwd) {
		this.a_pwd = a_pwd;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public Date getA_birthday() {
		return a_birthday;
	}
	public void setA_birthday(Date a_birthday) {
		this.a_birthday = a_birthday;
	}
	
}
