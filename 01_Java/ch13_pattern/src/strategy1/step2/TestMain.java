package strategy1.step2;

public class TestMain {

	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		
		for(Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
			if(robot instanceof SuperRobot) {
				SuperRobot r = (SuperRobot)robot;
				r.actionMissile();
				r.actionKnife();
				
			}else if(robot instanceof StandardRobot) {
				StandardRobot r = (StandardRobot)robot;
				r.actionMissile();
				r.actionKnife();
			}else if(robot instanceof LowRobot) {
				LowRobot r = (LowRobot)robot;
				r.actionMissile();
				r.actionKnife();
			}
		}
	}

}
