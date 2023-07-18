package com.lec.ex06_book;
// Book book = new Book("890-��01", "Java", "������");
public class Book implements ILendable {
	private String bookNo;   //û����ȣ
	private String bookTitle;//å�̸�
	private String writer;   //����
	private String borrower; //������
	private String checkOutDate; //������(07-07)
	private byte   state;    //���Ⱑ��(0),������(1)	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = 0
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {//����
		if(state == STATE_BORROWED) {//�������� �����̸� �޼��� �Ѹ��� �޼ҵ� ��
			System.out.println(bookTitle + " ������ �������Դϴ�");
			return;
		}
		// state 0 (STATE_NORMAL)�̶� ��������
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;//������ ���·� ��ȯ
		System.out.println(bookTitle + "������ ����Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {//�ݳ�
		if(state == STATE_NORMAL) {//���Ⱑ���� å�̸� �޼��� �Ѹ��� �޼ҵ� ��
			System.out.println(bookTitle + "������ �ݳ��� �Ϸ�� å�Դϴ�.Ȯ���ϼ���");
			return;
		}// state�� ������(1)�̶� �ݳ�ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");		
	}
	@Override
	public void printState() {//"890-��1 Java(��������) ���Ⱑ��"
//		if(state == STATE_BORROWED) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "��) - ������");
//		}else if(state == STATE_NORMAL){
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "��) - ���Ⱑ��");
//		}
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��)";
		msg += state==STATE_BORROWED ? "������(������ :" + checkOutDate + ")" : "���Ⱑ��";
		System.out.println(msg);
	}
	//getter
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




