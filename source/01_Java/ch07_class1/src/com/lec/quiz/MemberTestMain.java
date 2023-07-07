package com.lec.quiz;

public class MemberTestMain {
	public static void main(String[] args) {
		Member customer = new Member("aaa", "xxx","홍길동", "hong@company.com", "서울 강남구", "2000-01-01", 'M');
		System.out.println(customer.infoPrint());
		
		
	}
}
