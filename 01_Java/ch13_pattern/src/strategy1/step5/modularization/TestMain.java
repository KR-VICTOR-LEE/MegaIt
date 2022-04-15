package strategy1.step5.modularization;

import strategy1.step4.innterfaces.FlyHight;

// 5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ� 
public class TestMain {

	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
		
//		for(Robot robot : robots) {
//			robot.shape();
//			robot.actionWalk();
//			robot.actionRun();
//			robot.actionFly();
//			robot.actionMissile();
//			robot.actionKninfe();
//		}
		// SuperRobot ���׷��̵� ��û : �����ֽ��ϴ� => ���� ��������մϴ� �� �����û.
		// ��������ϴ� ��ǰ ����� setFly�� ȣ��
		superR.setFly(new FlyHight());
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKninfe();
		}
	}

}
