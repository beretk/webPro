package singleton1;
public class Single {
	private int  i;
	private static Single INSTANCE=new Single();
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}
//	private static Single INSTANCE;
//	private Single() {}
//	public static Single getInstance() {
//		//Single�� ��ü�� ������ �� ������
//		if(INSTANCE==null) {
//			INSTANCE = new Single();
//		}
//		return INSTANCE;
//	}
	public int getI() {
		return i;}
	public void setI(int i) {
		this.i = i;
	}	
}
