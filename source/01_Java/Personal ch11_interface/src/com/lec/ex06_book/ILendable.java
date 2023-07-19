package com.lec.ex06_book;

public interface ILendable {
//	public byte STATE_BORROWED = 1; //대출중
//	public byte STETE_NORMAL   = 0; //대출가능
//	public void checkOut(String borrower, String checkOutDate);
//	public void checkIn();
//	public void printState();
//	public byte STATE_BORROWED = 1;
//	public byte STATE_NORMAL   = 0;
//	public void checkOut(String borrewdr,String checkOutDate);
//	public void checkIn();
//	public void printState();
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL   = 0;
	public void checkOut(String borrower,String checkOutDate);
	public void checkIn();
	public void printState();
}
