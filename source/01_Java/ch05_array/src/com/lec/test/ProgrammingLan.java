package com.lec.test;

public class ProgrammingLan {
	public static void main(String[] args) {
		int[] array = {76,45,34,89,100,50,90,93};
		int sum=0, max=0,min=999;
		double avg;
		for(int i=0 ; i<array.length ; i++){
			sum += array[i];
			if(array[i]>max) max = array[i];
			if(array[i]<min) min = array[i];
		}
		avg = (double)sum/array.length;
		System.out.printf("합   계 = %d\t 평   균 = %.2f\n",sum,avg);
		System.out.printf("최대값 = %d\t 최소값 = %d\n",max,min);
	}
}