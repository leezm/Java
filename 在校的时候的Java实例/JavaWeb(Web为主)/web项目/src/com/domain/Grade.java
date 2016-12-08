package com.domain;

public class Grade extends AbstractData {
	private byte teacher_grade;
	private String grade_name;
	public byte getTeacher_grade() {
		return teacher_grade;
	}
	public void setTeacher_grade(byte teacher_grade) {
		this.teacher_grade = teacher_grade;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	
}
