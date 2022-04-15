package strategy1.step2;
// Robot�� ��ӹ��� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String ClassName = getClass().getName(); //strategy1.step2.SuperRobot
		int idx = ClassName.lastIndexOf('.'); //�� ������ '.' �� �ִ� ��ġ
		String name = ClassName.substring(idx+1); // idx+1 ��° �۾����� ������
		System.out.println(name +"superRobot�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
}
