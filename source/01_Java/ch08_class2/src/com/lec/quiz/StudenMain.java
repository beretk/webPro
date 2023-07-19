package com.lec.quiz;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;

import com.lec.ex1_student.Student;
public class StudenMain {
		public static void main(String[] args) {
			Student[] students = {new Student("정우성", 90, 80, 95),
								  new Student("김하늘", 100, 80, 95),
								  new Student("황정민", 95, 80, 90),
								  new Student("강동원", 95, 90, 99),
								  new Student("마동석", 90, 90, 90)};
			int[] total = new int[5];
			int[] averge = new int[total.length];
			line('■');
			System.out.println("\t\t\t성 적 표");
			line('-');
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			line('-');
			for(Student student : students) {
				System.out.println(student.infoString());
				total[0] += student.getKor();
				total[1] += student.getEng();
				total[2] += student.getMat();
				total[3] += student.getTot();
				total[4] += student.getAvg();
			}
			line('-');
			for(int idx=0 ; idx<averge.length ; idx++) {
				averge[idx] = total[idx]/students.length; // 버림(86.6은 86)
				averge[idx] = (int)((double)total[idx]/students.length+0.5); // 반올림(86.6은 87으로)
			}
			System.out.print("\t총점"+"\t");
			for(int t : total) {
				System.out.printf("%3d\t",t);
			}
			System.out.println();
			System.out.print("\t평균"+"\t");
			for(int a : averge) {
				System.out.printf("%3d\t",a);
			}
			System.out.println();
			line('■');
		}
		private static void line(char c) {
			for(int cnt=0 ; cnt <55 ; cnt++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
