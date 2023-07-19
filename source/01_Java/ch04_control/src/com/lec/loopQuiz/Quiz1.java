package com.lec.loopQuiz;
// 1~10 ±îÁöÀÇ °ö
public class Quiz1 {
	public static void main(String[] args) {
		
		int tot = 1;
		for(int i=1 ; i<=10 ; i++) {
			tot *= i;  
			System.out.print(i);
			if(i!=10) {
				System.out.print("*");	
				
			}//if
		}//for
		System.out.println("=" + tot);
	}//main
}
