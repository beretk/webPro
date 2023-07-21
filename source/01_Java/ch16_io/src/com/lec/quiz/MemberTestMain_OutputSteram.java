package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_OutputSteram {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, birthStr, address;//사용자에게 받을 정보들
		Date birth;
		while(true){
			System.out.println("회원가입을 진행하시겠습니까(Y/N)?");
			if(scanner.next().equalsIgnoreCase("n")) break;
			answer = scanner.nextLine();
			System.out.println("이름?");
			name = scanner.next();
			System.out.println("전화?");
			tel = scanner.next();
			System.out.println("생일(yyyy-mm-dd)?");
			birthStr = scanner.next();//"1998-07-19"
			//birth = toDate(birthStr);
			birth = toDateTodayIsBirthDayChk(name,birthStr);
			System.out.println("주소?");			
			address = scanner.nextLine();
			scanner.nextLine(); 
			//members.add(new Member(name,tel,birth,address));
			//System.out.println(new Member(name,tel,birthday,address));
			//members에 add
		} 
		if(members.size()==0) {
			System.out.println("가입한 회원이 없습니다");
		}else {
			for(Member member : members) {
				System.out.println(member);
			}
		}
	}
	private static Date toDateTodayIsBirthDayChk(String name, String birthStr) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Date toDate(String birthStr) {
		// 매개변수로 들어온 "1995-01-01"을 Date형으로 변환하여 return	
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr,"-");
		if(tokenizer.countTokens() ==3) {
			//생년월일 제대로 입력
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) -1;
			int day   = Integer.parseInt(tokenizer.nextToken());
			//result = new Date(year-1900, month,day);
			result = new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
		}else {
			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다");
		}
		return result;
	}

	private static Date toDateTodayIsBirthDayChk(String birthStr) {
		// 매개변수로 들어온 "1995-01-01"을 Date형으로 변환하고,오늘이 생일인지 확인 후 return
		return null;
	}
}







