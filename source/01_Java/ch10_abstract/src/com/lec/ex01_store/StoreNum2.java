package com.lec.ex01_store;
//±èÄ¡Âî°³-5,000 ºÎ´ëÂî°³-5,000 ºñºö¹ä-5,000 ¼ø´ë±¹-5,000  °ø±â¹ä-¹«·á
public class StoreNum2 extends HeadQuarterStore {
	public StoreNum2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-8,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä-8,000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä-¹«·á");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-8,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹-8,000¿ø");
	}
}