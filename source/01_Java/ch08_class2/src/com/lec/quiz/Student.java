package com.lec.quiz;


public class Student {
	private static int count=1;
	private int no;
	private String name;
	private int    kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private int    avg;
	public Student() {}
	public Student(String name, int kor, int eng, int mat, int count) {
	}
	public Student(int no, String name, int kor, int eng, int mat, int tot, int avg) {
		no = count++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3;
		avg = (int)(tot/3.0+0.5);
	}
	public String infoString() {
		return no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg;
	}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMat() {return mat;}
	public int getTot() {return tot;}
	public int getAvg() {return avg;}
}
