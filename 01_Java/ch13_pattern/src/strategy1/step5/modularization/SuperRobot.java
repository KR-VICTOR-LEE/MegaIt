package strategy1.step5.modularization;

import strategy1.step4.innterfaces.FlyYes;
import strategy1.step4.innterfaces.IFly;
import strategy1.step4.innterfaces.IKnife;
import strategy1.step4.innterfaces.IMissile;
import strategy1.step4.innterfaces.KnifeLazer;
import strategy1.step4.innterfaces.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}

}
