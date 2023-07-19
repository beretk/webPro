package com.lec.ex0_janmuri;
// 자바 파일에 public class 한개씩 꼭 구현
class PersonInfo{//이방법 사용하지 말것
	private String name;
	private int age;
	private char gender;
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름:" + name + ", 나이:" + age + ", 성별:" + gender);
	}
}
public class PersonTestMain {
	public static void main(String[] args) {
		PersonInfo person1 = new PersonInfo("홍길동", 22, 'm');
		PersonInfo person2 = new PersonInfo("홍길순", 21, 'f');
		person1.print();
	}
}




