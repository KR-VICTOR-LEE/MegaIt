package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{

	@Override
	public void method1() {
		System.out.println("���� ������ implements ���� Ŭ�������� ��. method1");
	}

	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� ��. method2");
		return null;
	}

}
