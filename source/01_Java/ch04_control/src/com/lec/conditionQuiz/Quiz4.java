package com.lec.conditionQuiz;

import java.util.Scanner;
//���������� ����
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(0), ����(1), ���ڱ�(2) �� ���� �ϳ��� �����ϼ��� :");
		int you = scanner.nextInt();  // 0,1,2
		int computer = (int) (Math.random()*3); // 0,1,2 �� �� ����
		String youStr = (you==0) ? "����" : (you==1)? "����":"���ڱ�";
		String computerStr = (computer==0)? "����" : (computer==1)? "����":"���ڱ�";
		if(you>2 || you<0) {
			System.out.println("�߸� �Է��Ͻ�");
			System.exit(0); // ���α׷� ���� ����
		}
		System.out.println("����� " + youStr + ", ��ǻ�ʹ� " + computerStr);
		// ����� �̰���ϴ� || ��ǻ�Ͱ� �̰���ϴ� || �����ϴ� ��� 
		if(you == 0) {
			if (computer==0) {
				System.out.println("�����ϴ�");
			}else if(computer==1) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ� �Ф�");
			}else {
				System.out.println("�� ����� �̰���ϴ� ��");
			}
		}else if (you == 1) {
			if(computer==0) {
				System.out.println("�� ����� �̰���ϴ� ��");
			}else if(computer==1) {
				System.out.println("�����ϴ�");
			}else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ� �Ф�");
			}
		}else if (you==2) {
			if(computer==0) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ� �Ф�");
			}else if(computer==1) {
				System.out.println("�� ����� �̰���ϴ� ��");
			}else {
				System.out.println("�����ϴ�");
			}
		} // ���
		scanner.close();
	}
}