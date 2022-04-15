package strategy1.step5.modularization;

import strategy1.step4.innterfaces.IFly;
import strategy1.step4.innterfaces.IKnife;
import strategy1.step4.innterfaces.IMissile;

public abstract class Robot {
	
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String ClassName = getClass().getName(); //strategy1.step2.SuperRobot
		int idx = ClassName.lastIndexOf('.'); //�� ������ '.' �� �ִ� ��ġ
		String name = ClassName.substring(idx+1); // idx+1 ��° �۾����� ������
		System.out.println(name +"superRobot�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
	public void actionKninfe() {
		knife.knife();
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
