package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
	int kor = 100;
	int eng = 93;
	int mat = 85;
	int total = kor + eng + mat;
	double average = total/3;
	//double average = (double)total/3;
//	System.out.println("국어점수:" + kor + "\n영어점수:" + eng + "\n수학점수:" + mat);
//	System.out.printf("총점: %d\n평균: %.02f" , total, average);
	
	System.out.println("국어점수:" + kor + "\n영어점수:" + eng + "\n수학점수:" + mat);
	System.out.printf("총점: %d\n평균: %.2f", total, average);

	
	}
}
