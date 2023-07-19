package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend_1 {
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	public Friend_1() { }
	public Friend_1(String name, String phone, String address, Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		if(birthday !=null) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름:"+name+"\n전화:"+phone+"\n주소:"+address+"\n생일:"+sdf.format(birthday)+"\n"; 
	}
		return "이름:"+name+"\n전화:"+phone+"\n주소:"+address;
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
