package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // S������ �Լ�
		//A aObj = new A();
		S aObj = new A(); // ������ �Լ� 2�� ����(�θ��,�ڽĴ�)
		//B bObj = new B();
		S bObj = new B();
		C cObj = new C();// ������ �Լ� 2�� ����(�θ��,�ڽĴ�)
		S[] arr = {sObj, aObj, bObj, cObj};
		for(int idx=0 ; idx<arr.length ; idx++) {
			System.out.println(idx+ "��°:"+arr[idx].s);
		}
		for(S a : arr) {
			System.out.println("s=" + a.s);
		}
	}
}