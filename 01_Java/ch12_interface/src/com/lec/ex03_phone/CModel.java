package com.lec.ex03_phone;

public class CModel implements IAcorporation{
private String modelName = "C��";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �۽� �Ұ���");

	}

	@Override
	public void Lte() {
		System.out.println(modelName + "�� 5G �۽� �Ұ���");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ��ž��");
		
	}
}
