package Lee.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;

public class Calculator extends JFrame {




	public class BackspaceArrowButton extends BasicArrowButton {
		
		public BackspaceArrowButton(
				int direction,	//箭头方向	
				Color background,	//背景颜色
				Color shadow,
				Color darkshadow,
				Color highlight
                ){
			super(direction);
			direction = SwingConstants.WEST;
			background = Color.darkGray;
			shadow = Color.darkGray;
			darkshadow = Color.black;
			highlight = Color.gray;
		}

		@Override
		public int getDirection() {
			// TODO Auto-generated method stub
			return getDirection();
		}

		@Override
		public void setDirection(int dir) {
			// TODO Auto-generated method stub
			direction = dir;
		}

		@Override
		public Dimension getPreferredSize() {
			// TODO Auto-generated method stub
			return getPreferredSize();
		}

		@Override
		public Dimension getMinimumSize() {
			// TODO Auto-generated method stub
			return getMinimumSize();
		}

		@Override
		public Dimension getMaximumSize() {
			// TODO Auto-generated method stub
			return getMaximumSize();
		}

	}



	public class OperatorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			isStart = false;
			Double left = 0.0;
			Double right = 0.0;
			if(leftBuffer.length() > 0){
				left = Double.parseDouble(leftBuffer.toString());
				leftBuffer.delete(0, leftBuffer.length());
			}else{
				leftBuffer.append(rightBuffer.toString());
			}
			right = Double.parseDouble(rightBuffer.toString());
			rightBuffer.delete(0, rightBuffer.length());
			
			switch(op){
			case 1:
				left += right;
				break;
			case 2:
				left -= right;
				break;
			case 3:
				left *= right;
				break;
			case 4:
				left /= right;
				break;
			}
			
			if(op != -1){
				leftBuffer.append(String.valueOf(left));
			}
			for(int i = 16; i < 20; i ++){
				if(e.getSource() == buttons[i]){
					op = i - 15;
					break;
				}
			}
			field.setText(leftBuffer.toString());

		}

	}




	/**
	 * @param args
	 */
	private JButton[] buttons = new JButton[20];	//创建对象数组,里面含有20个按钮的引用
	private JTextField field = new JTextField("0");
	
	StringBuffer leftBuffer = new StringBuffer();
	StringBuffer rightBuffer = new StringBuffer();
	private boolean isStart = false;
	private int op = -1;
	
	public Calculator(String title){
		super(title);
		Container c = this.getContentPane();
		JPanel panel = new JPanel(new GridLayout(5,4,2,2));
		panel.setBackground(Color.black);
		
		field.setBackground(Color.white);
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		field.setFont(new Font("Arial",Font.BOLD,18));
		field.setEditable(false);
	
		String[] titles = {"CE","C","<-","+/-","0","1","2","3","4","5","6","7","8","9",".","=","+","-","*","/"};
		//创建数组对象
		for(int i = 0; i < buttons.length; i++){
			CreateButton(panel, buttons, titles[i],i);
			
		}
		
		BackspaceArrowButton backspace = new BackspaceArrowButton(SwingConstants.WEST,Color.darkGray,Color.lightGray,Color.darkGray,Color.gray);
		buttons[2].setSize(getMaximumSize());
		backspace.add(buttons[2]);
		panel.add(backspace);
		
		c.add(field,BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		
		//数字监听器
		for(int i = 4; i < 14; i ++){
			buttons[i].addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//isStart = false;
							for(int i = 4; i < 14; i++){
								if(e.getSource() == buttons[i]){
									rightBuffer.append(i - 4);
									field.setText(rightBuffer.toString());
								}
							}
						}
						
					}
					);
		}
		
		//小数点监听器及实现
		buttons[14].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!isStart){
							rightBuffer.append(".");
							field.setText(rightBuffer.toString());
							isStart = true;
						}
						
					}
					
				}
		);
		
		//实现CE-清空运算符后面输入的数
		buttons[0].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						rightBuffer.delete(0, rightBuffer.length());
						field.setText(rightBuffer.toString());
					}
					
				}
				
		);
		
		//实现C-全部清空所输入的数
		buttons[1].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						leftBuffer.delete(0, leftBuffer.length());
						rightBuffer.delete(0, rightBuffer.length());
						field.setText(rightBuffer.toString());
						op = -1;
					}
					
				}
		);
		
		//退格键
		buttons[2].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getSource() == buttons[2]){
							int i = rightBuffer.length();
							rightBuffer.delete(i-1, i);
							field.setText(rightBuffer.toString());
							i--;
						/*	if(i <= 0){
								field.setText("");
							}	*/
						}
						
						
					}
					
				}
		);
		
		// “+/-”正负号的实现
		buttons[3].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(rightBuffer.length() <= 0 || Double.parseDouble(rightBuffer.toString()) > 0){
							/*
							String temp = new String();
							temp = rightBuffer.toString();
							rightBuffer.delete(0, rightBuffer.length());
							rightBuffer.append("-" + temp);
							field.setText(rightBuffer.toString());
							*/
							rightBuffer.insert(0, "-");
							field.setText(rightBuffer.toString());
							
						}else if(Double.parseDouble(rightBuffer.toString()) < 0){
							/*
							String temp2 = new String();
							rightBuffer.delete(0, 1);
							temp2 = rightBuffer.toString();
							rightBuffer.delete(0, rightBuffer.length());
							rightBuffer.append(temp2);
							field.setText(rightBuffer.toString());
							*/
							rightBuffer.delete(0, 1);
							field.setText(rightBuffer.toString());
						}
					}
					
				}
		);
		
		//运算符监听器
		OperatorHandler operator = new OperatorHandler();
		for(int i = 15; i < 20; i++){
			buttons[i].addActionListener(operator);
		}
		
		this.setSize(320,270);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	
	
	//创建数组对象
	private void CreateButton(JPanel panel,JButton[] buts, String title, int index) {
		// TODO Auto-generated method stub
		buts[index] = new JButton(title);
		buts[index].setBackground(Color.lightGray);
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		buts[index].setBorder(border);
		panel.add(buts[index]);
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator("计算器");
		
	}

}
