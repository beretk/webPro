package com.lec.quiz;
import java.util.Scanner;
//입력한 수가 짝수인지 홀수인지 출력
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
		System.out.print("수를 입력하세요 :");
		int su = sc.nextInt();
		String result = (su%2==0) ? "입력한 수는 짝수" : "입력한 수는 홀수";
		System.out.println("입력하신 수(" + su+")는" + result);
		System.out.printf("입력하신 수(%d)는 %s", su, result);
=======
		System.out.print("숫자를 입력하세요 :");
		int su = sc.nextInt();
		String result = (su%2==0) ? "입력한 수는 짝수 입니다" : "입력한 수는 홀수 입니다";
		System.out.println("입력한 수(" + su+")는" + result);
		System.out.printf("입력한 수(%d)는 %s", su, result);
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		sc.close();
	}
}
