package com.lec.ex;
// ��������� : + - * /(������, �������� ������ ��) %(������)
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
<<<<<<< HEAD
		resultDouble = (double)n1 / n2;
=======
		resultDouble = n1 / n2;
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		result = n1 / n2;
		System.out.printf("%d %c %d = %f\n", n1, '/', n2, resultDouble);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		// ������ �������� �뵵 : ¦��/Ȧ�� �Ǻ� / ��� �Ǻ� �뵵
		if ( (n1%2) ==0) {
			System.out.println("n1�� ¦��");
		}else {
			System.out.println("n1�� Ȧ��");
		}
		if ( (n1%5) ==0) {
			System.out.println("n1�� 5�� ����Դϴ�");
		}else {
			System.out.println("n1�� 5�� ����� �ƴմϴ�");
		}

	}
}
