package com.lec.ex03_phone;

public class BModel implements IAcorporation {
	private String modelName = "B모델";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송신 가능");

	}

	@Override
	public void Lte() {
		System.out.println(modelName + "은 5G 송신 가능");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 탑재");
		
	}

}
