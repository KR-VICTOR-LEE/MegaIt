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
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20Km/1로 교체해 주세요");
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
