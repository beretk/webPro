<<<<<<< HEAD
package com.lec.ex;

public class VarEx02 {
	public static void main(String [] args) {
		//타입 변수명(알파벳, 숫자, _; 영문시작) 할당연산(=) 초기값 ;
		int i = 10;
		byte j = 127;
		double h = 10.15;
		System.out.println("i="+i + "\t j=" +j + "\t h=" + h);//콘솔창 출력(개행포함)
		System.out.printf("i=%d\t j=%d\t h=%.3f\n", i, j, h);
		char c1 = 'A';
		char c2 = 'B';
		c2 = 'C';
		// 문자(%c), 문자열(%s), 정수(%d), 실수(%f), boolean(%b)
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
		System.out.println("프로그램 끝");
	}
}
=======
package com.lec.ex;

public class VarEx02 {
	public static void main(String [] args) {
		//타입 변수명(알파벳, 숫자, _; 영문시작) 할당연산(=) 초기값 ;
		int i = 10;
		byte j = 127;
		double h = 10.15;
		System.out.println("i="+i +"\t j=" +j +"\t h=" + h);//콘솔창 출력(개행포함)
		System.out.printf("i=%d\t j=%d\t h=%.3f\n", i, j, h);
		char c1 = 'A';
		char c2 = 'B';
		c2 = 'C';
		// 문자(%c), 문자열(%s), 정수(%d), 실수(%f), boolean(%b)
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
		System.out.println("프로그램 끝");
	}
}
>>>>>>> b12dce29af3ea512a62c8845153f9cc04d555bf9
