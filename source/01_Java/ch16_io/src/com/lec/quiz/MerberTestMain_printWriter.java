package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class MerberTestMain_printWriter {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt",true);
			printWriter = new PrintWriter(os);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
