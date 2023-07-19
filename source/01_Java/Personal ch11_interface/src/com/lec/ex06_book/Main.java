package com.lec.ex06_book;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = {new Book("890-��01","java","������"),
		           new Book("890-��02","oracle","���浿"),
		           new Book("890-��03","mysql","���̵�"),
		           new Book("890-��04","jdbc","������"),
		           new Book("890-��05","html","�̿�ġ")};
		Scanner scanner = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		do {
			System.out.println("1:���� | 2:�ݳ� | 3:ålist | 0:���� ");
			fn = scanner.nextInt();
			switch(fn) {
			case 1:
				System.out.println("������ å �̸��� ?");
				bTitle=scanner.next();
				for(idx=0; idx<books.length; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				}else {
					if(books[idx].getState()==Book.STATE_BORROWED) {
						System.out.println("�������� �����Դϴ�");
				}else {
					System.out.print("������?");
					borrower = scanner.next();
					System.out.print("�������� (07-07)?");
					checkOutDate = scanner.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
			}
				break;
			case 2:
				System.out.print("�ݳ��� å�̸��� ?");
				bTitle = scanner.next();
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("�ش� ������ �� ������ å�� �ƴմϴ�");
				}else {
					books[idx].checkIn();
				}
				break;
			case 3:
				for(Book book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("BYE");
	}
}
