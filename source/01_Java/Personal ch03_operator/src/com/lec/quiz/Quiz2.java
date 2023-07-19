package com.lec.quiz;
// 입역한 수가 짝수인지 홀수인지
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하시오: ");
		int i = sc.nextInt();
		int result = i%2;
		System.out.println((result == 0)? "입력하신수는 짝수" : "입력하신수는 홀수");	
		sc.close();
	}
}
