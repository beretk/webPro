package strategy1.step3;
// actionWalk(),actionRun(),shape()
public class SuperRobot extends Robot {
	
	@Override
	public void actionFly() {
		System.out.println("날수 있습니다.");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠수 있습니다.");
	}
	@Override
	public void actionKnife() {
		System.out.println("레이저 검이 있습니다.");
	}
}
