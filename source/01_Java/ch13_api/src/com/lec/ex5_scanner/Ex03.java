package com.lec.ex5_scanner;

import java.util.Scanner;

// �̸�(�� ũ���� | ȫ�浿) -> �ּ� -> ����
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸�?");
		String name = sc.nextLine();
		System.out.print("�ּ�");
		String address = sc.nextLine();
		System.out.print("����?");
		int age = sc.nextInt();
		System.out.println(age + "��" + name + "��" + address + "����");
		
				
		
	}
}
