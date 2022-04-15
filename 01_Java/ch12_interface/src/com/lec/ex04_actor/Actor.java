package com.lec.ex04_actor;

public class Actor implements FireFighter, IChef, PoliceMan{
private String name;
	
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public void makePizza() {
		System.out.println(name+"은 make a pizza");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"은 make a spaghetti");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name+("은 sava a peple"));
	}

	@Override
	public void canSearch() {
		System.out.println(name+"은 search a peple");
		
	}

	@Override
	public void outFire() {
		System.out.println(name+"은 out Fire");
	}

	@Override
	public void saveMan() {
		System.out.println(name+"은 save a man");
	
	}
}
