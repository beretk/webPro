package com.lec.quiz;
import java.util.Scanner;
// �μ��� �Է¹޾� �μ��� ������ ����� O�� X�� ��� / ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("ù��° ���� �Է��ϼ��� :");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� :");
		int num2 = sc.nextInt();
		System.out.println("�μ��� ������ ����� "+((num1==num2)? "O":"X"));
		System.out.println("ù��° ���� �� ū�� ��� "+((num1>num2)? "O":"X"));
		sc.close();
	}
}
=======
		System.out.print("ù��° ���� ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� ");
		int num2 = sc.nextInt();
		System.out.println("�μ��� ������ ����� "+((num1==num2)? "O":"X"));
		System.out.println("ù��° ���� �� ū�� ���� "+((num1>num2)? "O":"X"));
		sc.close();
	}
}
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
