package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_juminNo {
	public static void main(String[] args) {
		String juminNo;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ֹε�� ��ȣ�� �Է� �ϼ���");
		juminNo = scanner.next();//981212-1234567
		String genderStr = juminNo.substring(7, 8);
		
		if(genderStr.equals("2") || genderStr.equals("4")) {
			System.out.println("����");
		}else if(genderStr.equals("1") || genderStr.equals("1")){
			System.out.println("����");
		}else {
			System.out.println("��ȿ���� ���� ��ȣ");
		}
			
	}//else

}//main

