package com.lec.ex09_store;
// ���ð� 1ȣ��: �δ��-8,000 ,���뱹-���Ⱦ�
//StoreNum1 store1 = new StoreNum1("���ð�1ȣ��")
public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8,000");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-���Ⱦ�");
	}
}