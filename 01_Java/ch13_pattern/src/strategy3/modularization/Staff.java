package strategy3.modularization;

import strategy3.interfaces.JobStudy;

public class Staff extends Person {

	private String part;
	
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part=part;
		setJob(new JobStudy());
		setGet(new );
	}

	@Override
	public void print() {
		super.print();
		System.out.println(part);
		
	}

}
