package com.lec.quiz;

import java.util.Scanner;

//3�� ��� ���� �Ǵ��ϱ� : ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���ڰ� 3�� ������� �ľ�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int su = scanner.nextInt(); //�Է¹��� ������ su�� �Ҵ�
		String result = (su%3 == 0)? " 3�� ���" : "3 �� ����� �ƴ�";
		System.out.println("�Է��Ͻż�(" + su +")��" + result);
		System.out.printf("�Է��Ͻż�(%d)�� %s", su, result);
	}
}
