package strategy1.step3;
public abstract class Robot {
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
	public void actionWalk() {
		
		System.out.println("걸을수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸수 있습니다.");
	}
	public void shape() {//" SuperRobot은 팔,다리,몸통,머리가 있습니다" 출력
		String className = getClass().getName(); // "strategy1.step2.SuperRobot"
		int idx = className.lastIndexOf(".");// 맨마지막에 나오는"."의 위치15
		String name = className.substring(idx+1); //16번째부터 끝까지 문자열을 추출
		System.out.println(name + "의 외형은 팔, 다리, 몸통, 머리가 있습니다");
	}
}
