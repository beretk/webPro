package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999", "서울 중구", new Date(98,11,12)));
		friends.add(new Friend("신길동", "010-8888-8888", "경기 안양", new Date(98,6,22)));
		friends.add(new Friend("김길동", "010-7777-7777", "인천 중구", new Date(96,6,22)));
		friends.add(new Friend("박성광", "010-6666-6666", "서울 용산", new Date(96,6,2)));
		friends.add(new Friend("한재석", "010-5555-5555", "강원 원주", new Date(89,5,24)));

		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 주소 앞 글자 2자리 입력(단, 종료를 원하시면 x를 입력 하시오)");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				String address = (String)friend.getAddress();
				int spaceIdx = address.indexOf(" ");
				String temp = address.substring(0, spaceIdx);
				if(searchWord.equals(temp)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("해당 지역의 친구가 없습니다.");
			}
		}	
	}
}
