package com.lec.test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		String name, phone, address, answer;
		OutputStream out = null;

		while (true) {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("�̸� : ");
			name = sc.next();
			System.out.println("��ȭ��ȣ : ");
			phone = sc.next();
			System.out.println("�ּ� : ");
			address = sc.next();

			customers.add(new Customer(name, phone, address));
		}
		try {
			out = new FileOutputStream("D:\\webPro\\Source\\01_Java\\Test\\src\\com\\lec\\test2\\customer.txt", true);
			for (Customer c : customers) {
				System.out.println(customers);
				out.write(c.toString().getBytes());
			}
			if (!customers.isEmpty()) {
				System.out.println(customers.size() + "�� ����");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(out!=null)out.close();
			} catch (IOException e) {}
		}
		sc.close();
	}

}
