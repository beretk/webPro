package com.lec.ex;

public class Ex8 {
	public static void main(String[] args) {
		System.out.println("====비트연산자====");
		int n1 = 10;
		int n2 = 5;
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  & = 0 0 0 0 0
		int result = n1 & n2;
		System.out.printf("n1 & n2 =");// 비트 연산자
		// 비트를 사용해 연산하는 연산자로서,
		// 정수와 정수 형태의 연산만 가능합니다.
		// AND(&), OR(|), XOR(^)
		System.out.println(result);
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  | = 0 1 1 1 1
		result = n1 | n2;
		System.out.printf("n1 | n2 =");
		System.out.println(result);
		
		// 비트연산자 XOR(^)
		// 좌항과 우항의 각 비트를 비교하여
		// 서로 다른 값을 가지는 자리를 1로 돌려주는 연산자
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  ^ = 0 1 1 1 1
		result = n1 ^ n2;
		System.out.printf("n1 ^ n2 =");
		System.out.println(result);	
	}

}
