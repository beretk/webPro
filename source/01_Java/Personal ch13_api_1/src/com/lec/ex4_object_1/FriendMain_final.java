package com.lec.ex4_object_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain_final {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-8888","���� ���빮��",new Date(new GregorianCalendar(998,11,12).getTimeInMillis())),
				new Friend("�ű浿","010-8888-7777","��� �Ⱦ��" ,new Date(new GregorianCalendar(196,6,2).getTimeInMillis())),
				new Friend("��浿","010-7777-6666","��õ�� �߱�" ,new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
				new Friend("�ڼ���","010-6666-5555","���� ��걸" ,new Date(new GregorianCalendar(1980,4,14).getTimeInMillis())),
				new Friend("�����","010-5555-4444","������ ���ֽ�",new Date(new GregorianCalendar(1890,4,28).getTimeInMillis()))};
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			boolean searchOk = false;			
			System.out.println("�˻��� ����,����,�ּ�,���� ��(��, �������? �׷���x��");
			String searhWord = scanner.next();
			if(searhWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				
//				String phone = (String)friend.getPhone();
//				int Idx = phone.lastIndexOf("-");
//				String temp = phone.substring(Idx+1);
//				if(searhWord.equalsIgnoreCase(temp)) {
//					System.out.println(friend);
//					searchOk = true;
//					
				String address = (String)friend.getAddress();
				int spaceIdx = address.indexOf(" ");
				String temp = address.substring(0, spaceIdx);
				if(searhWord.equalsIgnoreCase(temp)) {
					System.out.println(friend);
					searchOk = true;	
				
//				Date birth = (Date)friend.getBirthday();
//				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
//				String temp = sdf.format(birth);
//				if(searhWord.equals(temp)) {
//					System.out.println(friend);
//					searchOk = true;	
				}
			}
			if(!searchOk) {
				System.out.println("�ش� ��ȭ��ȣ ģ�� ����");
			}
		}
	}
}
