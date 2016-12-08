package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import db.RoleDao;
import db.UserDao;

import model.Role;
import model.User;

public class MainFrame extends JFrame {

	private Role[] roles;
	private User user;
	private int addIndex;
	private int deleteIndex;
	private int updateIndex;
	private int existCount;
	private int rowCount;
	private HashMap<Byte,Role> roleMap = new HashMap<Byte, Role>();
	
	public MainFrame(User user){
		this.user = user;
		//表
		final JTable dataTable = new JTable();
		dataTable.setRowHeight(30);
		JTableHeader tableHeader = dataTable.getTableHeader();
		tableHeader.setFont(new Font("黑体",Font.BOLD,25));
		//
		UserDao userDao = new UserDao();
		String[] names = userDao.getColumnNames("select user_name as 姓名,user_passwd as 密码,user_role as 角色 from users");
		addIndex = names.length;
		deleteIndex = names.length + 1;
		updateIndex = names.length + 2;
		String[] columnNames = userDao.ColumnNames(names);
		//
		RoleDao roleDao = new RoleDao();
		roles = roleDao.getAll();
		for(int i = 0;i < roles.length;i++){
			roleMap.put(new Byte(roles[i].getRole_id()), roles[i]);
		}
		Object[][] rowData = null;
		final ArrayList<User> users = userDao.getUsers();
		rowCount = existCount = users.size();
		if(existCount > 0){
			rowData = new Object[existCount][columnNames.length];
			for(int row = 0;row < existCount;row++){
				User u = users.get(row);
				rowData[row][0] = u.getUser_name();
				rowData[row][1] = u.getUser_passwd();
				rowData[row][2] = roleMap.get(new Byte(u.getUser_role()));
				rowData[row][3] = Boolean.FALSE;
				rowData[row][4] = Boolean.FALSE;
				rowData[row][5] = Boolean.FALSE;
			}
		}
		DefaultTableModel dataModel = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
//				if((Boolean)dataTable.getValueAt(row, updateIndex)){
//					return true;
//				}
				if(row < existCount){
					if((column == 0 || column == addIndex) && column < deleteIndex){
						return false;
					}
				}
				else if(rowCount > users.size()){
					return true;
				}
				return super.isCellEditable(row, column);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				if(columnIndex == addIndex || columnIndex == deleteIndex || columnIndex == updateIndex){
					return Boolean.class;
				}
				return super.getColumnClass(columnIndex);
			}
			
		};
		dataModel.setDataVector(rowData, columnNames);
		dataTable.setModel(dataModel);
		
		JComboBox rolebox = new JComboBox(roles);
		DefaultCellEditor cellEditor = new DefaultCellEditor(rolebox);
		TableColumn roleColumn = dataTable.getColumnModel().getColumn(2);
		roleColumn.setCellEditor(cellEditor);
		
		TableColumn addColumn = dataTable.getColumnModel().getColumn(3);
		addColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
		TableColumn deleteColumn = dataTable.getColumnModel().getColumn(4);
		deleteColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
		TableColumn updateColumn = dataTable.getColumnModel().getColumn(5);
		updateColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		dataTable.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						int row = dataTable.rowAtPoint(e.getPoint());
						int column = dataTable.columnAtPoint(e.getPoint());
						if(column == addIndex || column == deleteIndex || column == updateIndex){
							Boolean add = (Boolean)dataTable.getValueAt(row, addIndex);
							if(add.booleanValue()){
								dataTable.setValueAt(Boolean.FALSE, row, deleteIndex);
								dataTable.setValueAt(Boolean.FALSE, row, updateIndex);
							}else if(column == deleteIndex){
								Boolean delete = (Boolean)dataTable.getValueAt(row, deleteIndex);
								if(delete.booleanValue()){
									dataTable.setValueAt(Boolean.FALSE, row, addIndex);
									dataTable.setValueAt(Boolean.FALSE, row, updateIndex);
								}
							}else if(column == updateIndex){
								Boolean update = (Boolean)dataTable.getValueAt(row, updateIndex);
								if(update.booleanValue()){
									dataTable.setValueAt(Boolean.FALSE, row, deleteIndex);
									dataTable.setValueAt(Boolean.FALSE, row, addIndex);
								}
							}
						}
					}
				});
		
		this.setSize(600, 600);
		this.getContentPane().add(new JScrollPane(dataTable));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(260, 50);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame(null);
	}

}
