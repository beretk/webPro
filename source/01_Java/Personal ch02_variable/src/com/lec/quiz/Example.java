package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
	int kor = 100;
	int eng = 93;
	int mat = 85;
	int total = kor + eng + mat;
	double average = total/3;
	//double average = (double)total/3;
//	System.out.println("��������:" + kor + "\n��������:" + eng + "\n��������:" + mat);
//	System.out.printf("����: %d\n���: %.02f" , total, average);
	
	System.out.println("��������:" + kor + "\n��������:" + eng + "\n��������:" + mat);
	System.out.printf("����: %d\n���: %.2f", total, average);

	
	}
}
