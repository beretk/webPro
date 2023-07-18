package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999", "���� �߱�", new Date(98,11,12)));
		friends.add(new Friend("�ű浿", "010-8888-8888", "��� �Ⱦ�", new Date(98,6,22)));
		friends.add(new Friend("��浿", "010-7777-7777", "��õ �߱�", new Date(96,6,22)));
		friends.add(new Friend("�ڼ���", "010-6666-6666", "���� ���", new Date(96,6,2)));
		friends.add(new Friend("���缮", "010-5555-5555", "���� ����", new Date(89,5,24)));

		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ� �Է�(��, ���Ḧ ���Ͻø� x�� �Է� �Ͻÿ�)");
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
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}
		}	
	}
}
