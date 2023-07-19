package com.lec.condition;
//랜덤점수(0~100)의 학점 출력
import java.util.Scanner;

public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		int temp = score == 100 ? 99 : score;
		switch(temp/10) {
		case 9:
			System.out.println("A");break;
		case 8:
			System.out.println("B");break;
		case 7:
			System.out.println("C");break;
		case 6:
			System.out.println("D");break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F");break;	
		default:
			System.out.println("점수를 잘못 입력 했음");
		}
		sc.close();		
	}
}
