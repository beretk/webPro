package com.lec.quiz;
// 76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 출력
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=i+1 ; j<arr.length ; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
 
				}//if
			}//for-j
		}//for-i
		for(int i = 0; i<arr.length ; i++ ) {
            System.out.println("arr[" + i + "]는 " + arr[i]);
		}//for k
	}//main
}

//	for(int a : arr) {
//		System.out.print(a + "\t");
//	}



