package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

//N(n)�� �Է��Ҷ����� ���̸�,��ȭ, �ּҸ� �Է¹޾� arrayList add
//N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)

public class CustomerArrayListMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();//������ ȸ������ add
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address;
		//N(n)�� �Է��Ҷ����� ���̸�,��ȭ, �ּҸ� �Է¹޾� arrayList add
		
		while(true) {
			System.out.println("ȸ�������� �����ϰڽ��ϱ�(Y/N)?");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
			//�̸�, ��ȭ��ȣ,, �ּҸ� �Է¹޾� customer��ü ����� customers.add�ϱ�
			System.out.println("�̸�?");
			name = scanner.nextLine();
			System.out.println("��ȭ?");
			tel = scanner.nextLine();
			System.out.println("�ּ�?");
			address = scanner.nextLine();
			//customers.add(�Է¹��� ������ ���� ���� customer ��ü);
			customers.add(new Customer(name, tel, address));
//			Customer customer = new Customer();//customer.name = null tel=null address=null
//			System.out.println("�̸� ? ");
//			customer.setName(scanner.nextLine());
//			System.out.println("��ȭ ? ");
//			customer.setTel(scanner.nextLine());
//			System.out.println("�ּ�? ");
//			customer.setAddress(scanner.nextLine());
//			customers.add(customer);
		}
		//N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
		if(customers.size()==0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {
			//customers ���(Ȯ�� for��, �Ϲ� for�� ��� ����)
			for(Customer customer : customers) {
				System.out.println(customer);
			
			}
		}
	}
}




