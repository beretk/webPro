package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birth;
	private String address;
	public Member(String name, String tel, Date birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "�̸�" + name + "\t��ȭ" + tel + "\t����" + sdf.format(birth) + "\t�ּ�" + address + "\n";
	}
	
}
