package com.lec.ex1_car;

public class carTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("빨강");
		myPorsche.setCc(3000);
		System.out.println(myPorsche.getColor() + "색 차 :" + 
				myPorsche.getCc() + "cc, 속도 :" + myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}
