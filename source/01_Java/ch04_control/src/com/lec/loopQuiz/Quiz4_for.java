package com.lec.loopQuiz;

public class Quiz4_for {
	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.printf(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}
