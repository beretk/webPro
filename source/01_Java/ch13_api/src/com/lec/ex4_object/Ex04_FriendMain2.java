package com.lec.ex4_object;
// ��� ����(�ּҾ�2�ڸ�) �˻�
// ��ȭ��ȣ ��4�ڸ� �˻�
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendMain2 {
	private static DateFormat sdf;

	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-9999","���� ���빮��",
							new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
				new Friend("�ű浿","010-8888-9999","��⵵ ���ȱ�",
						new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
				new Friend("��浿","010-8888-7777","��õ �߱�",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
				new Friend("�ڼ���","010-8888-6666","���� ��걸",
						new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
				new Friend("������","010-8888-5555","�Ժ� û����",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())) };
		Scanner scanner = new Scanner(System.in);
		//�˻��� ���� �Է�(����) => �迭 �˻�(0��° �ε�������  ������ ���� ������ ���)
		while(true) {
			boolean searchOk = false; // �� ã�Ҵٸ� �ʱ�ȭ
			System.out.print("�˻��� ������ �Է� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchWord = scanner.next();  
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends	) {
				String address = (String) friend.getAddress();
				int spaceIdx = address.indexOf(" ");
				String temp = address.substring(0, spaceIdx);//
				if( searchWord.equals(temp)) {
					System.out.println(friend);
					searchOk = true;
				}//if
			}//for ; ��� �����ϱ�
			if(!searchOk) { //�ش� ������ ģ���� �� ã��
				System.out.println("�ش� ������ ģ���� �����ϴ�");
			}//if
		} 
	}
} 








