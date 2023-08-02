package com.lec.ex4_object;

public class Point3D {
	private double x,y,z;
	public Point3D() {}
	public Point3D(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;		
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null && getClass() == obj.getClass()) {
			Point3D other = (Point3D)obj;
			return x==other.x && y==other.y && z==other.z;
		}
		return false;
		
	}
	@Override
	public String toString() {
		return "謝ル高[ " + x + "高," + y + "高," + z + "高]";
	}
}	
