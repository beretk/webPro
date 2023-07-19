package com.lec.ex06_01_book;

public class Book implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;
	public Book(String bookNo,String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	@Override
	public void checkOutDate(String borrowed, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println(bookTitle + "������ ������ �Դϴ�.");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + "������ ����ó�� �Ǿ����ϴ�.");
		System.out.println("������: " + borrower + "\t������" + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state==STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ��� �Ϸ�� å �Դϴ�.Ȯ�� �ٶ��ϴ�.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ� �Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��)";
		msg += state==STATE_BORROWED? "������(������: " + checkOutDate + ")" : "���Ⱑ��";
		System.out.println(msg);

	}
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	
}











