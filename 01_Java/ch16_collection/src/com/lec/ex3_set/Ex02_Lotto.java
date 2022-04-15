package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;

public class Ex02_Lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random rd = new Random();
		int cnt = 0;
		while(lotto.size()<6) {
			cnt++;
			lotto.add(rd.nextInt(45)+1);
		}
		System.out.println(cnt+"번 숫자 뽑아 나온 로또 수 : " + lotto);
	}
}
