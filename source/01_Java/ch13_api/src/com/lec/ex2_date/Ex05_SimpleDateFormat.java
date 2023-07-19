package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date();
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar();
		/* yyyy(년도 4자리) yy(년도 2자리) MM(월 2자리:07) M(월:7) dd(일2자리 :09) d(일:9) E(요일)
		 * a(오전/오후) H(24시) h(12시) m(분) s(초)
		 * w(올해 몇번째 주인지) W(이번 월 몇번째 주인지) D(올해 몇번째 날)		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) a HH시(a hh시) mm분 ss초");
		String nowDateStr = sdf.format(nowDate);
		System.out.println(nowDateStr);
		String nowCalStr = sdf.format(nowCal.getTime());//nowCal.getTime(): Date형으로 전환
		System.out.println(nowCalStr);
		String nowGcStr = sdf.format(nowGc.getTime());
		System.out.println(nowGcStr);
	}
}
