package com.lec.ex4_object;

public class Practice {
//	public static void main(String[] args) {
//		int treeHit = 0;
//		while(treeHit<10) {
//			treeHit++;
//			System.out.println("나무를 " + treeHit + "번 찍었습니다");
//			if(treeHit == 10) {
//				System.out.println("나무가 넘어 갑니다");
//			}
//		}
//	}
	public static void main(String[] args) {
		String str1 = "APPLE";
		String str2 = "apple";
		System.out.println("=======equalsIgnoreCase start=======");
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1과 str2는 같다");
		}else {
			System.out.println("str1과 str2는 다르다");
		}
		System.out.println("=======equals start=======");
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같다");
		}else {
			System.out.println("str1과 str2는 다르다");
		}
	}
}
