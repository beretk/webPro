package com.lec.ex;

import java.util.Scanner;

public class Ex21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("난수의 갯수를 입력하세요");
		int cnt = sc.nextInt();
		int tot = 0;
		for(int i=0;i<cnt; i++) {
			tot +=(int)(Math.random()*45+1);
		}
		System.out.println("난수의 합은=" + tot);
	}
}
