package com.lec.ex1_string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// String�� new �� �������� �ʰ� "  "�� ����� ���ڿ� ����� �̿�. �ڵ����� �� ������ String ��ü�� �̹� �����ϴ��� Ȯ���ϰ�
		// �̹� �����ϴ� ���ڿ� ��ü�� ����, �������� ������ String ��ü ����
		int i = 10;
		String str1 = "Java";
		String str2 = "java";
		String str3 = new String("java"); // ������ ����
		if(str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}
		
		if (str1.equals(str2)) {
			System.out.println("�������ڿ�");
		}
		System.out.println(str1==str3 ? "str1�� 3�� ���� �ּ� " : "str1�� 3�� �ٸ��ּ�");
		System.out.println(str1.equals(str3)? "���� ��Ʈ��" : "�ٸ� ���ڿ�");
		
		
	}

}
