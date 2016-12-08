package model;

public class Payments extends AbstractData{
	private String examId; //准考证号码
	private boolean pay_first;  //第一学年学费
	private boolean pay_second;//第二学年学费
	private boolean pay_ZLF;  //资料费
	private boolean pay_XWF; //学费申请费
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public boolean isPay_first() {
		return pay_first;
	}
	public void setPay_first(boolean pay_first) {
		this.pay_first = pay_first;
	}
	public boolean isPay_second() {
		return pay_second;
	}
	public void setPay_second(boolean pay_second) {
		this.pay_second = pay_second;
	}
	public boolean isPay_ZLF() {
		return pay_ZLF;
	}
	public void setPay_ZLF(boolean pay_ZLF) {
		this.pay_ZLF = pay_ZLF;
	}
	public boolean isPay_XWF() {
		return pay_XWF;
	}
	public void setPay_XWF(boolean pay_XWF) {
		this.pay_XWF = pay_XWF;
	}
	
}
 