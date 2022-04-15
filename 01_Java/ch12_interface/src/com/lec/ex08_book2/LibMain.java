package com.lec.ex08_book2;

import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		
		BookLib[] books = {new BookLib("2022-03-01", "java", "ȫ�浿"),
						   new BookLib("2022-03-02", "oracle", "��浿"),
						   new BookLib("2022-03-03", "mysql", "���浿"),
						   new BookLib("2022-03-04", "jsp", "��浿"),
						   new BookLib("2022-03-05", "spring", "��浿")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		
		do {
	         System.out.println(("1:����| 2:�ݳ�| 3:ålist |0:����"));
	         fn = sc.nextInt();
	         switch (fn) {
	         case 1: 
	            //����ó�� : 1.å�̸� �Է�  2.å ��ȸ  3.å����Ȯ�� 4.������ �Է� 5.���⳯¥ 6.����޼ҵ� ȣ�� checkout
	            //1. å �̸� �Է� 
	            System.out.print("�����ϰ��� �ϴ� å �̸��� ? : ");
	            bTitle = sc.next(); //white-space �ձ����� ��Ʈ���� ���� 
	            //2. å ��ȸ 
	            
	            for(idx = 0; idx<books.length ; idx++) {
	               if(bTitle.equals(books[idx].getBookTitle())) {
	                  break;
	               }
	            }
	            if(idx == books.length) {
	               System.out.println("���� �������� ���� �����Դϴ�");
	            }else { 
	               
	               if(books[idx].getState() == BookLib.STATE_BORROWED) {  
	                  System.out.println("�˼��մϴ� ���� �������� �����Դϴ�.");
	               }else { 
	                  System.out.println("�����ڴ� ? : ");
	                  borrower = sc.next();
	                  System.out.println("���� ��¥�� ? : ");
	                  checkOutDate = sc.next();
	                  books[idx].checkOut(borrower, checkOutDate);
	                  }
	            }
	            break;
	         case 2: 
	            // 1. å�̸� 
	            System.out.println("�ݳ��� å �̸���? : ");
	            bTitle = sc.next();
	            //2. å��ȸ 
	            for(idx = 0; idx<books.length ; idx++) {
	               if(bTitle.equals(books[idx].getBookTitle())) {
	                  break;
	               }
	            }
	            if(idx==books.length) {
	               System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
	            }else { 
	               books[idx].checkin();
	            }
	            
	            break;
	         case 3:
	            System.out.println("å ����Ʈ�� ������ �����ϴ�");
	            for(BookLib b : books) {
	               b.printState();
	            }
	         case 0 :break;
	         
	         }
	      }while(fn!=0);
	      System.out.println("���� ���α׷� ����");
	}

}
