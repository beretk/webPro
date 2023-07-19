package com.lec.ex;
// 비트 연산자
// 비트를 사용해 연산하는 연산자로서,
// 정수와 정수 형태의 연산만 가능합니다.
// AND(&), OR(|), XOR(^)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 1; //  0 ~ 0 0 0 1
		int n2 = 2; //  0 ~ 0 0 1 0
		//             ------------
		//           &  0 ~ 0 0 0 0  (0)
		//           |  0 ~ 0 0 1 1  (3)
		System.out.println("n1 & n2 ^ " + (n1 & n2)); 
		System.out.println("n1 | n2 ^ " + (n1 | n2)); 
	}
}