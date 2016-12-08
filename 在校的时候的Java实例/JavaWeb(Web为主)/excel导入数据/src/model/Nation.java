package model;

public class Nation extends AbstractData {
	private byte nation_id;//民族编号
	private String nation_name;//民族名称
	public Nation(byte nation_id, String nation_name) {
		super();
		this.nation_id = nation_id;
		this.nation_name = nation_name;
	}
	public Nation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public byte getNation_id() {
		return nation_id;
	}
	public void setNation_id(byte nation_id) {
		this.nation_id = nation_id;
	}
	public String getNation_name() {
		return nation_name;
	}
	public void setNation_name(String nation_name) {
		this.nation_name = nation_name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nation_name;
	}
	
}
