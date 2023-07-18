package strategy1.step2;

public class LowRobot extends Robot {
	public void actionFly() {
	System.out.println("날수 없습니다.");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠수 없습니다.");
	}
	public void actionKnife() {
		System.out.println("검이 없습니다.");
	}
}
