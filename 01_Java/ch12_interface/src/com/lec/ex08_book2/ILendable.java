package com.lec.ex08_book2;

public interface ILendable {
	public int STATE_BORROWED = 1;
	public int STATE_NORMAL = 0;
	public void checkOut(String borrower, String checkoutDate);
	public void checkin();
	public void printState();

}
