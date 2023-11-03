package com.lec.ch04.ex1_auto;

import org.springframework.beans.factory.annotation.Autowired;
// 의존객체의 자동주입 : setter주입, 생성자주입(제일안전하다), 필드주입(간편)
public class StudentInfo {
	@Autowired // 필드주입
	private Student student;
//	@Autowired
//	public StudentInfo(Student student) { // 생성자주입
//		this.student = student;
//	}
//  @Autowired 
//	public void setStudent(Student student) { // setter 주입
//		this.student = student;
//	}
	public Student getStudent() {
		return student;
	}

	
}
