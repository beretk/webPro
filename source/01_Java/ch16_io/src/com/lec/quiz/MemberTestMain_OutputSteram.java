package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_OutputSteram {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, birthStr, address;//����ڿ��� ���� ������
		Date birth;
		while(true){
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�(Y/N)?");
			if(scanner.next().equalsIgnoreCase("n")) break;
			answer = scanner.nextLine();
			System.out.println("�̸�?");
			name = scanner.next();
			System.out.println("��ȭ?");
			tel = scanner.next();
			System.out.println("����(yyyy-mm-dd)?");
			birthStr = scanner.next();//"1998-07-19"
			//birth = toDate(birthStr);
			birth = toDateTodayIsBirthDayChk(name,birthStr);
			System.out.println("�ּ�?");			
			address = scanner.nextLine();
			scanner.nextLine(); 
			//members.add(new Member(name,tel,birth,address));
			//System.out.println(new Member(name,tel,birthday,address));
			//members�� add
		} 
		if(members.size()==0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {
			for(Member member : members) {
				System.out.println(member);
			}
		}
	}
	private static Date toDateTodayIsBirthDayChk(String name, String birthStr) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Date toDate(String birthStr) {
		// �Ű������� ���� "1995-01-01"�� Date������ ��ȯ�Ͽ� return	
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr,"-");
		if(tokenizer.countTokens() ==3) {
			//������� ����� �Է�
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) -1;
			int day   = Integer.parseInt(tokenizer.nextToken());
			//result = new Date(year-1900, month,day);
			result = new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
		}else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�");
		}
		return result;
	}

	private static Date toDateTodayIsBirthDayChk(String birthStr) {
		// �Ű������� ���� "1995-01-01"�� Date������ ��ȯ�ϰ�,������ �������� Ȯ�� �� return
		return null;
	}
}







