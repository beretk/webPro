package com.lec.quiz;

public class Example2 {
	public static void main(String[] args) {
	int kor = 100;
	String name = "����: ";
	int eng = 93;
	int mat = 92;

	System.out.println("����" + name + kor + "��");
	System.out.println("����" + name + eng);
	System.out.println("����" + name + mat);
	
	int total = kor + eng + mat;
	System.out.println("����:" + total);
	double average = total/3.0;
	System.out.printf("���:" + average);
	}
}
