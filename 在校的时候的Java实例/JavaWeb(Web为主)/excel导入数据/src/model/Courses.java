package model;

public class Courses extends AbstractData{
	private String course_id;//�γ̴���
	private String course_name;//�γ�����
	private String course_type;//�γ�����
	private String course_nature;//�γ�����
	private int course_xf;//ѧ��
	private String course_startdate;//����ѧ��
	
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Courses(String course_id, String course_name, String course_type,
			String course_nature, int course_xf, String course_startdate) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_type = course_type;
		this.course_nature = course_nature;
		this.course_xf = course_xf;
		this.course_startdate = course_startdate;
	}

	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getCourse_nature() {
		return course_nature;
	}
	public void setCourse_nature(String course_nature) {
		this.course_nature = course_nature;
	}
	public int getCourse_xf() {
		return course_xf;
	}
	public void setCourse_xf(int course_xf) {
		this.course_xf = course_xf;
	}
	public String getCourse_startdate() {
		return course_startdate;
	}
	public void setCourse_startdate(String course_startdate) {
		this.course_startdate = course_startdate;
	}
	
	
}
