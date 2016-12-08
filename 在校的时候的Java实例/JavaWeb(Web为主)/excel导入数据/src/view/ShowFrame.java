package view;

import java.awt.BorderLayout;
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

import controll.OperController;
import controll.UserController;

import model.Role;
import model.User;
import db.RoleDao;
import db.UserDao;

public class ShowFrame extends JFrame {

	private User user;
	public ShowFrame(User user){
		this.user = user;
		OperController oper = new OperController();
		UserController usercontroller = new UserController();
		this.setSize(600, 600);
		this.setJMenuBar(oper.getBar());
		this.getContentPane().add(new JScrollPane(usercontroller.setTable()));
		this.getContentPane().add(usercontroller.south(),BorderLayout.SOUTH);
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
		new ShowFrame(null);
	}

}
