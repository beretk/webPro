package com.lec.ex;
// ��Ʈ ������
// ��Ʈ�� ����� �����ϴ� �����ڷμ�,
// ������ ���� ������ ���길 �����մϴ�.
// AND(&), OR(|), XOR(^)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 1; //  0 ~ 0 0 0 1
		int n2 = 2; //  0 ~ 0 0 1 0
		//             ------------
		//           &  0 ~ 0 0 0 0  (0)
		//           |  0 ~ 0 0 1 1  (3)
		System.out.println("n1 & n2 ^ " + (n1 & n2)); 
		System.out.println("n1 | n2 ^ " + (n1 | n2)); 
	}
}