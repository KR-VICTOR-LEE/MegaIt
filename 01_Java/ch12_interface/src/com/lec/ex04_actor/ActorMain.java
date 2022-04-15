package com.lec.ex04_actor;

public class ActorMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		System.out.println("---------------------------------");
		
		FireFighter parkfire = new Actor("소방관");
		parkfire.outFire();
		parkfire.saveMan();
		System.out.println("---------------------------------");
		
		IChef parkchef = new Actor("요리사");
		parkchef.makePizza();
		parkchef.makeSpaghetti();
		System.out.println("---------------------------------");
		
		PoliceMan parkpolice = new Actor("경찰");
		parkpolice.canCatchCriminal();
		parkpolice.canSearch();

	}

}
