package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements 받은 클래스에서 함. method1");
	}

	@Override
	public String method2() {
		System.out.println("실제 구현은 implements한 클래스에서 함. method2");
		return null;
	}

}
