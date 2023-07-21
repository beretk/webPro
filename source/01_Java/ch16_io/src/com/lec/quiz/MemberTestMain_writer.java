package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MemberTestMain_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/quiz/outTest.txt",true);
			String msg = "홍길동 \t" + "010-9999-9999\t" + "08-22生생\t" + "서울시 용산구" +"\n"; 
			writer.write(msg);
			msg = "김마동 \t" + "010-8888-8888\t" + "생일모름\t" + "서울시 용산구" +"\n"; 
			writer.write(msg);
			System.out.println("파일 출력 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer !=null) writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
