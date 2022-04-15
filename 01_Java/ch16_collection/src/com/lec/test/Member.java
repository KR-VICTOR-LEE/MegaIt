package com.lec.test;

public class Member {
	private String name;
	private String number;
	private String address;
	
	public Member() {}
	
	public Member(String name, String address, String number) {
		this.name = name;
		this.address = address;
		this.number = number;
	}



	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return  name + "�ּ� : " + address + "��ȣ :" + number + "]";
	}
	
	
}
