<<<<<<< HEAD
=======
<<<<<<< HEAD
package com.lec.ex;
public class VarEx04 {
	public static void main(String[] args) {
		int i = 40; // 4byte
		long l = 2200000000L; // 8byte
		System.out.println("l = " + l);
		boolean b = true; // 1byte (true/false)
		System.out.println("b = " + b);
		// �Ǽ��� double�� �⺻. �Ǽ��� double�� ����
		float f = 3.1415926539F; // 4byte
		double d = 3.1415926539; // 8byte
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f�� d�� ����");
		}else {
			System.out.println("f�� d�� �ٸ���");
		}
		f = 10.1f;
		d = 10.1;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if(f == d) {
			System.out.println("f�� d�� ����");
		}else {
			System.out.println("f�� d�� �ٸ���");
		}
		double result = d + 1; // 8byte + 4byte => 8byte
		System.out.println("d+1 = " + result);
		i = 3;
		// i(3; 4byte) / 2(4byte) => 4byte ; ��
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 = " + ((double)i/2));
		System.out.println("i/2.0 = " + i/2.0);
	}
}

=======
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
package com.lec.ex;
public class VarEx04 {
	public static void main(String[] args) {
		int i =40; //4byte
		long l =2200000000L; //8byte
<<<<<<< HEAD
		System.out.println("l =" +l);
=======
		System.out.println("1 =" +1);
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
		boolean b = true; // 1byte(true/false)
		System.out.println("b =" +b);
		// �Ǽ��� double�� �⺻
		float f = 3.1415926593F; //4byte
		double d = 3.1415926593; //8byte
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f��d�� ����");
		}else {
			System.out.println("f�� d�� �ٸ���");
		}
		f = 10.1f;
		d = 10.1;
		if (f == d) {
			System.out.println("f��d�� ����");
		}else {
			System.out.println("f�� d�� �ٸ���");
		}
<<<<<<< HEAD
		double result = d + 1; // 8byte + 4byte => 8byte
		System.out.println("d+1 = " + result);
		i = 3;
		// i(3; 4byte) / 2(4byte) => 4byte ; ��
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 = " + ((double)i/2));
		System.out.println("i/2.0 = " + i/2.0);	
			
//		double result = d + 1; //8byte + 4byte => 8byte
//		System.out.println("d+1 =" + result);
//		i = 3;
//		//i(3; 4byte) /2(4byte) => 4byte ; ��
//		System.out.println("i/2 = " + (i/2));
//		System.out.println("(double)i/2 = " + ((double)i/2));
//		System.out.println("i/2.0 =" + i/2.0);
	}
}
=======
			
			
		double result = d + 1; //8byte + 4byte => 8byte
		System.out.println("d+1 =" + result);
		i = 3;
		//i(3; 4byte) /2(4byte) => 4byte ; ��
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 = " + ((double)i/2));
		System.out.println("i/2.0 =" + i/2.0);
	}
}
>>>>>>> b12dce29af3ea512a62c8845153f9cc04d555bf9
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
