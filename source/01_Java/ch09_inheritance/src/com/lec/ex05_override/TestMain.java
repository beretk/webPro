package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);		
		System.out.println("두 객체가 같은지?" + pObj1.equals(pObj2));
		pObj1.method1();
		pObj1.method2();
		pObj2.method1();
		System.out.println("---------------------------");
		Child cObj1 = new Child();//Parent() -> Child()
		Child cObj2 = new Child(10);//Parent() -> Child(10)
		cObj1.method1();
		cObj1.method2();
		cObj2.method3();
		//pObj2.method3();불가
		System.out.println("두객체 (cObj들)가 같은지?" + cObj1.equals(cObj2));
		System.out.println("----------------------------");
		//Child obj = new Child();
		Parent obj = new Child();
		obj.method1();
		obj.method2();
		//obj.method3(); obj 변수의 타입이 Parent
		if(obj instanceof Child) { // obj가 가르키는 곳이 Child 객체(인스턴스)인지
			((Child)obj).method3();// 객체의 명시적인 형변환			
		}else {
			System.out.println("형변환 불가");
		}
	}
}




