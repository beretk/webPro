package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MemberTestMain_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/quiz/outTest.txt",true);
			String msg = "ȫ�浿 \t" + "010-9999-9999\t" + "08-22���\t" + "����� ��걸" +"\n"; 
			writer.write(msg);
			msg = "�踶�� \t" + "010-8888-8888\t" + "���ϸ�\t" + "����� ��걸" +"\n"; 
			writer.write(msg);
			System.out.println("���� ��� �Ϸ�");
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
