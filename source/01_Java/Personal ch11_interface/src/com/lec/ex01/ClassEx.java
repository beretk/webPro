package com.lec.ex01;

public class ClassEx implements InterfaceEx1,InterfaceEx2{

	@Override
	public void method2() {
		System.out.println("실제 구현은 implements한 클래스에서함 - method1");
		
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements한 클래스에서함 - method2");
		
	}

}
