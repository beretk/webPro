<<<<<<< HEAD
package com.lec.ex;
// 형변환
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; // 4byte
		double d = i; // d = 10.0; 묵시적인 형변환 8byte
		System.out.println("d = " + d);
		i = (int)10.0; // 명시적인 형변환 - 데이타손실이 생길수 있음
		System.out.println("i = " + i);
	}
}
=======
package com.lec.ex;
// 형변환
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; // 4byte
		double d = i; // d = 10.0; 묵시적인 형변환 8byte
		System.out.println("d = " + d);
		i = (int)10.0; // 명시적인 형변환 - 데이타손실이 생길수 있음
		System.out.println("i = " + i);
	}
}
>>>>>>> b12dce29af3ea512a62c8845153f9cc04d555bf9
