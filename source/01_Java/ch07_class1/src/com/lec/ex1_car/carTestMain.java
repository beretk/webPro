package com.lec.ex1_car;

public class carTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("����"); //myPorsche.color = "����";
		myPorsche.setCc(3000);//myPorsche.cc    = 3000;
		System.out.println(myPorsche.getColor() + "�� �� :" + 
					myPorsche.getCc() + "cc, �ӵ� :" + myPorsche.getSpeed());
//		System.out.println(myPorsche.color + "�� �� :" + 
//					myPorsche.cc + "cc, �ӵ� :" + myPorsche.speed);
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");// yourPorsche.color = "gray";
		yourPorsche.drive();				
	}
}
