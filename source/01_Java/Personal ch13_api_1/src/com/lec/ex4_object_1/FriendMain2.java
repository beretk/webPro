package com.lec.ex4_object_1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain2 {
	public static void main(String[] args) {
		Friend[]friends = {new Friend("홍길동","010-9999-8888","서울 서대문구",new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
						new Friend("신길동","010-8888-7777","경기도 안양시",new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
						new Friend("김길동", "010-7777-6666", "인천 중구", new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
						new Friend("박성광","010-6666-5555","서울 용산구", new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
						new Friend("윤동주", "010-5555-4444", "함북 청진시", new Date(new GregorianCalendar(1996,6,2).getTimeInMillis()))};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 지역을 입력(단,종료 원하면 x를 입력");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				String address = (String)friend.getAddress();
				int spaceIdx = address.indexOf(" ");
				
				String temp = address.substring(0, spaceIdx);
				if(searchWord.equalsIgnoreCase(temp)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("해당 지역의 친구는 없다");
			}
		}
	}
}
