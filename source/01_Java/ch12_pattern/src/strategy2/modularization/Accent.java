package strategy2.modularization;

import strategy2.interfaces.EngingLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km20;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngingLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}

	@Override
	public void shape() {
		System.out.println("����Ʈ ������ ��,��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");

	}

}
