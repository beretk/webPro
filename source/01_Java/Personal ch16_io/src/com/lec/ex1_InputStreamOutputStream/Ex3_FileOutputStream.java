package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex3_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os =null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt",true);
			String msg = "Hi, Java\n01234567\n안녕\n";
			byte[] bs = msg.getBytes();
			os.write(bs);
			System.out.println("파일 출력 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
