package strategy1.step4.modularization;

import strategy1.step4.innterfaces.FlyYes;
import strategy1.step4.innterfaces.IFly;
import strategy1.step4.innterfaces.IKnife;
import strategy1.step4.innterfaces.IMissile;
import strategy1.step4.innterfaces.KnifeLazer;
import strategy1.step4.innterfaces.MissileYes;

public class SuperRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;

	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}

	

	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {

	}

	@Override
	public void actionKninfe() {

	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
