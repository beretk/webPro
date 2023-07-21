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
			return name + "\t" + tel + "\t" +sdf.format(birthday) + "积\t" + address + "\n";
		}
			return name + "\t" + tel + "\t积老葛抚\t" + address +"\n";
	}
=======
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "捞抚" + name + "\t傈拳" + tel + "\t积老" + sdf.format(birth) + "\t林家" + address + "\n";
	}
	
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
}
