package com.lec.ex01;

public class ClassEx implements InterfaceEx1,InterfaceEx2{

	@Override
	public void method2() {
		System.out.println("���� ������ implements�� Ŭ���������� - method1");
		
	}

	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ���������� - method2");
		
	}

}
