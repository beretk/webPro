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
			System.out.println(bookTitle + "도서는 대출중 입니다.");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + "도서가 대출되었습니다.");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle + "도서는 반납이 완료된 책입니다. 확인하세요.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료 되었습니다.");
	}

	@Override
	public void printState() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "저)";
		msg += state == STATE_BORROWED ? "대출중(대출일 : " + checkOutDate + ")" : "대출가능";
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
