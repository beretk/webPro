package com.lec.ex01_store;
// ���ð� 1ȣ��: ��ġ�-8,000  �δ��-9,000  �����-9,000 ,���뱹-���Ⱦ�
//StoreNum1 store1 = new StoreNum1("���ð�1ȣ��")
public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� - 8,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8,000");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-���Ⱦ�");
	}
	@Override
	public void bibim() {
		System.out.println("�����-9,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("�����-1,000��");
	}
}