package com.lec.loopQuiz;

import java.util.Scanner;

//����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ���
public class Quiz3_for {
	public static void main(String[] args) {
		System.out.print("�������� ������ ���ڸ� �Է� �ϼ���");
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		for(int j = 1; j<10; j++) {
			System.out.println(i + "*" + j + "=" + i*j);
		}//for
	}//main
}
