package strategy1.step5.modularization;
import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifeToy;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot    superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot      lowRobot      = new LowRobot();
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}// for
		System.out.println("SuperRobt ���� ���� ���� ���� �ִ� ������� ���׷��̵�");
		superRobot.setFly(new FlyHigh());
		superRobot.shape();
		superRobot.actionFly();
		System.out.println("LowRobot�� �峭�� ���� �ִ� ������� ���׷��̵�");
		lowRobot.setKnife(new KnifeToy());
		lowRobot.shape();
		lowRobot.actionKnife();
	}//main
}

