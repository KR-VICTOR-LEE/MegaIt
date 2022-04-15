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
		System.out.println("엑센트 door, sheet, handle로 이루어져 있습니다.");

	}

}
