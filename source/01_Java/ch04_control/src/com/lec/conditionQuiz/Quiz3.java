package com.lec.conditionQuiz;

import java.util.Scanner;

// 0(����), 1(����), 2(���ڱ�)
public class Quiz3 {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("����(0), ����(1), ���ڱ�(2) �� ���ڸ� �����ϼ��� : ");
		 int you = scanner.nextInt(); // 0,1,2
		 String youstr = (you==0) ? "����" :( (you==1) ? "����" : "���ڱ�");
		 if(you>2 || you<0) {
			 System.out.println("�߸� �Է� �ϼ̽��ϴ�");
			 System.exit(0);//���α׷� ���� ����
		 }
		 System.out.println(youstr);
//		 if(you==0) {
		 
//			 System.out.println("����");
//		 }else if(you==1) {
//			 System.out.println("����");
//		 }else if(you==2) {
//			 System.out.println("���ڱ�");
//		 }else {
//			 System.out.println("�߸� �Է� �ϼ̽��ϴ�");
//		 }
//		 switch(you) {
//		 case 0 : 
//			 System.out.println("����"); break;
//		 case 1 :
//			 System.out.println("����"); break;
//		 case 2 :
//			 System.out.println("���ڱ�"); break;
//		 default :
//			 System.out.println("�߸� �Է� �ϼ̽��ϴ�"); break;
//		 }
	}
}
