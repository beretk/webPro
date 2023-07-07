package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("현재 몇 월 입니까?");	
		
		int month = scanner.hashCode();
		switch(month) {		
		case 3: case 4: case 5:
			System.out.println("입력하신 월은 봄 입니다"); break;
		case 6: case 7: case 8:
			System.out.println("입력하신 월은 여름 입니다"); break;
		case 9: case 10: case 11:
			System.out.println("입력하신 월은 가을 입니다"); break;
		case 12: case 1: case 2:
			System.out.println("입력하신 월은 겨울 입니다"); break;
//		default: 
//			System.out.println("입력하신 월은 유효하지 않습니다");
		}
	}
}
