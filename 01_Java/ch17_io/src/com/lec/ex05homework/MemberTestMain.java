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
			System.out.println("회원가입 하시겠습니까 ? (Y/N)");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("이름을 입력하세요 : ");
			String name = sc.next();
			System.out.println("번호를 입력하세요 : ");
			String number = sc.next();
			System.out.println("생년월일을 입력하세요 : ");
			String birth = sc.next();
			Date now = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String today = date.format(now);
			String birthdate = birth.substring(5);
			if (today.equals(birthdate)) {
				System.out.println("생축??");
			}
			System.out.println("주소를 입력하세요 : ");
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
				System.out.println("이상 "+member.size() + " 명 가입");
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
			System.out.println("가입된 회원이 없습니다.");
		}
		sc.close();
	}
}