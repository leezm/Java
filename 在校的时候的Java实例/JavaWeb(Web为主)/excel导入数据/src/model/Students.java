package model;

import java.sql.Date;

public class Students extends AbstractData{
	private String examId;//׼��֤��
	private String stu_name;//����
	private boolean stu_sex; //�Ա�
	private String stu_birthId; //���֤��
	private Date stu_birthdate;//��������
	private String stu_classname;//�༶����
	private String stu_majorId;//רҵ����
	private String stu_majorname;//רҵ����
	private String stu_learnyear;//ѧ��
	private String stu_grade; //�꼶
	private Date stu_DZBY;//ȡ�ô�ר֤��ʱ��
	private String stu_nation;//����
	private String stu_politics;//������ò
	private String stu_HuKou;//����
	private String stu_JG;//����
	private String stu_type; //ѧ������
	private String stu_state; //״̬
	
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	public boolean isStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(boolean stuSex) {
		stu_sex = stuSex;
	}
	public String getStu_birthId() {
		return stu_birthId;
	}
	public void setStu_birthId(String stuBirthId) {
		stu_birthId = stuBirthId;
	}
	public Date getStu_birthdate() {
		return stu_birthdate;
	}
	public void setStu_birthdate(Date stuBirthdate) {
		stu_birthdate = stuBirthdate;
	}
	public String getStu_classname() {
		return stu_classname;
	}
	public void setStu_classname(String stuClassname) {
		stu_classname = stuClassname;
	}
	public String getStu_majorId() {
		return stu_majorId;
	}
	public void setStu_majorId(String stuMajorId) {
		stu_majorId = stuMajorId;
	}
	public String getStu_majorname() {
		return stu_majorname;
	}
	public void setStu_majorname(String stuMajorname) {
		stu_majorname = stuMajorname;
	}
	public String getStu_learnyear() {
		return stu_learnyear;
	}
	public void setStu_learnyear(String stuLearnyear) {
		stu_learnyear = stuLearnyear;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stuGrade) {
		stu_grade = stuGrade;
	}
	public Date getStu_DZBY() {
		return stu_DZBY;
	}
	public void setStu_DZBY(Date stuDZBY) {
		stu_DZBY = stuDZBY;
	}
	public String getStu_nation() {
		return stu_nation;
	}
	public void setStu_nation(String stuNation) {
		stu_nation = stuNation;
	}
	public String getStu_politics() {
		return stu_politics;
	}
	public void setStu_politics(String stuPolitics) {
		stu_politics = stuPolitics;
	}
	public String getStu_HuKou() {
		return stu_HuKou;
	}
	public void setStu_HuKou(String stuHuKou) {
		stu_HuKou = stuHuKou;
	}
	public String getStu_JG() {
		return stu_JG;
	}
	public void setStu_JG(String stuJG) {
		stu_JG = stuJG;
	}
	public String getStu_type() {
		return stu_type;
	}
	public void setStu_type(String stuType) {
		stu_type = stuType;
	}
	public String getStu_state() {
		return stu_state;
	}
	public void setStu_state(String stuState) {
		stu_state = stuState;
	}
	
	
	
}
