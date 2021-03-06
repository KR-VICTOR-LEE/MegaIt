package strategy1.step4.modularization;

import strategy1.step4.innterfaces.*;


public class LowRobot extends Robot {
	
	private IMissile missile;
	private IKnife knife;
	private IFly fly;
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
		
		
	}

	@Override
	public void actionFly() {
		fly.fly();

	}

	@Override
	public void actionMissile() {
		missile.missile();

	}

	@Override
	public void actionKninfe() {
		knife.knife();

	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

}
