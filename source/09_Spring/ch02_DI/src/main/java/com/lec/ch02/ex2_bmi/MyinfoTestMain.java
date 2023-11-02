package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyinfoTestMain {
	public static void main(String[] args) {
		String resource1 = "classpath:applicationCTX2_f.xml";
		String resource2 = "classpath:applicationCTX2_m.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resource1, resource2);
		Myinfo woman = ctx.getBean("woman", Myinfo.class);
		Myinfo man = (Myinfo) ctx.getBean("man");
		woman.inforPrint();
		man.inforPrint();
		ctx.close();
	}
}	
