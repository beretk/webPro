package com.lec.quiz;
<<<<<<< HEAD

import java.util.Scanner;

//������������ ����, ��� ���
=======
import java.util.Scanner;
// ����,����,���� ������ �Է¹޾�, �� ������ ���� ,����� �Ҽ��� 2�ڸ����� ���
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ������?");
		int kor = scanner.nextInt();
		System.out.print("���� ������?");
		int eng = scanner.nextInt();
		System.out.print("���� ������?");
		int mat = scanner.nextInt();
		int sum = kor + eng + mat;
		double avg = sum/3.;
		System.out.printf("���� = %d, ���� = %d, ���� = %d\n",kor, eng, mat);
		System.out.printf("���� = %d, ��� = %.2f\n", sum, avg);
		scanner.close();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
