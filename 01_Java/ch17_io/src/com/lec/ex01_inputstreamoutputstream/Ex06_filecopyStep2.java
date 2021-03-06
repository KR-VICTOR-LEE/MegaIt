package com.lec.ex01_inputstreamoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// (1) 스트림객체 (입력용, 출력용) (2)읽고 쓴다 (3) 파일닫는다(스트림객체.close)
public class Ex06_filecopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\webPro\\kk.PNG"); // (1)
			os = new FileOutputStream("d:/webPro/kk_copy.PNG");
			int cnt = 0;
			byte[] bs = new byte[1024]; // 1024 byte 설정
			while (true) { // (2)
				int readByteCount = is.read(); // 1024byte읽기
				if (readByteCount == -1)
					break; // 파일의 끝인지 여부
				os.write(bs, 0, readByteCount); // bs를 0번 index부터 readByteCount만큼 쓴다.
				cnt++;
			}
			System.out.println(cnt + "번 while문 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
				if (is!=null)
					is.close();
			} catch (IOException e) {

			}
		}
	}
}
