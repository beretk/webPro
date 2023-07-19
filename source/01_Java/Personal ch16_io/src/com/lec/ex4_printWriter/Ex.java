package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {
	public static void main(String[] args) {
		OutputStream os         = null;
		Writer		     writer = null;
		PrintWriter printWriter = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt",true );
			printWriter = new PrintWriter(os);
			writer = new FileWriter("txtFile/outTest.txt",true);
			printWriter = new PrintWriter(writer);
			printWriter = new PrintWriter("txtFile/outTest.txt");
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			System.out.print("print는 자동 개행이 안되요.그래서 개행추가\n");
			printWriter.print("print는 자동 개행이 안되요.그래서 개행추가\n");
			System.out.printf("%s %3d %3d %5.1f\n","홍길동",100,100,100.0);
			printWriter.printf("%s %3d %3d %5.1f\n","홍길동",100,100,100.0);
			System.out.printf("%s %3d %3d %5.1f\n","홍길동",90,91,90.5);
			printWriter.printf("%s %3d %3d %5.1f\n","홍길동",90,91,90.5);
			System.out.printf("%s %3d %3d %5.1f\n","홍길동",95,97,960.0);
			printWriter.printf("%s %3d %3d %5.1f\n","홍길동",95,97,96.0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter != null) printWriter.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
