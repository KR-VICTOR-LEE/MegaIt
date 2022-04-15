package com.lec.ex05homework;

import java.util.Date;

public class Member {
	private String name;
	private String number;
	private String birth;
	private String address;
	
	public Member () {}
	
	@Override
	public String toString() {
		return name+"\t" + number+"\t" + birth+"\t" + address+"\t";
	}
	
	
	public Member(String name, String number, String birth, String address) {
		this.name = name;
		this.number = number;
		this.birth = birth;
		this.address = address;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
