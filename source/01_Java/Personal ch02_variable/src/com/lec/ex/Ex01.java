package com.lec.ex;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("x �� �Է�: ");
		String strX = scanner.nextLine();
		int x = Integer.parseInt(strX);
		
		System.out.println("y �� �Է�: ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);
		
		int result =  x + y;
		System.out.println("x + y: " + result);
		System.out.println();
		
		while(true) {
			System.out.println("�Է� ���ڿ�: ");
			String data = scanner.nextLine();
			if(data.equals("q")) {
				break;
			}
			System.out.println("��� ���ڿ�: " + data);
			System.out.println();
		}
		System.out.println("����");
	}
}
