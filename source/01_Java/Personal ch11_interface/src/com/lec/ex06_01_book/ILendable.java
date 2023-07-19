package com.lec.ex06_01_book;

public interface ILendable {
	
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL   = 0;
	public void checkOutDate(String borrowed, String checkOutDate);
	public void checkIn();
	public void printState();
}

