package com.lec.quiz;
//배열에 담긴 값을 더하는 프로그램을 작성
public class Quiz2 {
	public static void main(String[] args) {
		int total = 0;
		int[] arr = {10,20,30,40,50};
		for(int i=0 ; i<arr.length ; i++) {
			total += arr[i];
		}//for
		System.out.println(total);
	}//main
}



