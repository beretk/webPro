package com.lec.ex;

public class Ex8 {
	public static void main(String[] args) {
		System.out.println("====��Ʈ������====");
		int n1 = 10;
		int n2 = 5;
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  & = 0 0 0 0 0
		int result = n1 & n2;
		System.out.printf("n1 & n2 =");// ��Ʈ ������
		// ��Ʈ�� ����� �����ϴ� �����ڷμ�,
		// ������ ���� ������ ���길 �����մϴ�.
		// AND(&), OR(|), XOR(^)
		System.out.println(result);
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  | = 0 1 1 1 1
		result = n1 | n2;
		System.out.printf("n1 | n2 =");
		System.out.println(result);
		
		// ��Ʈ������ XOR(^)
		// ���װ� ������ �� ��Ʈ�� ���Ͽ�
		// ���� �ٸ� ���� ������ �ڸ��� 1�� �����ִ� ������
		// n1 = 0 1 0 1 0
		// n2 = 0 0 1 0 1
		//  ^ = 0 1 1 1 1
		result = n1 ^ n2;
		System.out.printf("n1 ^ n2 =");
		System.out.println(result);	
	}

}
