package com.lec.ex4_human.kid;
// main 에서 Kid kid = new kid("홍길동");
public class Kid {
	private String name ;
	public Kid(String name) {
		this.name = name;
		System.out.println("name를 초기화는 Kid 생성자 함수");
	}
}
