package com.lec.ex04_actor;

public class ActorMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		System.out.println("---------------------------------");
		
		FireFighter parkfire = new Actor("�ҹ��");
		parkfire.outFire();
		parkfire.saveMan();
		System.out.println("---------------------------------");
		
		IChef parkchef = new Actor("�丮��");
		parkchef.makePizza();
		parkchef.makeSpaghetti();
		System.out.println("---------------------------------");
		
		PoliceMan parkpolice = new Actor("����");
		parkpolice.canCatchCriminal();
		parkpolice.canSearch();

	}

}
