package com.lec.ex;
//��Ʈ ������
// ��Ʈ�� ����� �����ϴ� �����ڷμ�,
// ������ ���� ������ ���길 �����մϴ�.
// AND(&), OR(|), XOR(^) 
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10;
        int n2 = 15;
        int result = n1 ^ n2;
        System.out.println("10 ^ 15 = " + result);

        System.out.println("11 ^ 11 = " + (11 ^ 11));
        System.out.println("0 ^ 10 = " + (0 ^ 10));
        System.out.println("14 ^ 13 = " + (14 ^ 13));
    }
}