package com.lec.ex02_store;
// ÁÖÅÃ°¡ 1È£Á¡: ±èÄ¡Âî°³-8,000  ºÎ´ëÂî°³-9,000  ºñºö¹ä-9,000 ,¼ø´ë±¹-¾ÈÆÈ¾Æ
//StoreNum1 store1 = new StoreNum1("ÁÖÅÃ°¡1È£Á¡")
public class StoreNum1 implements HeadQuarterStore {
	private String storeName;
	public StoreNum1(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ - 8,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-8,000");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹-¾ÈÆÈ¾Æ");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä-9,000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä-1,000¿ø");
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}