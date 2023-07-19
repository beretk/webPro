package com.lec.ex1_list;

import java.util.Date;
import java.util.ArrayList;

public class Ex03_FriendArrayListMain {
	public static void main(String[] args) {
//		Friend[] fs = new Friend[5];
//		fs[0] = new Friend("홍길동","010-9999-9999", new Date(98,0,1));
//		fs[1] = new Friend("김길동","010-8888-8888", new Date(98,6,14));
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동","010-9999-9999"));
		friends.add(new Friend("김길동","010-8888-8888", new Date(98,6,14)));
		friends.add(new Friend("마길동","010-7777-7777", new Date(98,6,14)));
		friends.add(new Friend("박길동","010-6666-6666", new Date(98,5,14)));
		friends.add(new Friend("윤길동","010-5555-5555", new Date(98,11,4)));
		for(Friend friend : friends) {
			System.out.println(friend);
		}
		for(int idx=0; idx<friends.size(); idx++) {
			System.out.println(idx + " : " + friends.get(idx));//idx:key값이라 함
		}
		// 0번 인덱스부터 끝까지 이름을 출력 하세요(확장for문,일반for문)
		for(Friend friend : friends) {
			System.out.print(friend.getName() + "\t");
		}
		System.out.println();
		for(int idx=0; idx<friends.size(); idx++) {
			System.out.print(friends.get(idx).getName() + "\t");
		}
	}
}







