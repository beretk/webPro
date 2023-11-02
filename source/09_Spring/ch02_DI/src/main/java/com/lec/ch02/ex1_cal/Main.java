package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Main은  MyCalculation을 의존, MyClaculaton은 Calculator을 의존
public class Main {
	public  static void main(String[] args) {
//		Calculator cal = new Calculator();
//		MyCalculation myCal = new MyCalculation();
//		myCal.setCalculator(cal);
//		myCal.setNum1(10);
//		myCal.setNum2(5);
		String resourceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		MyCalcultion myCalcultion = ctx.getBean("myCal", MyCalcultion.class);
		myCalcultion.add();
		myCalcultion.sub();
		myCalcultion.mul();
		myCalcultion.div();
		ctx.close();
	}
}
