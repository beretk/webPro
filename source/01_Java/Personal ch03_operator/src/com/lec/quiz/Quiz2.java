package com.lec.quiz;
// �Կ��� ���� ¦������ Ȧ������
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��Ͻÿ�: ");
		int i = sc.nextInt();
		int result = i%2;
		System.out.println((result == 0)? "�Է��Ͻż��� ¦��" : "�Է��Ͻż��� Ȧ��");	
		sc.close();
	}
}
