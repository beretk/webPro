package strategy1.step2;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot       superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot           lowRobot = new LowRobot();
		Robot[] robots = {superRobot,standardRobot,lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			if(robot instanceof SuperRobot) {
				SuperRobot tempRobot = (SuperRobot)robot;
				tempRobot.actionfly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if (robot instanceof StandardRobot) {
				StandardRobot tempRobot = (StandardRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if(robot instanceof LowRobot	) {
				LowRobot tempLowRobot = (LowRobot)robot;
				tempLowRobot.actionFly();
				tempLowRobot.actionMissile();
				tempLowRobot.actionKnife();
			}//if
		}//for
	}//main
}
