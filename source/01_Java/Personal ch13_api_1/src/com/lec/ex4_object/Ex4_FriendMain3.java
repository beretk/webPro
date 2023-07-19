package com.lec.ex4_object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex4_FriendMain3 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-9999","서울 서대문구",new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
							new Friend("신길동","010-8888-9999","경기도 안양시",new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
							new Friend("김길동","010-8888-7777","인천 중구",new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
							new Friend("박성광","010-8888-6666","서울 용산구",new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
							new Friend("윤동주","010-8888-5555","함북 청진시",new Date(new GregorianCalendar(1996,6,2).getTimeInMillis()))};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 전화번호 뒷자리를 입력(단,종료를 원하시면 x를 입력 하시오): ");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x"))break;
			for(Friend friend : friends) {
				String tel = friend.getTel();
				int idx = tel.lastIndexOf("-");
				String temp = tel.substring(idx+1);
				if(searchWord.equalsIgnoreCase(temp)) {
					System.out.println(friend);
				}//if
			}//for
			if(!searchOk) {
				System.out.println("해당 전화번호 뒷 4자리인 친구는 없습니다.");
			}
		}
	}
}
