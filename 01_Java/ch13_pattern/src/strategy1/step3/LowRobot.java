package strategy1.step3;

public class LowRobot extends Robot{
	@Override
	public void actionFly() {
		System.out.println("날수없음");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없음.");
	}
	@Override
	public void actionKninfe() {
		System.out.println("레이져 검이 없음.");
	}
}
