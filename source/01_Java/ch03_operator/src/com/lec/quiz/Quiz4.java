package com.lec.quiz;
<<<<<<< HEAD

=======
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
import java.util.Scanner;
// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
		System.out.print("���̸� �Է��ϼ��� �� ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		System.out.println((age>=65)? "��ο��": "�Ϲ�");
		sc.close();
	}
}