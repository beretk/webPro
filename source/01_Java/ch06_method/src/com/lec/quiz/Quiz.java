package com.lec.quiz;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1=0;
		System.out.print("단수를 입력하세요.(2~9) : ");
		num1 = sc.nextInt();
		
		do {
		} while (num1 < 2 || num1 > 9); 
			System.out.print("올바른 값을 입력하세요.(2~9): ");
			
			mtd(num1);
		}
	private static void mtd(int num1) {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n", num1, i , num1*i );
		}
	}
}
