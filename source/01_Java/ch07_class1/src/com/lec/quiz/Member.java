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
		String str = (gender=='M' || gender=='m')? "����" : (gender=='F' || gender=='f')? "����" :"-";
		String result = "���̵� : " + id + "\n";
		result += "��й�ȣ : " + pw + "\n";
		result += "��   �� : " + name + "\n";
		result += "�̸��� : " + email + "\n";
		result += "��   �� : " + address + "\n";
		result += "��   �� : " + birth + "\n";
		result += "��   �� : " + str;
		return result;
		
	}
}



