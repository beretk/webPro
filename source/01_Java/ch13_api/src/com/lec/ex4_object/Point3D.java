package com.lec.ex4_object;

public class Point3D {
	private double x,y,z;
	public Point3D() {}
	public Point3D(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;		
	}
<<<<<<< HEAD
=======

>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && getClass() == obj.getClass()) {
			Point3D other = (Point3D)obj;
			return x==other.x && y==other.y && z==other.z;
		}
<<<<<<< HEAD
		return false;		
=======
		return false;
		
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
	}
	@Override
	public String toString() {
		return "謝ル高[ " + x + "高," + y + "高," + z + "高]";
	}
}	
