package com.lec.ex4_threadNObjectN;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		System.out.println("target1의 num :"+target1.getNum());
		System.out.println("target2의 num :"+target2.getNum());
		System.out.println("main 함수 끝");
	}

}
