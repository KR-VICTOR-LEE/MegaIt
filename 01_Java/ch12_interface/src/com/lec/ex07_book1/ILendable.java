package com.lec.ex07_book1;

public interface ILendable {
	public int STATE_BORROWED = 1; // "���� ��"
	public int STATE_NORMAL = 0; // "���Ⱑ��"
	public void checkOut(String borrower, String checkoytDate); // ����� �����ΰ� ���⳯¥ �̿�.
	public void checkIn(); //�ݳ�
	public void printState(); // ���������� ���� ���� ���
}
