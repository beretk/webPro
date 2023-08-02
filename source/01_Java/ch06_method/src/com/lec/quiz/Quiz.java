package com.lec.Quiz;

public class Quiz {
	public static void gugudan(int n){

		System.out.println(n + "단");



		for (int i = 1; i <=9 ; i++ ){

			System.out.println(n + "*" + i + "=" + (n*i));

		}

		System.out.println();

	}

		public static void main(String[] args) {

		//구구단 중에 2단을 출력하기 위하여 메소드에게 일처리를 맡기고자 한다.

		for (int i = 2; i <=9 ; i++ ){

			gugudan(i);

		}

	}

}

