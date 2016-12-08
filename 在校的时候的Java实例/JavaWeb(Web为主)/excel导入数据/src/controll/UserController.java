package controll;

import help.HelpConstants;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import db.RoleDao;
import db.UserDao;

import model.AbstractData;
import model.Role;
import model.User;

public class UserController {
	private Role[] roles;
	private User user;
	
	private int addIndex;
	private int deleteIndex;
	private int updateIndex;
	private int existCount;
	private int rowCount;
	
	private JTable dataTable;
	private DefaultTableModel dataModel;
	
	private ArrayList<User> usersList = null;
	private HashMap<Byte,Role> roleMap = new HashMap<Byte, Role>();
	private ArrayList rowlist = new ArrayList();
	public UserController(){	
	}
	
	public JTable setTable(){
		dataTable = new JTable();
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
		//
		Object[][] rowData = null;
		usersList = userDao.getUsers();
		rowCount = existCount = usersList.size();
		if(existCount > 0){
			rowData = new Object[existCount][columnNames.length];
			for(int row = 0;row < existCount;row++){
				User u = usersList.get(row);
				rowData[row][0] = u.getUser_name();
				rowData[row][1] = u.getUser_passwd();
				rowData[row][2] = roleMap.get(new Byte(u.getUser_role()));
				rowData[row][3] = Boolean.FALSE;
				rowData[row][4] = Boolean.FALSE;
				rowData[row][5] = Boolean.FALSE;
			}
		}
		dataModel = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if((Boolean)dataTable.getValueAt(row, updateIndex)){
					return true;
				}
				if(row < existCount){
					if((column == 0 || column == addIndex) && column < deleteIndex){
						return false;
					}
				}
				else if(rowCount > usersList.size()){
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
//									dataTable.setValueAt(Boolean.FALSE, row, updateIndex);
								}
							}else if(column == updateIndex){
								Boolean update = (Boolean)dataTable.getValueAt(row, updateIndex);
								if(update.booleanValue()){
									dataTable.setValueAt(Boolean.FALSE, row, deleteIndex);
//									dataTable.setValueAt(Boolean.FALSE, row, addIndex);
								}
							}
						}
					}
				});
		
		return dataTable;
	}
	
	public JPanel south(){
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,4,10,10));
		JButton addbutton = new JButton("添加行");
		JButton deletebutton = new JButton("删除行");
		JButton savebutton = new JButton("保存");
		JButton exitbutton = new JButton("退出");
		addbutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Object[] rowData = null;
						dataModel.addRow(rowData);
						dataModel.setValueAt(Boolean.TRUE, rowCount, addIndex);
						dataModel.setValueAt(Boolean.FALSE, rowCount, deleteIndex);
						dataModel.setValueAt(Boolean.FALSE, rowCount, updateIndex);
					}
				});
		deletebutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						rowCount = dataModel.getRowCount();
						if(rowCount > usersList.size()){
							dataModel.removeRow(rowCount-1);
						}
						rowCount--;
					}
				});
		savebutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ArrayList<AbstractData> users = new ArrayList<AbstractData>();
						int rows = dataModel.getRowCount();
						for(int row = 0;row < rows;row++){
							Boolean add = (Boolean)dataModel.getValueAt(row, addIndex);
							Boolean delete = (Boolean)dataModel.getValueAt(row, deleteIndex);
							Boolean update = (Boolean)dataModel.getValueAt(row, updateIndex);
							if(add.booleanValue()){
								User user = new User();
								String user_name = (String)dataTable.getValueAt(row, 0);
								String user_passwd = (String)dataTable.getValueAt(row, 1);
								byte user_role = ((Role)dataTable.getValueAt(row, 2)).getRole_id();
								user.setUser_name(user_name);
								user.setUser_passwd(user_passwd);
								user.setUser_role(user_role);
								
								user.setOper_code(HelpConstants.ADD);
								users.add(user);
								dataModel.setValueAt(Boolean.FALSE, row, addIndex);
							}
							if(delete.booleanValue()){
								User user = new User();
								String user_name = (String)dataTable.getValueAt(row, 0);
								String user_passwd = (String)dataTable.getValueAt(row, 1);
								byte user_role = ((Role)dataTable.getValueAt(row, 2)).getRole_id();
								user.setUser_name(user_name);
								user.setUser_passwd(user_passwd);
								user.setUser_role(user_role);
								
								user.setOper_code(HelpConstants.DELETE);
								users.add(user);
								rowlist.add(row);
								dataModel.removeRow(row);
								rowCount--;
							}
							if(update.booleanValue()){
								User user = new User();
								String user_name = (String)dataTable.getValueAt(row, 0);
								String user_passwd = (String)dataTable.getValueAt(row, 1);
								byte user_role = ((Role)dataTable.getValueAt(row, 2)).getRole_id();
								user.setUser_name(user_name);
								user.setUser_passwd(user_passwd);
								user.setUser_role(user_role);
								
								user.setOper_code(HelpConstants.UPDATE);
								users.add(user);
							}
						}
						
						UserDao userDao = new UserDao();
						String str = userDao.editRecords(users);
						for(int i = rowlist.size();i > 0;i--){
							rowlist.remove(i-1);
						}
						rowlist.clear();
						JOptionPane.showMessageDialog(null, str);
					}
				});
		exitbutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
		south.add(addbutton);
		south.add(deletebutton);
		south.add(savebutton);
		south.add(exitbutton);
		return south;
	}
}
