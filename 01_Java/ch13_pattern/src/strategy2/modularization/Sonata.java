package strategy2.modularization;

import strategy2.interfaces.*;


public class Sonata extends Car {
	
	public Sonata() {
		setEngine(new EngineHigh());
		setKm(new Km15());
		setFeul(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("�ҳ�Ÿ door, sheet, handle�� �̷���� �ֽ��ϴ�.");

	}

}
