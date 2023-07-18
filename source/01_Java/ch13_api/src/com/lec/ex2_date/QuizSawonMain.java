package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class QuizSawonMain {
	public static void main(String[] args) {
		 
		QuizSawon hong = new QuizSawon("202301","홍길동","COMPUTER");
		QuizSawon shin = new QuizSawon("202201","신길동", "DESIGN", 2022, 1, 1);
		System.out.println(hong);
		System.out.println(shin);
		
		
	}
	
}
