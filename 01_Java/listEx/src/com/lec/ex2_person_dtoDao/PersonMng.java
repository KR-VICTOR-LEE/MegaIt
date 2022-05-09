package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.println("1 : �Է� || 2 : ��������ȸ || 3 : ��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch(fn){
				case "1":
					System.out.println("�Է��� �̸�?");
					String pname = sc.next();
					System.out.println("����(���|����) ��?");
					String jname = sc.next();
					System.out.println("���������� ? ");
					int kor = sc.nextInt();
					System.out.println("���������� ?");
					int eng = sc.nextInt();
					System.out.println("���������� ?");
					int mat = sc.nextInt();
					int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
					System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
					break;
				case "2":
					System.out.print("��ȸ�� ���� ?");
					jname = sc.next();
					dtos = dao.selelctJname(jname);
					if(dtos.isEmpty()) {
						System.out.println("�ش� ������ ����� �����ϴ�.");
					}else {
						System.out.println("rank\t�̸�\t������\t����\t����\t����\t�հ�");
						for(PersonDto d : dtos) {
							System.out.println(d);
						}//for
					}//if
					break;
				case "3":
					dtos = dao.selectAll();
					if(dtos.size()!=0) {
						System.out.println("rank\t�̸�\t������\t����\t����\t����\t�հ�");
						for(PersonDto d : dtos) {
							System.out.println(d);
						}//for
					}else {
						System.out.println("��ϵ� ����� �����ϴ�");
					}
				}//switch
			}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
			sc.close();
			System.out.println("BYE");
	}

}