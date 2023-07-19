package com.lec.quiz;

import java.util.Scanner;

//두수를 입력받아 두수가 같은지 결과를 O나 X로 출력 / 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수는 ");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수는 ");
		int num2 = scanner.nextInt();
		System.out.println("두수가 같은지 결과는 " +((num1 == num2)? "O" : "X"));
		System.out.println("첫번째 수가 더큰지 여부 " + ((num1>num2)? "O" : "X"));
	}
}
