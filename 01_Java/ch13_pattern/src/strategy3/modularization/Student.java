package strategy3.modularization;

import strategy3.interfaces.*;

public class Student extends Person {

	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban=ban;
	}

	@Override
	public void print() {
		System.out.println(ban);
		
	}
}