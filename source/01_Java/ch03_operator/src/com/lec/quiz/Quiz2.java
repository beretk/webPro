package com.lec.quiz;
import java.util.Scanner;
//�Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("���� �Է��ϼ��� :");
		int su = sc.nextInt();
		String result = (su%2==0) ? "�Է��� ���� ¦��" : "�Է��� ���� Ȧ��";
		System.out.println("�Է��Ͻ� ��(" + su+")��" + result);
		System.out.printf("�Է��Ͻ� ��(%d)�� %s", su, result);
=======
		System.out.print("���ڸ� �Է��ϼ��� :");
		int su = sc.nextInt();
		String result = (su%2==0) ? "�Է��� ���� ¦�� �Դϴ�" : "�Է��� ���� Ȧ�� �Դϴ�";
		System.out.println("�Է��� ��(" + su+")��" + result);
		System.out.printf("�Է��� ��(%d)�� %s", su, result);
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		sc.close();
	}
}
