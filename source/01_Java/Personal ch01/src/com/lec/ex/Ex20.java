package com.lec.ex;
import java.util.Random;
public class Ex20 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[]arr = new int[6];
		for(int i=0; i<6; i++) {
			arr[i] = rand.nextInt(45)+1;
		}
//		for(int i : arr) {
//			System.out.println("����� ����: "+i);
//		}
		for(int i=0;i<6;i++) {
			System.out.println("����� ���� :"+arr[i]);
		}
	}
}
