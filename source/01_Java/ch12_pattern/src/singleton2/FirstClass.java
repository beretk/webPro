package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass ������ ������ ");
		SingletonClass singletonobject = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i �� : " + singletonobject.getI());
		singletonobject.setI(999);
		System.out.println("�̱��� ��ü�� i ��(������) : " + singletonobject.getI());
		System.out.println("FirstClass ������ ���ೡ--------------------------");
	}
}
