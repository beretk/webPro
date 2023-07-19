package com.lec.ex03_point.copy;
// x, y /  infoPrint(좌표 x,y)
//point3D p = new Point3D(1,2,3);
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		System.out.println("매개변수 있는 point3D생성자 - x,y,z 초기화");
//		setX(x); //this.x = x; protected만 가능
//		setY(y);
		this.z = z;
	}
	@Override
	public void infoPrint() {
		System.out.println("좌표값(x,y,z) : " + getX() + "," + getY() + ","+ z);
	}
//	public void infoPrint3d() {
//		System.out.println("좌표값(x,y,z) : " + getX() + "," + getY() + ","+ z);
//	}
}
