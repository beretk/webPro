package com.lec.ex;
//비트 연산자
// 비트를 사용해 연산하는 연산자로서,
// 정수와 정수 형태의 연산만 가능합니다.
// AND(&), OR(|), XOR(^) 
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10;
        int n2 = 15;
        int result = n1 ^ n2;
        System.out.println("10 ^ 15 = " + result);

        System.out.println("11 ^ 11 = " + (11 ^ 11));
        System.out.println("0 ^ 10 = " + (0 ^ 10));
        System.out.println("14 ^ 13 = " + (14 ^ 13));
    }
}