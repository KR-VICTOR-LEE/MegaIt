package strategy2.modularization;

import strategy2.interfaces.*;
// 3���� ��ǰ ���� / ������ X / drive(�Ϲ�), shape(�߻�)
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel feul;
	
	
	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ�.");
	};
	public abstract void shape();
	
	public void engine() {
		engine.engine();
	}
	public void km() {
		km.km();
	}
	public void feul() {
		feul.fuel();
	}
	
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public void setFeul(IFuel feul) {
		this.feul = feul;
	}
	
	
}
