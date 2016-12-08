package view;

import image.Loadback;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Role;
import model.User;

import db.RoleDao;
import db.UserDao;

public class LoginDialog extends JDialog {
	private User user = null;
	private JLabel userlabel;
	private JLabel rolelabel;
	private JLabel passwdlabel;
	private JTextField userfield;
	private JPasswordField passwd;
	private JButton loadbutton,cancelbutton;
	private JComboBox rolebox;
	private UserDao userDao = null;
	private RoleDao roleDao = null;
	public LoginDialog(Frame owner,String title){
		super(owner,title,true);
		this.setLayout(null);
		userlabel = new JLabel("用户名");
		userlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userlabel.setFont(new Font("黑体",Font.BOLD,18));
		userlabel.setBounds(100, 85, 80, 40);
		this.add(userlabel);
		
		userfield = new JTextField();
		userfield.setBounds(220, 90, 120, 30);
		userfield.grabFocus();
		this.add(userfield);
		
		passwdlabel = new JLabel("密  码");
		passwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwdlabel.setFont(new Font("黑体",Font.BOLD,18));
		passwdlabel.setBounds(100, 145, 80, 40);
		this.add(passwdlabel);
		
		passwd = new JPasswordField();
		passwd.setBounds(220, 145, 120, 30);
		this.add(passwd);
		
		rolelabel = new JLabel("角  色");
		rolelabel.setHorizontalAlignment(SwingConstants.CENTER);
		rolelabel.setFont(new Font("黑体",Font.BOLD,18));
		rolelabel.setBounds(100, 200, 80, 40);
		this.add(rolelabel);
		
		roleDao = new RoleDao();
		Role[] roles = roleDao.getAll();
		rolebox = new JComboBox(roles);
		rolebox.setBounds(220, 200, 120,30);
		this.add(rolebox);
		
		loadbutton = new JButton("登录");
		loadbutton.setHorizontalAlignment(SwingConstants.CENTER);
		loadbutton.setBounds(105, 275, 100, 40);
		this.add(loadbutton);
		
		cancelbutton = new JButton("取消");
		cancelbutton.setHorizontalAlignment(SwingConstants.CENTER);
		cancelbutton.setBounds(240, 275, 100, 40);
		this.add(cancelbutton);
		
		
		loadbutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String user_name = userfield.getText().trim();
						String user_passwd = new String(passwd.getPassword()).trim();
						Role role = (Role) rolebox.getSelectedItem();
						byte user_role = (byte)role.getRole_id();
						
						userDao = new UserDao();
						user = userDao.anthenticate(user_name, user_passwd, user_role);
						if(user != null){
							new ShowFrame(user);
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "您的登录有误，请重新登录！");
							userfield.setText("");
							passwd.setText("");
							userfield.grabFocus();
							return;
						}
					}
				});
		cancelbutton.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
		Loadback lb = new Loadback();
		lb.setBounds(0, 0, 450, 400);
		this.add(lb);
		int width = getToolkit().getDefaultToolkit().getScreenSize().width;
		int height = getToolkit().getDefaultToolkit().getScreenSize().height;
//		this.setUndecorated(true);
		this.setSize(450, 400);
		this.setLocation(width / 2 - 300, height / 2 - 240);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new LoginDialog(null, "用户登录");
	}
}
