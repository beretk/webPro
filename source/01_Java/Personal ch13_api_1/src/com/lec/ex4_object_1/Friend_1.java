package com.lec.ex4_object_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend_1 {
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	public Friend_1(String name, String phone, String address, Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름: " + name + "\n핸드폰: " + phone + "\n주소: " + address + "\n생일: " + sdf.format(birthday) + "\n";
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthday() {
		return birthday;
	}
	
}
