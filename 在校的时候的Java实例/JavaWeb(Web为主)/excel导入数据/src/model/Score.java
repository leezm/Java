package model;

public class Score extends AbstractData{
	private int score_id;//成绩编号
	private String score_courseId;//课程代号
	private String score_examId;//准考证号码
	private int score_cj;//成绩分数
	private int score_count;//次数
	
	public Score(int score_id, String score_courseId, String score_examId,
			int score_cj, int score_count) {
		super();
		this.score_id = score_id;
		this.score_courseId = score_courseId;
		this.score_examId = score_examId;
		this.score_cj = score_cj;
		this.score_count = score_count;
	}
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public String getScore_courseId() {
		return score_courseId;
	}
	public void setScore_courseId(String score_courseId) {
		this.score_courseId = score_courseId;
	}
	public String getScore_examId() {
		return score_examId;
	}
	public void setScore_examId(String score_examId) {
		this.score_examId = score_examId;
	}
	public int getScore_cj() {
		return score_cj;
	}
	public void setScore_cj(int score_cj) {
		this.score_cj = score_cj;
	}
	public int getScore_count() {
		return score_count;
	}
	public void setScore_count(int score_count) {
		this.score_count = score_count;
	}
	
}
