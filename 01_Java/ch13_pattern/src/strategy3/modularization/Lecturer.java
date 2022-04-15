package strategy3.modularization;

import strategy3.interfaces.*;

public class Lecturer extends Person {
	
	
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject=subject;
	}

	@Override
	public void print() {
		System.out.println(subject);
		
	}

}
