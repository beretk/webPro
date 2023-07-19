package com.lec.ex4_object_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain_1 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-8888","서울 서대문구",new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
						new Friend("신길동","010-8888-7777	","경기도 안양시",new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
						new Friend("김길동","010-8888-7777","인천 중구",new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
						new Friend("박성광","010-8888-6666","서울 용산구",	new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
						new Friend("윤동주","010-8888-5555","함북 청진시",	new Date(new GregorianCalendar(1996,6,2).getTimeInMillis()))};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 생일은 MM-dd로 입력(단,종료를 원하시면 x를 입력하시오");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				Date birthday = (Date)friend.getBirth();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String birthdayStr = sdf.format(birthday);
				if(searchWord.equals(birthdayStr)) {
					System.out.println(friend);
				}
			}
			if(!searchOk) {
				System.out.println("해당 생일의 친구가 없습니다.");
			}
		}
	}
}
