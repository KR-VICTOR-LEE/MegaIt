package strategy1.step2;

public class LowRobot extends Robot{
	public void action() {
		System.out.println("날수없음");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없음.");
	}
	public void actionKnife() {
		System.out.println("레이져 검이 없음.");
	}
}
