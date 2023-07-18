package strategy2.modularization;

import strategy2.interfaces.EngingHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngingHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("���׽ý� ������ ��,��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");

	}

}
