package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� ���� ������ Ȧ������ ¦������ ���(���׿�����, if, switch) - switc
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է� �Ͻÿ� : ");
		int num = scanner.nextInt();
		switch(num%2) {
		case 0 :
			System.out.println("¦��"); break;
		default :
			System.out.println("Ȧ��"); break;
		}
		scanner.close();
	}
}
