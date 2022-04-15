package strategy3.modularization;

import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;

public class Person {
	
	private String id;
	private String name;
	private IGet get;
	private IJob job;
	
			
	public Person(String id, String name) {
		this.id=id;
		this.name=name;
	}
		
		
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	
	
	public void print() {
		System.out.println("[id]"+id+"\t[name]"+name);
	}
	
	public void setID(String id) {
		id = id;
	
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setGet(IGet get) {
		this.get = get;
	}



	public void setJob(IJob job) {
		this.job = job;
	}
	

}
