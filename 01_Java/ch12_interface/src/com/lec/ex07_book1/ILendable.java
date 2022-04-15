package com.lec.ex07_book1;

public interface ILendable {
	public int STATE_BORROWED = 1; // "대출 중"
	public int STATE_NORMAL = 0; // "대출가능"
	public void checkOut(String borrower, String checkoytDate); // 대출시 대출인과 대출날짜 이용.
	public void checkIn(); //반납
	public void printState(); // 도서정보와 대출 상태 출력
}
