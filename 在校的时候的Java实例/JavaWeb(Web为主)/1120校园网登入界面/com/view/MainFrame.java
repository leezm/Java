package wang.com.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import wang.com.db.RoleDAO;
import wang.com.db.UserDAO;
import wang.com.helper.StudentScoreConstants;
import wang.com.model.Role;
import wang.com.model.User;

public class MainFrame extends JFrame {
	private Role[] roles;
	private User user;
	private int addIndex;
	private int deleteIndex;
	private int updateIndex;
	private int existCount;
	private int rowCount;
	
	private HashMap<Byte, Role> rolesMap = new HashMap<Byte, Role>();
	public MainFrame(User user){		
		this.user = user;
		final JTable dataTable = new JTable();
		UserDAO userDao = new UserDAO();
		String[] names = userDao.getColumnNames();
		addIndex = names.length;
		deleteIndex = addIndex + 1;
		updateIndex = deleteIndex + 1;
		
		String[] columnNames = getColumnNames(names);
		
		RoleDAO roleDao = new RoleDAO();
		roles = roleDao.getAll();
		
		for(int i = 0; i < roles.length; i++){
			rolesMap.put(new Byte(roles[i].getRole_id()), roles[i]);
		}
		final DefaultTableModel dataModel = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column == addIndex || column == 0 && row < existCount || row < existCount && column < deleteIndex){
					return false;
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
		Object[][] rowData = null;
		
		ArrayList<User> users = userDao.getUsers();
		rowCount = existCount = users.size();
		if(existCount > 0){
			rowData = new Object[existCount][columnNames.length];
			for(int row = 0; row < existCount; row++){
				User u = users.get(row);
				rowData[row][0] = u.getUser_name();
				rowData[row][1] = u.getUser_password();
				rowData[row][2] = rolesMap.get(new Byte(u.getUser_role()));
				rowData[row][3] = Boolean.FALSE;
				rowData[row][4] = Boolean.FALSE;
				rowData[row][5] = Boolean.FALSE;
			}
		}
		
		dataModel.setDataVector(rowData, columnNames);
		
		//
		dataTable.setModel(dataModel);
		dataTable.setRowHeight(30);
		JTableHeader tableHeader = dataTable.getTableHeader();
		tableHeader.setFont(new Font("宋体", Font.PLAIN, 20));
		//!!!!!!
		
		
		JComboBox roleBox = new JComboBox(roles);
		DefaultCellEditor cellEditor = new DefaultCellEditor(roleBox);
		
		TableColumn roleColumn = dataTable.getColumnModel().getColumn(2);
		roleColumn.setCellEditor(cellEditor);
		
		//12.1
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
								dataTable.setValueAt(Boolean.FALSE, row, updateIndex);
							}
						}else if(column == updateIndex){
							Boolean update = (Boolean)dataTable.getValueAt(row, updateIndex);
							if(update.booleanValue()){
								dataTable.setValueAt(Boolean.FALSE, row, deleteIndex);
							}
						}
					}
					
				}
			});
		
		     
		JButton addButton = new JButton("添加一行");
		JButton deleteButton = new JButton("删除一行");
		JButton saveButton = new JButton("保存");
		JButton exitButton = new JButton("退出");
		
		addButton.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Object[] rowData = null;
					dataModel.addRow(rowData);
					dataModel.setValueAt(Boolean.TRUE, rowCount, addIndex);
					dataModel.setValueAt(Boolean.FALSE, rowCount, deleteIndex);
					dataModel.setValueAt(Boolean.FALSE, rowCount, updateIndex);
					rowCount++;
				}
				
			});
		deleteButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		saveButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						ArrayList<User> users = new ArrayList<User>();
						int rows = dataTable.getRowCount();
						for(int row = 0; row < rowCount; row++){
							byte operCode = -1;
							if(((Boolean)dataTable.getValueAt(row, addIndex)).booleanValue()){
								operCode = StudentScoreConstants.ADD;
							}else if(((Boolean)dataTable.getValueAt(row, deleteIndex)).booleanValue()){
								operCode = StudentScoreConstants.DELETE;
							}else if(((Boolean)dataTable.getValueAt(row, updateIndex)).booleanValue()){
								operCode = StudentScoreConstants.UPDATE;
							}
							if(operCode != -1){	
							User user = new User();
							String user_name = (String)dataTable.getValueAt(row, 0);
							String user_password = (String)dataTable.getValueAt(row, 1);
							byte user_role = ((Role)dataTable.getValueAt(row, 2)).getRole_id();
							user.setUser_name(user_name);
							user.setUser_password(user_password);
							user.setUser_role(user_role);
							user.setOper_code(StudentScoreConstants.ADD);
							
							users.add(user);
							}
						}
						UserDAO userDao = new UserDAO();
						String msg = userDao.editUsers(users);
						JOptionPane.showMessageDialog(null, msg);

					}
					
				});
		exitButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		JPanel south = new JPanel();
		south.add(addButton);
		south.add(deleteButton);
		south.add(saveButton);
		south.add(exitButton);
		
		this.getContentPane().add(new JScrollPane(dataTable));
		this.getContentPane().add(south, BorderLayout.SOUTH);
		
		this.setSize(600, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private String[] getColumnNames(String[] names){
		String[] columnNames = new String[names.length + 3];
		for(int i = 0; i < names.length; i++){
			columnNames[i] = names[i];
		}
		columnNames[names.length] = "添加";
		columnNames[names.length + 1] = "删除";
		columnNames[names.length + 2] = "修改";
		return columnNames;
	}
}
