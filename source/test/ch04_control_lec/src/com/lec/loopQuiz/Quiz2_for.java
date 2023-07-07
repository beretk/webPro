package com.lec.loopQuiz;
// 1~10까지의 숫자중 홀수의 합
public class Quiz2_for {
	public static void main(String[] args) {

		int oddsum = 0;
		for(int i=1 ; i<=10 ; i++) {
			
			if (i % 2 != 0) {
				oddsum +=i ;	
				
			}//if
		}//for
		System.out.println("홀수누적합은 " + oddsum);
	}//main
}

