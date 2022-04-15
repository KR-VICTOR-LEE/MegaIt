package com.lec.ex01_inputstreamoutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1)������ ���� (��¿뽺Ʈ����ü����) 
// (2)write�Ѵ� 
// (3)�������ݴ´�(��Ʈ����ü.close)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("test_File/outTest.txt"); // (1)
			String str = "Hello , Java\n �ѱ� �԰���";
			byte[] bs = str.getBytes(); // ��Ʈ���� byte�迭�� �ٲٴ� �Լ�
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (3)
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
