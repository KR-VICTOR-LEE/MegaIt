package strategy2.modularization;

import strategy2.interfaces.*;

public class Accent extends Car {

	public Accent() {
		setEngine(new EngineHigh());
		setKm(new Km15());
		setFeul(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("����Ʈ door, sheet, handle�� �̷���� �ֽ��ϴ�.");

	}

}
