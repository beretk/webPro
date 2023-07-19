package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 积己磊 角青吝 ");
		SingletonClass singletonobject = SingletonClass.getInstance();
		System.out.println("教臂沛 按眉狼 i 蔼 : " + singletonobject.getI());
		singletonobject.setI(999);
		System.out.println("教臂沛 按眉狼 i 蔼(荐沥饶) : " + singletonobject.getI());
		System.out.println("FirstClass 积己磊 角青场--------------------------");
	}
}
