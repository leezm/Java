package com.domain;



public class ExamTeacher extends AbstractData {
	String examroom_id;
	String teacher_id;
	String date;
	public String getExamroom_id() {
		return examroom_id;
	}
	public void setExamroom_id(String examroom_id) {
		this.examroom_id = examroom_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
