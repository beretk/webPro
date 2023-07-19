package com.lec.ex4_object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//사는 주소 앞2자리 찾기
public class Ex4_FriendMain2 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-9999", "서울 서대문구",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("신길동","010-8888-9999", "경기도 안양시",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("김길동", "010-8888-7777", "인천 중구",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("박성광", "010-8888-6666", "서울 용산구", new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("윤동주", "010-8888-5555", "함북 청진시", new Date(new GregorianCalendar().getTimeInMillis()))};
		Scanner scanner =  new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 지역을 입력(단, 종료를 원하시면 x를 입력하시오): ");
			String searWord = scanner.next();
			if(searWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				String address = friend.getAddress();
				int spaceIdx = address.indexOf(" ");
				String temp = address.substring(0,spaceIdx);
				if(searWord.equalsIgnoreCase(temp)) {
					System.out.println(friend);
					searchOk = true;
				}//if				
			}//for
			if(!searchOk) {
				System.out.println("해당 지역의 친구는 없습니다.");
			}//if
		}//while
	}//main
}//class
