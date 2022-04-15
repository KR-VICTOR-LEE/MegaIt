package com.lec.ex2_thread;

public class TargerEx02 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i+"번째, 반값습니다");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}

}
