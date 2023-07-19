package com.lec.ex4_object_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-9999","���� ���빮��",new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
							new Friend("�ű浿","010-8888-7777","��⵵ �Ⱦ��",new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
							new Friend("��浿","010-7777-6666", "��õ �߱�", new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
							new Friend("�ڼ���", "010-6666-5555", "���� ��걸",new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
							new Friend("������", "010-5555-4444", "�Ժ� û����",new Date(new GregorianCalendar(1996,6,2).getTimeInMillis()))};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��� ������ MM-dd�� �Է� �Ͻÿ�(��,���Ḧ ���Ͻø� x�� �Է� �Ͻÿ�.");
			String searchWord = scanner.next();
			
			if(searchWord.equalsIgnoreCase("x"))break;
			
			for(Friend friend : friends) {
				Date birth = (Date)friend.getBirth();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String temp = sdf.format(birth);
				
				if(searchWord.equals(temp)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}
		}
	}
}
