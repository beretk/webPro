package com.lec.loopQuiz;
// 1~10������ ������ Ȧ���� ��
public class Quiz2_for {
	public static void main(String[] args) {

		int oddsum = 0;
		for(int i=1 ; i<=10 ; i++) {
			
			if (i % 2 != 0) {
				oddsum +=i ;	
				
			}//if
		}//for
		System.out.println("Ȧ���������� " + oddsum);
	}//main
}

