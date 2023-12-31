package com.lec.quiz;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birthday;
	public Friend(String name, String tel, String address, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birthday = birthday;	
	}@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름: " + name + "\n전화: " + tel + "\n주소: "+ address + "\n생일: " + sdf.format(birthday) + "\n";
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthday() {
		return birthday;
	}
	
}
