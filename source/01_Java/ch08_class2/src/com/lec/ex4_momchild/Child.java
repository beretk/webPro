package com.lec.ex4_momchild;
public class Child {
	private String name;
	static MomPouch momPouch = new MomPouch();
	public Child(String name) { //Child c1 = new Child("ù° �ʸ���"); c1.takemoney(100);
		this.name = name;
		//momPouch = new MomPouch();
	}
	public void takemoney(int money) {
		if(momPouch.money >=money) {
		momPouch.money -= money; //momPouch.money = momPouch.money
		System.out.println(name + "��" + money + "�� �������� ����������"+ momPouch.money + "�� ����");
		}else {
			System.out.println(name + "�� �� �� ����. ���� ���� ������"+ momPouch.money+ "�� ��");
		}//if
	}//takeMoney
}//class
