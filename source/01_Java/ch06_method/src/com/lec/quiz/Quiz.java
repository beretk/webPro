package com.lec.quiz;
<<<<<<< HEAD

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
=======
import java.util.Scanner;
public class Quiz {
	public static void main(String[] args) {
		// 사용자로 부터 2~9까지의 원하는 구구단을 받는다.
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("출력을 원하는 구구단 수는 ?(2~9단까지만 돼)");
			dansu = sc.nextInt();
		}while(dansu < 2 || dansu>9);
		guguPrint(dansu);// 사용자로부터 받은 수의 구구단을 출력
	}
	private static void guguPrint(int dansu) {// 사용자로부터 받은 수의 구구단을 출력
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
		}
	}
}
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
