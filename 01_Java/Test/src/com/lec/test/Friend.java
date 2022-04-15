package com.lec.test;

public class Friend {
	private String name;
	private String phone; 
	private String address;
	private String birthday;
	
	
	public Friend(String string, int i) {}
	
	@Override
	public String toString() {
		return "\n捞抚 :"+ name + "\n林家 : "+ address + "\n锅龋 : "+ phone + "\n积老 :" + birthday;
	}



	public Friend(String name, String address, String phone,  String birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	

}
