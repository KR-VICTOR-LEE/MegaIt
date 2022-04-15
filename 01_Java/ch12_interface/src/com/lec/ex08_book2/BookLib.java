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
		System.out.println(getBookTitle()+"�뿩�Ǿ���");
		System.out.println("������ : "+ borrower+"������ : "+checkoutDate);
	}
	@Override
	public void checkin() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle()+"�ݳ�");
			return;
		}
		borrower = null;
		checkoutDate = null;
		System.out.println("�ݳ��Ϸ�");
	}
	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"����) ����");
		}else if (state == STATE_BORROWED) {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"����) ����");
		}else {
			System.out.println(getBookNo()+"|"+getBookTitle()+"("+getWriter()+"����) ����");
		}
		
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	

}
