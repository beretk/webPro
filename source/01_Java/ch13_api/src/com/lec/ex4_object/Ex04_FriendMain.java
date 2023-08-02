package com.lec.ex4_object;
// ����(MM-dd)�˻�
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-9999","���� ���빮��",
							new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
				new Friend("�ű浿","010-8888-9999","�Ⱦ� ���ȱ�",
						new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
				new Friend("��浿","010-8888-7777","��õ �߱�",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
				new Friend("�ڼ���","010-8888-6666","���� ��걸",
						new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
				new Friend("������","010-8888-5555","�Ժ� û����",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())) };
		Scanner scanner = new Scanner(System.in);
		//�˻��� ���� �Է�(07-22) => �迭 �˻�(0��° �ε������� �����߿� MM-dd�� ������ ������ ���� ������ ���)
		while(true) {
			boolean searchOk = false; // �� ã�Ҵٸ� �ʱ�ȭ
			System.out.print("�˻��� ������ MM-dd�� �Է� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchWord = scanner.next(); //07-22
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends	) {
				Date birth = (Date) friend.getBirthday();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String birthStr = sdf.format(birth);//
				if( searchWord.equals(birthStr)) {
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








