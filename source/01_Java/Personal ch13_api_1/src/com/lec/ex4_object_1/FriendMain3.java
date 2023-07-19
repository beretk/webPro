package com.lec.ex4_object_1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain3 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-8888","서울 서대문구",new Date(new GregorianCalendar(998,11,12).getTimeInMillis())),
				new Friend("신길동","010-8888-7777","경기 안양시" ,new Date(new GregorianCalendar(196,6,2).getTimeInMillis())),
				new Friend("김길동","010-7777-6666","인천시 중구" ,new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
				new Friend("박성광","010-6666-5555","서울 용산구" ,new Date(new GregorianCalendar(1980,4,14).getTimeInMillis())),
				new Friend("윤길봉","010-5555-4444","강원도 원주시",new Date(new GregorianCalendar(1890,4,28).getTimeInMillis()))};

		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		boolean searchOk = false;
		System.out.println("검색할 전번 뒤4자리 입력(단,종료 원하면 x입력");
		String searchWord = scanner.next();
		if(searchWord.equalsIgnoreCase("x"))break;
		for(Friend friend : friends) {
			String phone = (String)friend.getTel();
			int Idx = phone.lastIndexOf("-");
			String temp = phone.substring(Idx+1);
			if(searchWord.equalsIgnoreCase(temp)) {
				System.out.println(friend);
				searchOk = true;
			}
		}
		if(!searchOk) {
			System.out.println("해당 전화번호 친구 없다");
			}
		}
	}		
}
			
