package com.lec.condition;
<<<<<<< HEAD
//import java.util.Scanner;
// ��������(0~100)�� ���� ���
public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		// 0<= Math.random() < 1 �Ǽ����� �߻�
=======
import java.util.Scanner;
// ��������(0~100)�� ���� ���
public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		// 0>= Math.random() < 1 �Ǽ����� �߻�
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		// 0<= Math.random() *101 < 101 �Ǽ� ���� �߻�
		// 0<= (int)(Math.random() *101 < 101 ��������
		int score = (int)(Math.random() * 101);
		System.out.println("���� : " + score);
		// �������
		switch(score/10) {		
		case 10: case 9:
			System.out.println("A"); break;
		case 8:
			System.out.println("B"); break;
		case 7:
			System.out.println("C"); break;
		case 6:
			System.out.println("D"); break;
		default:
			System.out.println("F"); break;
		}
	}// main
}
