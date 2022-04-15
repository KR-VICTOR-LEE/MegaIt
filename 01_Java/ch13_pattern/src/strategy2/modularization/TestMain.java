package strategy2.modularization;

import strategy2.interfaces.*;

public class TestMain {

	public static void main(String[] args) {
		Car Genesis = new Genesis();
		Car Sonata = new Sonata();
		Car Accent = new Accent();
		
		Car[] cars = {Genesis, Sonata, Accent};
		
		for(Car car : cars) {
			car.shape();
			car.drive();
			car.engine();
			car.km();
			car.feul();
			System.out.println("=======================");
		}
		System.out.println("�ҳ�Ÿ�� ���̺긮��� ��ü�ϰ� ���� 20Km/1�� ��ü�� �ּ���");
		Sonata.setFeul(new FuelHybride());
		Sonata.setKm(new Km20());
		for(int i=0; i<cars.length; i++) {
			cars[i].shape();
			cars[i].drive();
			cars[i].engine();
			cars[i].km();
			cars[i].feul();
			System.out.println("=======================");
		}
	}

}
