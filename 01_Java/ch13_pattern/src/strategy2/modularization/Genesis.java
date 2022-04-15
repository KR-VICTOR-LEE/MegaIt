package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {

	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFeul(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("���׽ý� door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
