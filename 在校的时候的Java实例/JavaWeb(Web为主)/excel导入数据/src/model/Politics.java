package model;

public class Politics extends AbstractData {
	private byte politics_id;//政治面貌编号
	private String politics_name;//政治面貌名称
	public Politics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Politics(byte politics_id, String politics_name) {
		super();
		this.politics_id = politics_id;
		this.politics_name = politics_name;
	}
	public byte getPolitics_id() {
		return politics_id;
	}
	public void setPolitics_id(byte politics_id) {
		this.politics_id = politics_id;
	}
	public String getPolitics_name() {
		return politics_name;
	}
	public void setPolitics_name(String politics_name) {
		this.politics_name = politics_name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.politics_name;
	}
	
}
