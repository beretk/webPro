package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �� �� �Դϱ�?");	
		
		int month = scanner.hashCode();
		switch(month) {		
		case 3: case 4: case 5:
			System.out.println("�Է��Ͻ� ���� �� �Դϴ�"); break;
		case 6: case 7: case 8:
			System.out.println("�Է��Ͻ� ���� ���� �Դϴ�"); break;
		case 9: case 10: case 11:
			System.out.println("�Է��Ͻ� ���� ���� �Դϴ�"); break;
		case 12: case 1: case 2:
			System.out.println("�Է��Ͻ� ���� �ܿ� �Դϴ�"); break;
//		default: 
//			System.out.println("�Է��Ͻ� ���� ��ȿ���� �ʽ��ϴ�");
		}
	}
}
