package model;

public class Contacts extends AbstractData{
	private int contact_id;  //��ϵ��ʽ����
	private String contact_name; //��ϵ��ʽ����	
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contacts(int contactId, String contactName) {
		super();
		contact_id = contactId;
		contact_name = contactName;
	}

	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contactId) {
		contact_id = contactId;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contactName) {
		contact_name = contactName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.contact_name;
	}
	
	
}
