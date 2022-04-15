package com.lec.test;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] fiFriends = { new Friend("ȫ�浿", "����� ��걸", "010-9999-1234", "05-22"),
				new Friend("�ű浿", "����� ������", "010-8888-8888", "03-28"),
				new Friend("���浿", "����� ������", "010-8888-9999", "08-22") };

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ� �Է� ����(X)");
			String searchAddress = sc.next();
			if (searchAddress.equalsIgnoreCase("x")) {
				break;
			}
			boolean Ok = false;
			for (int i = 0; i < fiFriends.length; i++) {
				String address = fiFriends[i].getAddress();
				String search = address.substring(0,2);
				if (search.equals(searchAddress)) {
					System.out.println(fiFriends[i]);
					Ok = true;
				} 
			}
			if(! Ok) {
				System.out.println("�˻��Ͻ� �ּҴ� �����ϴ�.");
			}

		}
		System.out.println("�˻� ����");
		sc.close();
	}

}
