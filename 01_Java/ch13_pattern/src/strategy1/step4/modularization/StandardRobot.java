package strategy1.step4.modularization;

import strategy1.step4.innterfaces.*;


public class StandardRobot extends Robot{

	private IMissile missile;
	private IKnife knife;
	private IFly fly;
	
	
		public StandardRobot() {
			setFly(new FlyNo());
			setMissile(new MissileYes());
			setKnife(new KnifeWood());
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
