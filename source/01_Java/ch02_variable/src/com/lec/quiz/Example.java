package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		int kor = 93;
		String name = "Á¡¼ö :";
		int eng = 95;
		int mat = 100;
		System.out.println("kor" + name + kor);
		System.out.println("eng" + name + eng);
		System.out.println("mat" + name + mat);
		
		int tot = kor + eng + mat; //ÃÑÁ¡
		System.out.println("tot" + name + tot);
		
		double avg = (double)tot / 3.0;
		System.out.println("avg" + name + avg);
				
	}
}
