package com.lec.ex;
// ���������� : ++(1����), --(1����)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; //n1�� 1�����ϰ� n2�� �Ҵ�(n1�� n2�� 11)
		System.out.println("n1=" + n1 +" n2=" + n2);
<<<<<<< HEAD
		n2 = n1++; // n1�� n2�� �Ҵ��� �� n1�� 1����(n1�� 12, n2�� 11)
=======
		n2 = n1++; // n1�� n2�� �Ҵ��� �� n1�� 1����(n2�� 11, n1�� 12)
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		System.out.println("n1=" + n1 +" n2=" + n2);
		--n1; //n1��1 ����
		System.out.println("n1=" + n1);
		
	}
}
