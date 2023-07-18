package strategy1.step3;
public abstract class Robot {
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
	public void actionWalk() {
		
		System.out.println("������ �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�ۼ� �ֽ��ϴ�.");
	}
	public void shape() {//" SuperRobot�� ��,�ٸ�,����,�Ӹ��� �ֽ��ϴ�" ���
		String className = getClass().getName(); // "strategy1.step2.SuperRobot"
		int idx = className.lastIndexOf(".");// �Ǹ������� ������"."�� ��ġ15
		String name = className.substring(idx+1); //16��°���� ������ ���ڿ��� ����
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
	}
}
