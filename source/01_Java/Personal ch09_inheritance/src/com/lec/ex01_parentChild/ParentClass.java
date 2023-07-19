package com.lec.ex01_parentChild;

public class ParentClass {
	public String pstr = "부모클래스";
	public ParentClass() {
		System.out.println("부모클래스 생성자 함수");
	}
	public void getPapaname() {
		System.out.println("아빠이름 : 홍길동");
	}
	public void getManiname() {
		System.out.println("엄마이름 : 김길숙");
	}
}
