package com.lec.ex_list;

import java.util.ArrayList;

public class Ex01_ArrayLists {
	public static void main(String[] args) {
		String[] array = new String[4];
		array[0] = "str0"; array[1] = "str1"; array[2] = "str2"; array[3] = "str3";
		for(int i=0; i<array.length; i++) {
			System.out.printf("array[%d] = %s\t", i,array[i]);
		}
		System.out.println(); // ����
		for(String arr : array) {
			System.out.printf(arr + "\t");
		}
		System.out.println("\n~~~~~~~ ArrayList ~~~~~~~~");
		ArrayList<String> arrayList = new ArrayList<String>();
		//ArrayList Ÿ���� ��ü������ Ÿ�Ը� ����. 
		arrayList.add("str0"); // 0 �� �ε��� 
		arrayList.add("str1"); // 1 �� �ε��� -> 2�� �ε���
		arrayList.add("str2"); // 3�� �ε���  -> 3�� �ε���
		System.out.println(arrayList);
		arrayList.add(1, "str11"); // 1�� �ε���
		System.out.println(arrayList);
		arrayList.set(1, "11111"); // 1�� �ε��� ����
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� - ");
		arrayList.remove(1); // 1��° �ε����� ������ ��������(2->1�� �ε���, 3->2�� �ε���)
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ������ ����
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t",idx, arrayList.get(idx));
		}
		System.out.println(); // ����
		arrayList.clear(); // arrayList�� ��� ������ ����
		if (arrayList.size()==0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		if (arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		System.out.println(arrayList);
		arrayList = null; //arrayList ��ü�� ����
		System.out.println();
	}
}
