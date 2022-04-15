package singleton1;

public class TestMain {

	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		obj1.setI(99);
		System.out.println("obj1의 i : "+ obj1.getI());
		System.out.println("obj2의 i : "+ obj2.getI());
		obj2.setI(10);
		System.out.println("obj1의 i : "+ obj1.getI());
		System.out.println("obj2의 i : "+ obj2.getI());
		


	}

}
