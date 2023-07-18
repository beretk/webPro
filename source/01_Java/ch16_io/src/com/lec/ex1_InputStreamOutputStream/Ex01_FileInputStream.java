package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)스트림을 생성(파일을 연다) (2)데이터를 읽는다(read메소드 사용:1byte씩 읽는다) (3)파일을 닫는다(close메소드 사용)
public class Ex01_FileInputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");//1. 파일을 연다
			//2. 데이터를 읽는다(파일의 끝까지 반복적으로 읽는다)
			while(true) {
				int i = is.read();//1byte씩 읽는
				if(i == -1) {
					break;//파일의 끝이면 break;
				}
				System.out.print((char)i);
			}
			System.out.println("\n = = = DONE = = = ");
			//3. 닫는다
		}catch (FileNotFoundException e) {
			System.out.println("예외 메세지(파일을 못 찾음) : " + e.getMessage());
		}catch (IOException e) {
			System.out.println("예외 메세지(못 읽음) : " + e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();//3. 파일을 닫는다
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
