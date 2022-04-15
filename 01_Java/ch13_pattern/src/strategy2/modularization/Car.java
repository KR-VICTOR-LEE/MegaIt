package strategy2.modularization;

import strategy2.interfaces.*;
// 3가지 부품 변수 / 생성자 X / drive(일반), shape(추상)
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel feul;
	
	
	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
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
