package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class MemberTestMain_writer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer = null;
		String fileName =scanner.next();
		scanner.nextLine();
		try {
			writer = new FileWriter("src/com/lec/quiz/member.txt",true);
			while(true) {
				String msg = scanner.nextLine();
				if(msg.equalsIgnoreCase("n")) break;
				writer.write(msg+ "\n");
				System.out.println(msg);
			}
			System.out.println("src/com/lec/quiz/" + fileName + ".txt 파일로 출력  저장 완료");
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
