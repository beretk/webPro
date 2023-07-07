package com.lec.quiz;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;

import com.lec.ex1_student.Student;
public class StudenMain {
		public static void main(String[] args) {
			Student[] students = {new Student("���켺", 90, 80, 95),
								  new Student("���ϴ�", 100, 80, 95),
								  new Student("Ȳ����", 95, 80, 90),
								  new Student("������", 95, 90, 99),
								  new Student("������", 90, 90, 90)};
			int[] total = new int[5];
			int[] averge = new int[total.length];
			line('��');
			System.out.println("\t\t\t�� �� ǥ");
			line('-');
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
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
				averge[idx] = total[idx]/students.length; // ����(86.6�� 86)
				averge[idx] = (int)((double)total[idx]/students.length+0.5); // �ݿø�(86.6�� 87����)
			}
			System.out.print("\t����"+"\t");
			for(int t : total) {
				System.out.printf("%3d\t",t);
			}
			System.out.println();
			System.out.print("\t���"+"\t");
			for(int a : averge) {
				System.out.printf("%3d\t",a);
			}
			System.out.println();
			line('��');
		}
		private static void line(char c) {
			for(int cnt=0 ; cnt <55 ; cnt++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
