package com.lec.ex06_book;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = {new Book("890-ㅁ01","java","신윤권"),
		           new Book("890-ㅂ02","oracle","오길동"),
		           new Book("890-ㅁ03","mysql","마이동"),
		           new Book("890-ㅂ04","jdbc","제갈동"),
		           new Book("890-ㄱ05","html","이에치")};
		Scanner scanner = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		do {
			System.out.println("1:대출 | 2:반납 | 3:책list | 0:종료 ");
			fn = scanner.nextInt();
			switch(fn) {
			case 1:
				System.out.println("대출할 책 이름은 ?");
				bTitle=scanner.next();
				for(idx=0; idx<books.length; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("현재 보유하지 않는 도서입니다");
				}else {
					if(books[idx].getState()==Book.STATE_BORROWED) {
						System.out.println("대출중인 도서입니다");
				}else {
					System.out.print("대출인?");
					borrower = scanner.next();
					System.out.print("대출일은 (07-07)?");
					checkOutDate = scanner.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
			}
				break;
			case 2:
				System.out.print("반납할 책이름은 ?");
				bTitle = scanner.next();
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("해당 도서는 본 도서관 책이 아닙니다");
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
