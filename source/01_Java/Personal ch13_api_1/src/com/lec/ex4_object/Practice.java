package com.lec.ex4_object;

public class Practice {
//	public static void main(String[] args) {
//		int treeHit = 0;
//		while(treeHit<10) {
//			treeHit++;
//			System.out.println("������ " + treeHit + "�� ������ϴ�");
//			if(treeHit == 10) {
//				System.out.println("������ �Ѿ� ���ϴ�");
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
			System.out.println("str1�� str2�� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ���");
		}
		System.out.println("=======equals start=======");
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		if(str1.equals(str2)) {
			System.out.println("str1�� str2�� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ���");
		}
	}
}
