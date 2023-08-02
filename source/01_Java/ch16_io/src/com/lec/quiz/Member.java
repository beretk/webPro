package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birth;
	private String address;
	public Member() {}
	public Member(String name, String tel, Date birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		if(birth != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return name + "\t" + tel + "\t" + sdf.format(birth) + "생\t" + address + "\n";
	}
		return name + "\t" + tel + "\t생일모름" + address + "\n";
	}
}
