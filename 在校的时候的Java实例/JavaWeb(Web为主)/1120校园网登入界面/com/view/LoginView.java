package wang.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import wang.com.db.RoleDAO;
import wang.com.db.UserDAO;
import wang.com.model.Role;
import wang.com.model.User;

public class LoginView extends JDialog {
	private JTextField nameField;
	private JPasswordField passwordField;
	private JComboBox roleField;
	private JButton okButton;
	private JButton cancelButton;
	private User user = null;
	
	public LoginView(Frame owner, String title){
		super(owner, title, true);
		
		nameField = new JTextField();
		passwordField = new JPasswordField();
		RoleDAO roleDao = new RoleDAO();
		Role[] roles = roleDao.getAll();
		
		roleField = new JComboBox(roles);
		
		JPanel center = new JPanel(new GridLayout(3, 2, 1, 1));
		
		JLabel label = new JLabel("用户名");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		center.add(label);
		center.add(nameField);
		
		label = new JLabel("密     码");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		center.add(label);
		center.add(passwordField);
		
		label = new JLabel("角     色");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		center.add(label);
		center.add(roleField);
		
		JPanel south = new JPanel();
		
		okButton = new JButton("确定");
		cancelButton = new JButton("取消");
		
		south.add(okButton);
		south.add(cancelButton);
		
		Container c = this.getContentPane();
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		this.setSize(320, 150);
		this.setResizable(false);
		
		okButton.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String user_name = nameField.getText().trim();
					String user_password = passwordField.getText().trim();
					Role role = (Role)roleField.getSelectedItem();
					byte user_role = role.getRole_id();
					
					UserDAO userDao = new UserDAO();
					user = userDao.anthenticate(user_name, user_password, user_role);
					setVisible(false);
				}
				
			});
		cancelButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
					}
					
				});
	}
	
	public User showDialog(){
		this.setVisible(true);
		return user;
	}
	
}
