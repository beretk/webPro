package com.lec.conditionQuiz;

import java.util.Scanner;
//가위바위보 게임
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보자기(2) 중 숫자 하나를 선택하세요 :");
		int you = scanner.nextInt();  // 0,1,2
		int computer = (int) (Math.random()*3); // 0,1,2 중 한 난수
		String youStr = (you==0) ? "가위" : (you==1)? "바위":"보자기";
		String computerStr = (computer==0)? "가위" : (computer==1)? "바위":"보자기";
		if(you>2 || you<0) {
			System.out.println("잘못 입력하심");
			System.exit(0); // 프로그램 강제 종료
		}
		System.out.println("당신은 " + youStr + ", 컴퓨터는 " + computerStr);
		// 당신이 이겼습니다 || 컴퓨터가 이겼습니다 || 비겼습니다 출력 
		if(you == 0) {
			if (computer==0) {
				System.out.println("비겼습니다");
			}else if(computer==1) {
				System.out.println("컴퓨터가 이겼습니다 ㅠㅠ");
			}else {
				System.out.println("★ 당신이 이겼습니다 ★");
			}
		}else if (you == 1) {
			if(computer==0) {
				System.out.println("★ 당신이 이겼습니다 ★");
			}else if(computer==1) {
				System.out.println("비겼습니다");
			}else {
				System.out.println("컴퓨터가 이겼습니다 ㅠㅠ");
			}
		}else if (you==2) {
			if(computer==0) {
				System.out.println("컴퓨터가 이겼습니다 ㅠㅠ");
			}else if(computer==1) {
				System.out.println("★ 당신이 이겼습니다 ★");
			}else {
				System.out.println("비겼습니다");
			}
		} // 결과
		scanner.close();
	}
}