package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
<<<<<<< HEAD
	private Date birthday;
	private String address;
	public Member() {}
	public Member(String name, String tel, Date birthday, String address) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
=======
	private Date birth;
	private String address;
	public Member(String name, String tel, Date birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		this.address = address;
	}
	@Override
	public String toString() {
<<<<<<< HEAD
		if(birthday !=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			return name + "\t" + tel + "\t" +sdf.format(birthday) + "��\t" + address + "\n";
		}
			return name + "\t" + tel + "\t���ϸ�\t" + address +"\n";
	}
=======
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "�̸�" + name + "\t��ȭ" + tel + "\t����" + sdf.format(birth) + "\t�ּ�" + address + "\n";
	}
	
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
}
