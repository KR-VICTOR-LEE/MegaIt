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
			System.out.println("회원가입 하시겠습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("이름 : ");
			name = sc.next();
			System.out.println("전화번호 : ");
			phone = sc.next();
			System.out.println("주소 : ");
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
				System.out.println(customers.size() + "명 가입");
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
