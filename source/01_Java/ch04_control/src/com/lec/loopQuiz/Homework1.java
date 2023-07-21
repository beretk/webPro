package com.lec.loopQuiz;

import java.util.Scanner;

public class Homework1 {
<<<<<<< HEAD
	
=======
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(true) {
		System.out.print("가위(0), 바위(1), 보자기(2) 중 숫자 하나를 선택하세요 (종료:-1):");
		int you = scanner.nextInt();  // 0,1,2
		if(you==-1) break;
		int computer = (int) (Math.random()*3); // 0,1,2 중 한 난수
		String youStr = (you==0) ? "가위" : (you==1)? "바위":"보자기";
		String computerStr = (computer==0)? "가위" : (computer==1)? "바위":"보자기";
		if(you>2 || you<0) {
			System.out.println("잘못 입력하심");
			continue; // 조건식 부분으로 감
		}
		System.out.println("당신은 " + youStr + ", 컴퓨터는 " + computerStr);
		// 당신이 이겼습니다 || 컴퓨터가 이겼습니다 || 비겼습니다 출력 
		if( (you+2)%3 == computer) {
			System.out.println("★ 당신이 이겼습니다 ★");
		}else if (you == computer) {
			System.out.println("비겼습니다.");
		}else {
			System.out.println("컴퓨터가 이겼습니다 ㅠㅠ");
		}
	}
	
	scanner.close();
}
}