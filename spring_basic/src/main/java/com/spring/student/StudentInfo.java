package com.spring.student;

public class StudentInfo {
	private Student student;
	
	public StudentInfo(Student student) {
		this.student=student;
	}
	
	public void StudentInfo(Student student) {
		this.student=student;
	}
	
	public void getInfo(){ 
		System.out.println("�̸� : "+student.getName());
		System.out.println("���� : "+student.getAge());
		System.out.println("�г� : "+student.getGradeName());
		System.out.println("�� : "+student.getClassNum());
	}
}