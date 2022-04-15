package com.lec.ex2_thread;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx01 threadA = new TargetEx01("A");
		TargerEx02 threadB = new TargerEx02();
		
		threadB.setName("B");
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main ÇÔ¼ö ³¡");
	}

}
