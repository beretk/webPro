package com.lec.ex02;
//method1(일반),method2(일반)
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("Childclass의 method1 - 추상메소드라서 오버라이드함");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 그냥 오버라이드함");
	}
	public void method4() {
		System.out.println("ChildClass의 method4");
	}
}
