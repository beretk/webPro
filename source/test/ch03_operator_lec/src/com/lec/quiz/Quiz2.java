package com.lec.quiz;
import java.util.Scanner;
//�Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� :");
		int su = sc.nextInt();
		String result = (su%2==0) ? "�Է��� ���� ¦�� �Դϴ�" : "�Է��� ���� Ȧ�� �Դϴ�";
		System.out.println("�Է��� ��(" + su+")��" + result);
		System.out.printf("�Է��� ��(%d)�� %s", su, result);
		sc.close();
	}
}
