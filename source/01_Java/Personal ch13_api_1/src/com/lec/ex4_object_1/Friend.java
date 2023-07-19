package com.lec.ex4_object_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birth;
	public Friend(String name, String tel, String address, Date birth) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM=dd");
		return "이름: " + name + "\n전화: " + tel + "\n주소: "+ address + "\n생일: " + sdf.format(birth) + "\n";
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
	public Date getBirth() {
		return birth;
	}
}
