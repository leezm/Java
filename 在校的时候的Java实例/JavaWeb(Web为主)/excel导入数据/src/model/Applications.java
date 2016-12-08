package model;

import java.sql.Date;

import db.AbstractDao;

public class Applications extends AbstractData{
	private String name; //姓名
	private boolean sex; //性别
	private String learnyear;//学制
	private String id; //身份证号码
	private Date birthdate;//出生日期
	private byte nation;//民族
	private byte politics;//政治面貌
	private String HuKou;//户口
	private String JG;//籍贯
	private byte contactWay;// 联系方式
	private String grade;// 年级
	private Date DZBY; //取得大专证书日期
	private boolean BMQR;//报名确认
	public Applications() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Applications(String name, boolean sex, String learnyear, String id,
			Date birthdate, byte nation, byte politics, String huKou,
			String jG, byte contactWay, String grade, Date dZBY, boolean bMQR) {
		super();
		this.name = name;
		this.sex = sex;
		this.learnyear = learnyear;
		this.id = id;
		this.birthdate = birthdate;
		this.nation = nation;
		this.politics = politics;
		HuKou = huKou;
		JG = jG;
		this.contactWay = contactWay;
		this.grade = grade;
		DZBY = dZBY;
		BMQR = bMQR;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getLearnyear() {
		return learnyear;
	}
	public void setLearnyear(String learnyear) {
		this.learnyear = learnyear;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public byte getNation() {
		return nation;
	}
	public void setNation(byte nation) {
		this.nation = nation;
	}
	public byte getPolitics() {
		return politics;
	}
	public void setPolitics(byte politics) {
		this.politics = politics;
	}
	public String getHuKou() {
		return HuKou;
	}
	public void setHuKou(String huKou) {
		HuKou = huKou;
	}
	public String getJG() {
		return JG;
	}
	public void setJG(String jG) {
		JG = jG;
	}
	public byte getContactWay() {
		return contactWay;
	}
	public void setContactWay(byte contactWay) {
		this.contactWay = contactWay;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDZBY() {
		return DZBY;
	}
	public void setDZBY(Date dZBY) {
		DZBY = dZBY;
	}
	public boolean isBMQR() {
		return BMQR;
	}
	public void setBMQR(boolean bMQR) {
		BMQR = bMQR;
	}
	
	
}
