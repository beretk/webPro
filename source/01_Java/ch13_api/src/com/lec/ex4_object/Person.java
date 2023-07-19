package com.lec.ex4_object;
// ������(private) + ������ + �޼ҵ�(���, setter&getter, �������̵��� �޼ҵ�)
// Person p1 = new Person();
// Preson p2 = new Person(9812121212012L);
public class Person {
	private long juminNo; //9812121012012
	//public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "�ֹι�ȣ�� " + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2) : p1:this / p2:obj
		// (this.)juminNo�� obj.jumimNo ������ true�� return
		if(obj!=null && obj instanceof Person) {
			Person other = (Person)obj;
			boolean juminNoChk = ( juminNo == other.juminNo );
			return juminNoChk;
		}
		return false;
	}
}