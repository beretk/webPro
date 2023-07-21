package com.lec.quiz.test;

import java.util.Scanner;

public class ProgrammingLan {
	public static void main(String[] args) {
		int total = 0;
		int average = 0;
		int[] arr = {76,45,34,89,100,50,90,93};
		for(int i=0 ; i<arr.length ; i++) {
			total += arr[i];
		} 
		System.out.println( "ÇÕ  °è" + " = " + total);
		int maxIdx=0, max=0;
		int minIdx=0, min=999;
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
			if(arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
	} 
//	System.out.println( "Æò  ±Õ" + " = " + average);
}		
