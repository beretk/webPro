package com.lec.ex1_car;

public class carTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("����");
		myPorsche.setCc(3000);
		System.out.println(myPorsche.getColor() + "�� �� :" + 
				myPorsche.getCc() + "cc, �ӵ� :" + myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}
