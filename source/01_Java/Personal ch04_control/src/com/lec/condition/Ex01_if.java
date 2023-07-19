package com.lec.condition;
//점수 할당후 점수에 따른 결과를 출력
public class Ex01_if {
	public static void main(String[] args) {
		int score = 90;
		if(score >=90) {
			System.out.println("완벽해");
		}else if(score >=70) {
			System.out.println("뭐 대충 완벽해");
		}else if(score >=60) {
			System.out.println("분발 합시다");
		}else {
			System.out.println("재시험 이닷");
		}
		System.out.println("DONE");
	}
}
