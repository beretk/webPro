package strategy1.step4.interfaces;
public class MissileYes implements MissileImpl {
	@Override
	public void missile() {
		System.out.println("마사일을 쏠 수 있습니다");
	}
}
