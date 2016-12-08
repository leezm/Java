package com.domain;

public class Teacher extends AbstractData {
	private String teacher_id;
	private String teacher_name;
	private String teacher_group;
	private byte teacher_grade;
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_group() {
		return teacher_group;
	}
	public void setTeacher_group(String teacher_group) {
		this.teacher_group = teacher_group;
	}
	public byte getTeacher_grade() {
		return teacher_grade;
	}
	public void setTeacher_grade(byte teacher_grade) {
		this.teacher_grade = teacher_grade;
	}

	
}
