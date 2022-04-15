package com.lec.ex08_book2;

public class BookLib extends BookInfo implements ILendable{
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}
	
	private String borrower;
	private String checkoutDate;
	private int state;
	
	@Override
	public void checkOut(String borrower, String checkoutDate) {
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		
		if (state == STATE_BORROWED) {
			System.out.println("int");
			return;
		}
		state = STATE_BORROWED;
		System.out.println(getBookTitle()+"대여되었음");
		System.out.println("대출인 : "+ borrower+"대출일 : "+checkoutDate);
	}
	@Override
	public void checkin() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle()+"반납");
			return;
		}
		borrower = null;
		checkoutDate = null;
		System.out.println("반납완료");
	}
	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"지음) 가능");
		}else if (state == STATE_BORROWED) {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"지음) 진행");
		}else {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"지음) 예외");
		}
		
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	

}
