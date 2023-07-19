package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
		ClassEx obj =  new ClassEx();
		obj.method1();
		obj.method2();
		InterfaceEx1 obj1 = new ClassEx();
		obj1.method1();
		InterfaceEx2 obj2 = new ClassEx();
		obj2.method2();
		System.out.println("CONSTAT_NUM : "+ InterfaceEx1.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : "+ ClassEx.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : "+ obj.CONSTANT_NUM);
		System.out.println("CONSTANT_STRING :" + InterfaceEx2.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING :"+ ClassEx.CONSTANT_NUM);
		
		
	}
}
