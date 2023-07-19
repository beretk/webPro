package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_juminNo {
	public static void main(String[] args) {
		String juminNo;
		Scanner scanner = new Scanner(System.in);
		System.out.println("주민등록 번호를 입력 하세요");
		juminNo = scanner.next();//981212-1234567
		String genderStr = juminNo.substring(7, 8);
		
		if(genderStr.equals("2") || genderStr.equals("4")) {
			System.out.println("여자");
		}else if(genderStr.equals("1") || genderStr.equals("1")){
			System.out.println("남자");
		}else {
			System.out.println("유효하지 않은 번호");
		}
			
	}//else

}//main

