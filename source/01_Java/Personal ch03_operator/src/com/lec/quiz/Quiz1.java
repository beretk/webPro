package com.lec.quiz;

import java.util.Scanner;

//3의 배수 숫자 판단하기 : 사용자로부터 숫자를 입력 받고, 입력 받은 숫자가 3의 배수인지 파악
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int su = scanner.nextInt(); //입력받은 정수를 su에 할당
		String result = (su%3 == 0)? " 3의 배수" : "3 의 배수가 아님";
		System.out.println("입력하신수(" + su +")는" + result);
		System.out.printf("입력하신수(%d)는 %s", su, result);
	}
}
