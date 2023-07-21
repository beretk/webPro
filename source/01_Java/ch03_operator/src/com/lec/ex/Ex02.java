package com.lec.ex;
// 증감연산자 : ++(1증가), --(1감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; //n1을 1증가하고 n2에 할당(n1도 n2도 11)
		System.out.println("n1=" + n1 +" n2=" + n2);
<<<<<<< HEAD
		n2 = n1++; // n1을 n2에 할당한 후 n1을 1증가(n1는 12, n2은 11)
=======
		n2 = n1++; // n1을 n2에 할당한 후 n1을 1증가(n2는 11, n1은 12)
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		System.out.println("n1=" + n1 +" n2=" + n2);
		--n1; //n1을1 감소
		System.out.println("n1=" + n1);
		
	}
}
