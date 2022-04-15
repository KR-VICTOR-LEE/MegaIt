package com.lec.ex11_robot;
// RobotOrder order = new RobotOrder();
// order.action(****Çü °´Ã¼);
public class RobotOrder {
	public void action(Robot robot) {
		if (robot instanceof SingRobot){
			((SingRobot) robot).sing();
		}else if (robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if (robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
		}else {
			System.out.println("È®ÀåµÈ ·Îº¿");
		}
	}

}
