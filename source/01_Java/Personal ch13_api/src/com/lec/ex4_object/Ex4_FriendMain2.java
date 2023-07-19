package com.lec.ex4_object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//��� �ּ� ��2�ڸ� ã��
public class Ex4_FriendMain2 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-9999", "���� ���빮��",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("�ű浿","010-8888-9999", "��⵵ �Ⱦ��",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("��浿", "010-8888-7777", "��õ �߱�",new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("�ڼ���", "010-8888-6666", "���� ��걸", new Date(new GregorianCalendar().getTimeInMillis())),
							new Friend("������", "010-8888-5555", "�Ժ� û����", new Date(new GregorianCalendar().getTimeInMillis()))};
		Scanner scanner =  new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��� ������ �Է�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�): ");
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
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}//if
		}//while
	}//main
}//class
