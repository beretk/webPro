package com.lec.ex;
public class VarEx04 {
	public static void main(String[] args) {
		int i =40; //4byte
		long l =2200000000L; //8byte
		System.out.println("1 =" +1);
		boolean b = true; // 1byte(true/false)
		System.out.println("b =" +b);
		// 실수는 double이 기본
		float f = 3.1415926593F; //4byte
		double d = 3.1415926593; //8byte
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f와d는 같다");
		}else {
			System.out.println("f와 d는 다르다");
		}
		f = 10.1f;
		d = 10.1;
		if (f == d) {
			System.out.println("f와d는 같다");
		}else {
			System.out.println("f와 d는 다르다");
		}
			
			
		double result = d + 1; //8byte + 4byte => 8byte
		System.out.println("d+1 =" + result);
		i = 3;
		//i(3; 4byte) /2(4byte) => 4byte ; 몫
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 = " + ((double)i/2));
		System.out.println("i/2.0 =" + i/2.0);
	}
}
