package com.lec.ex05homework;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemberTestMain {
	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		OutputStream out = null;

		while (true) {
			System.out.println("ȸ������ �Ͻðڽ��ϱ� ? (Y/N)");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("�̸��� �Է��ϼ��� : ");
			String name = sc.next();
			System.out.println("��ȣ�� �Է��ϼ��� : ");
			String number = sc.next();
			System.out.println("��������� �Է��ϼ��� : ");
			String birth = sc.next();
			Date now = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String today = date.format(now);
			String birthdate = birth.substring(5);
			if (today.equals(birthdate)) {
				System.out.println("����??");
			}
			System.out.println("�ּҸ� �Է��ϼ��� : ");
			sc.nextLine();
			String address = sc.nextLine();
			member.add(new Member(name, number, birth, address));
		}
		try {
			out = new FileOutputStream("src/com/lec/ex05homework/member.txt", true);
			for (Member m : member) {
				System.out.println(m);
				out.write(m.toString().getBytes());
			}
			if (!member.isEmpty()) {
				System.out.println("�̻� "+member.size() + " �� ����");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
				}
			}
		}
		if (member.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		sc.close();
	}
}