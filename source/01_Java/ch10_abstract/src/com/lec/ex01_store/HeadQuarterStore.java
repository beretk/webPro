package com.lec.ex01_store;
// 추상클래스 : 추상메소드가 1개 이상 있을때
// 추상 메소드 : 메소드명만 선언하고 구현은 없어.구현은 상속받은 클래스가 함(상속받은 클래스에게 오버라이드를 강요)
public abstract class HeadQuarterStore {
	
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	
	public abstract void kimchi();
	public abstract void bude() ;
	public abstract void bibim() ;
	public abstract void sunde() ;
	public abstract void gongibab() ;
	public String getStoreName() {
		return storeName;
	}
}