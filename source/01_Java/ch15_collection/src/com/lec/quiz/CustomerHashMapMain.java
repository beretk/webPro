package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {

	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String,Customer>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address;
		
		while(true) {
			System.out.println("ȸ�������� ���� �Ͻðڽ��ϱ�(Y/N)?");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.println("�̸� ?");
			name = scanner.nextLine();
			System.out.println("��ȭ ?");
			tel = scanner.nextLine();
			System.out.println("�ּ� ?");
			address = scanner.nextLine();		
			
			customers.put(tel, new Customer(name, tel, address));			
		}
		if(customers.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");		
		}else {
			Iterator<String> iterator = customers.keySet().iterator();				
			while(iterator.hasNext()) {
//				String key = iterator.next();
//				System.out.println(customers.get(key));
				System.out.println(customers.get(iterator.next()));
			}
			
		}
	}
}
