package com.lec.quiz;

public class Example2 {
	public static void main(String[] args) {
	int kor = 100;
	String name = "점수: ";
	int eng = 93;
	int mat = 92;

	System.out.println("국어" + name + kor + "점");
	System.out.println("영어" + name + eng);
	System.out.println("수학" + name + mat);
	
	int total = kor + eng + mat;
	System.out.println("총점:" + total);
	double average = total/3.0;
	System.out.printf("평균:" + average);
	}
}
