package com.lec.ex02_store;
// 앞장의 추상클래스를 인터페이스로 변경
public interface HeadQuarterStore {
	public abstract void kimchi(); 
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde(); 
	public abstract void gongibab();
	public String getStoreName(); 
}