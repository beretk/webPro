package com.lec.loopQuiz;

import java.util.Scanner;

//사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력
public class Quiz3_for {
	public static void main(String[] args) {
		System.out.print("구구단을 실행할 숫자를 입력 하세요");
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		for(int j = 1; j<10; j++) {
			System.out.println(i + "*" + j + "=" + i*j);
		}//for
	}//main
}
