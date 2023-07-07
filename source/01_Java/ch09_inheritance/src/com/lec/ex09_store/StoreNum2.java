package com.lec.ex09_store;

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
}

