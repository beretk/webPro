package com.lec.ex3_square;
// 속성,[생성자 함수,] 메소드, {setter&getter]
// Square s = new Square();
// Square s = new Square(10);
public class Square {
	 private int side;
	 public Square() { // 생성자 함수 : return 타입이 업소 클래스 명과 같은 이름의 함수
		 System.out.println("매개변수 없는 생성자 함수 호출");
	 }
	 public Square(int side) { // 생성자 함수 용도 : 데이터 초기화
		 this.side = side;
		 System.out.println("매개변수 있는 생성자 함수 호출");
	 }
	 public int area() {
		 return side*side;
	 }
	 // setter& getter(s1.setSide, s1.getSide)
	 public void setSide(int side ) {
		 this.side = side;
	 }
	 public int getSide() {
		 return side;
	 }
}
