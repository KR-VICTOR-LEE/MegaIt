package com.lec.ex03readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {

	public static void main(String[] args) {
		Reader reader = null;

		try {
			reader = new FileReader("test_File/test.txt"); // 1. ���Ͽ���
			while (true) { // 2. �����͸� �д´�
				int i = reader.read();
				if (i == -1)
					break;
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}
	}

}
