package com.lec.ex03_phone;

public class BModel implements IAcorporation {
	private String modelName = "B��";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �۽� ����");

	}

	@Override
	public void Lte() {
		System.out.println(modelName + "�� 5G �۽� ����");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ž��");
		
	}

}
