package com.lec.ex10_final;
//speed, running(),stop();�������̵����
public final class Rabbit extends Animal {// Rabbit Ŭ������ ����ϴ°��� ����
	@Override
	public void running() {
		speed += 30;
		System.out.println("��Ⱑ ���沱�� �پ��. ���� �ӵ� : " + speed);
	}
}