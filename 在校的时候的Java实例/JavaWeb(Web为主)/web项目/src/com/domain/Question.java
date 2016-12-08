package com.domain;

public class Question extends AbstractData {
	private byte question_id;
	private String question_name;
	private String question_answer;
	public byte getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(byte question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}
	
}
