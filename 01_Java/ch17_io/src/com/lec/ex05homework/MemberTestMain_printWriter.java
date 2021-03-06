package com.lec.ex05homework;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MemberTestMain_printWriter {

	public static void main(String[] args) {
		InputStream input = null;
		DataInputStream dinput = null;

		try {
			input = new FileInputStream("src/com/lec/ex05homework/member.txt");
			dinput = new DataInputStream(input);
			while (true) {
				String name = dinput.readUTF();
				String number = dinput.readUTF();
				String birth = dinput.readUTF();
				String address = dinput.readUTF();

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("회원 리스트는 아래와 같습니다.");
		} finally {
			try {
				if (dinput != null)
					dinput.close();
				if (input != null)
					input.close();
			} catch (IOException e) {
			}
		}

	}

}
