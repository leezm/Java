package model;

public class Student_contact extends AbstractData{
	private int stu_contactId;//ѧ����ϵ��ʽ����
	private String stu_contactvalue;//ѧ����ϵ��ʽ����
	private int contact_id;//��ϵ��ʽ����
	private String examId;//׼��֤��
	
	
	public Student_contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student_contact(int stu_contactId, String stu_contactvalue,
			int contact_id, String examId) {
		super();
		this.stu_contactId = stu_contactId;
		this.stu_contactvalue = stu_contactvalue;
		this.contact_id = contact_id;
		this.examId = examId;
	}

	public int getStu_contactId() {
		return stu_contactId;
	}
	public void setStu_contactId(int stu_contactId) {
		this.stu_contactId = stu_contactId;
	}
	public String getStu_contactvalue() {
		return stu_contactvalue;
	}
	public void setStu_contactvalue(String stu_contactvalue) {
		this.stu_contactvalue = stu_contactvalue;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getExamId() {
		return examId;
	}
	public synchronized void setExamId(String examId) {
		this.examId = examId;
	}
	
	
}
