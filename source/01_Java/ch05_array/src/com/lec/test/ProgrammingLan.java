package com.lec.test;

public class ProgrammingLan {
	public static void main(String[] args) {
		int total = 0;
		double average =0;
		int[] arr = {76,45,34,89,100,50,90,93};
		for(int i=0 ; i<arr.length ; i++) {
			total += arr[i];
		}
		average = (double)total / arr.length;
		for(int i=0 ; i<arr.length ; i++) {
			
		}
		System.out.println("ÇÕ  °è" + " = "  + total + "\t Æò  ±Õ" + " = " + average);
	}
}


