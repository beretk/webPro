package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class QuizSawon {
	private String saben;
	private String name;
	private String part;
	private Date hiredate;

	public QuizSawon(String saben,String name,String part) {
		this.saben = saben;
		this.name  = name;
		this.part  = part;
		hiredate = new Date();
	}
	public QuizSawon(String saben,String name,String part,int y, int m, int d) {
		this.saben = saben;
		this.name  = name;
		this.part  = part;
		hiredate = new Date(new GregorianCalendar(y, m-1,d).getTimeInMillis());
	}	
//	public String infString() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 m월 d일");
//		return "[사번]"+ saben +"\t[이름]"+name + "\t[부서]" + part + "\t[입사일]" + sdf.format(hiredate);
//	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		return "[사번]" + saben + "\t[이름]" + name + "\t[부서]" + part + "\t[입사일]"+ sdf.format(hiredate);
	}
}




