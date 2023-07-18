package com.lec.ex1_list;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Ex04_FriendsTodayisBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿","010-9999-9999"));//2023-07-14
		friends.add(new Friend("��浿","010-8888-8888", new Date(98,7,14)));
		friends.add(new Friend("���浿","010-7777-7777", new Date(98,7,14)));
		friends.add(new Friend("�ڱ浿","010-6666-6666", new Date(98,5,14)));
		friends.add(new Friend("���浿","010-5555-5555", new Date(98,11,4)));
		//������ ������ ģ���� ���
		System.out.print("������ ������ ģ���� ");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String nowStr = sdf.format(now);//"07-14"
		boolean none = true;
		for(Friend friend : friends) {
			Date birth = friend.getBirth();
			if(birth!=null && sdf.format(birth).equals(nowStr)) {
				System.out.print("\n " + friend);
				none = false;//������ ģ�� ã�Ҵ�
			}//if	
//			if(birth!=null) {
//				String birthStr = sdf.format(birth);
//				if(birthStr.equals(nowStr)) {
//					System.out.print("\n " + friend);
//					searchOk = true;//������ ģ�� ã�Ҵ�
//				}//if
		}//for
		if(none) {
			System.out.println("�����ϴ�");
		}//if
	}//main
}
