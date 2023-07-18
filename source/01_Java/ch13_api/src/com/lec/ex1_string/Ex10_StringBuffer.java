package com.lec.ex1_string;
// String의 단점을 보완하고자StringBuffer > StringBuilder
public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드: "+ strBuffer.hashCode());
		strBuffer.append("def"); //"abcdef"
		System.out.println("append후 : " + strBuffer);
		System.out.println("strBuffer의 해쉬코드: "+ strBuffer.hashCode());
		strBuffer.delete(3,5); //"abcf" 3번째부터 5번째 앞까지 삭제
		System.out.println("append후 : " + strBuffer);
		System.out.println("strBuffer의 해쉬코드: "+ strBuffer.hashCode());
	}
}


