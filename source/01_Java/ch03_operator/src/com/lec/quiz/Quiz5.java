package com.lec.quiz;
<<<<<<< HEAD

import java.util.Scanner;

//국영수점수의 총점, 평균 출력
=======
import java.util.Scanner;
// 국어,영어,수학 점수를 입력받아, 각 점수와 총점 ,평균을 소수점 2자리까지 출력
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 점수는?");
		int kor = scanner.nextInt();
		System.out.print("영어 점수는?");
		int eng = scanner.nextInt();
		System.out.print("수학 점수는?");
		int mat = scanner.nextInt();
		int sum = kor + eng + mat;
		double avg = sum/3.;
		System.out.printf("국어 = %d, 영어 = %d, 수학 = %d\n",kor, eng, mat);
		System.out.printf("총점 = %d, 평균 = %.2f\n", sum, avg);
		scanner.close();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
