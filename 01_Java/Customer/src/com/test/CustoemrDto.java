package com.test;

public class CustoemrDto {
	private int cno;
	private String ctel;
	private String cname;
	private int cpoint;
	
	public CustoemrDto() {}
	public CustoemrDto(int cno, String ctel, String cname, int cpoint) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
	}
	@Override
	public String toString() {
		return  cno + "\t" + ctel + "\t" + cname + "\t" + cpoint;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	
	

}
