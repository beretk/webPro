package com.lec.ex06_book;

public class Book implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrowe;
	private String checkOutDate;
	private byte state;
	private String borrower;
	public Book(String bookNo,String bookTitle,String writer ) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(bookTitle + "������ ������ �Դϴ�.");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + "������ ����Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ��� �Ϸ�� å�Դϴ�. Ȯ���ϼ���.");
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
		msg += state == STATE_BORROWED ? "������(������ : " + checkOutDate + ")" : "���Ⱑ��";
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

	public String getBorrowe() {
		return borrowe;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	
}
