package com.lec.quiz;

import java.util.Scanner;

//�μ��� �Է¹޾� �μ��� ������ ����� O�� X�� ��� / ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ���� ");
		int num1 = scanner.nextInt();
		System.out.print("�ι�° ���� ");
		int num2 = scanner.nextInt();
		System.out.println("�μ��� ������ ����� " +((num1 == num2)? "O" : "X"));
		System.out.println("ù��° ���� ��ū�� ���� " + ((num1>num2)? "O" : "X"));
	}
}
