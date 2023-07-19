package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;//����ڿ��� �Է¹��� �� ����
		do {
			try {
				System.out.print("ù��° ������(��Ģ���� ����� ����)?");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("���� ���ڸ� ���� ������");
				scanner.nextLine(); //���۸� ����� ����(\n�ձ��� ���ڸ� return�ϰ� \n�� ����� �Լ�)
			}
		}while(true);		
		System.out.print("ù��° ������(��Ģ���� ����� ����)?");
		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i/j)); //���ܰ� �߻��Ҽ��� �ְ�, �� �Ҽ��� �ִ� �κ�
		}catch(ArithmeticException e) {	// ArithmeticException ���� ��ü �߻��� ���� �κ�
			//e.printStackTrace(); // ���� �ڼ��� ���� �޼���
			System.out.println(e.getMessage()); //���ܰ�ü�� ���ܸ޼��� ���
		}catch(RuntimeException e) {
			System.out.println(e.getMessage()); //���ܰ�ü�� ���ܸ޼��� ���
			System.out.println("�ι�° ������ �߸� �Է��Ͻø� ������ 1�� ó�� �մϴ�");
		}
		System.out.println("i * j = " + (i*j));
		System.out.println("i - j = " + (i-j));
		System.out.println("i + j = " + (i+j));
		System.out.println("DONE");
		scanner.close();
	}	
}