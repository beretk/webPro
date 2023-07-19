package com.lec.ex1_string;

import java.util.Scanner;

// 한번만 전화번호를 입력받아 Ex06과 같이 한번만 출력
public class Ex05_tel {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("전화 번호를 입력 하세요");
		String tel = scanner.next();
		System.out.print("입력한 전화번호 : " + tel);
	}
}
