package com.lec.quiz;
<<<<<<< HEAD

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1=0;
		System.out.print("�ܼ��� �Է��ϼ���.(2~9) : ");
		num1 = sc.nextInt();
		
		do {
		} while (num1 < 2 || num1 > 9); 
			System.out.print("�ùٸ� ���� �Է��ϼ���.(2~9): ");
			
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
		// ����ڷ� ���� 2~9������ ���ϴ� �������� �޴´�.
		Scanner sc = new Scanner(System.in);
		int dansu;
		do {
			System.out.print("����� ���ϴ� ������ ���� ?(2~9�ܱ����� ��)");
			dansu = sc.nextInt();
		}while(dansu < 2 || dansu>9);
		guguPrint(dansu);// ����ڷκ��� ���� ���� �������� ���
	}
	private static void guguPrint(int dansu) {// ����ڷκ��� ���� ���� �������� ���
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
		}
	}
}
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
