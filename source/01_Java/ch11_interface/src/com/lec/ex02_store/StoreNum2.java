package com.lec.ex02_store;
//��ġ�-5,000 �δ��-5,000 �����-5,000 ���뱹-5,000  �����-����
public class StoreNum2 implements HeadQuarterStore {
	private String storeName;
	public StoreNum2(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8,000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����-8,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("�����-����");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�-8,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-8,000��");
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}