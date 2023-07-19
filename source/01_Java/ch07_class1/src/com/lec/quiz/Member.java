package com.lec.quiz;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	public Member() {}
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public String infoPrint() {
		String str = (gender=='M' || gender=='m')? "남자" : (gender=='F' || gender=='f')? "여자" :"-";
		String result = "아이디 : " + id + "\n";
		result += "비밀번호 : " + pw + "\n";
		result += "이   름 : " + name + "\n";
		result += "이메일 : " + email + "\n";
		result += "주   소 : " + address + "\n";
		result += "생   일 : " + birth + "\n";
		result += "성   별 : " + str;
		return result;
		
	}
}



