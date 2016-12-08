package Lee.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorFrame extends JFrame {
	private JButton[] buttons = new JButton[20];
	private JTextField field = new JTextField("0");
	private StringBuffer leftBuffer = new StringBuffer();
	private StringBuffer rightBuffer = new StringBuffer();
	private boolean isPoint = false; //判断同一组数据中是否已经存在小数点
	private int op = -1;
	
	public CalculatorFrame(String title){
		super(title);
		
		Container c = this.getContentPane();
		JPanel center = new JPanel(new GridLayout(5,4,2,2));
		
		String[] titles = {"0","1","2","3","4","5","6","7","8","9",".","=","/","*","-","+","+/-","<-","C","CE"};
		for(int i = buttons.length - 1; i >= 0; i--){
			makeButton(center,titles[i],buttons,i);
		}
		
		NumberHandler handler = new NumberHandler();
		for(int i = 0;i < 10; i++){
			buttons[i].addActionListener(handler);
		}
	
						
		buttons[10].addActionListener(
				 	new ActionListener(){
						@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!isPoint){
							rightBuffer.append(".");
							field.setText(rightBuffer.toString());
							isPoint = true;
					}
				}		
			});
		Operator operator = new Operator();
		for(int i = 12; i < 16; i++){
			buttons[i].addActionListener(operator);
		}
		//等号 
		buttons[11].addActionListener(
				new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(leftBuffer.length() == 0 || rightBuffer.length() == 0 || op == -1){
					return;
				}
				double left = Double.parseDouble(leftBuffer.toString());
				double right = Double.parseDouble(rightBuffer.toString());
				leftBuffer.delete(0, leftBuffer.length());
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
			  }	
			});
		buttons[12].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						op = 3;
						setData();
					}
					
				});
		buttons[13].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						op = 2;
						setData();
					}
					
				});
		buttons[14].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						op = 1;
						setData();
					}
					
				});
		buttons[15].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						op = 0;
						setData();
					}
					
				});
		buttons[16].addActionListener(
				new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				}
			});
		
		//退格键
		buttons[17].addActionListener(
				new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubif(e.getSource() == buttons[2]){
				if(e.getSource() == buttons[17]){
					int i = rightBuffer.length();
					rightBuffer.delete(i-1, i);
					field.setText(rightBuffer.toString());
					i--;
					}
				}
			});
		
		//清除全部
		buttons[18].addActionListener(
				new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				leftBuffer.delete(0, leftBuffer.length());
				rightBuffer.delete(0, rightBuffer.length());
				field.setText(rightBuffer.toString());
				op = -1;
				}
			});
		
		//清除当前编辑的内容
		buttons[19].addActionListener(
				new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rightBuffer.delete(0, rightBuffer.length());
				field.setText(rightBuffer.toString());
				}
			});
		
		//界面属性设置
		field.setEnabled(false);
		field.setFont(new Font("Arial",Font.PLAIN,10));
		field.setBackground(Color.white);
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		
		c.add(field, BorderLayout.NORTH);
		c.add(center,BorderLayout.CENTER);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setResizable(false);
	}
		
	//四则运算方法
	private void setData(){
		isPoint = false;
		double left = 0;
		double right = 0;
		if(leftBuffer.length() > 0){
			left = Double.parseDouble(leftBuffer.toString());
			leftBuffer.delete(0, leftBuffer.length());
		}
		right = Double.parseDouble(rightBuffer.toString());
		switch(op){
		case 0:
			left += right;
			break;
		case 1:
			left -= right;
			break;
		case 2:
			left *= right;
			break;
		case 3:
			left /= right;
			break;
		}
		leftBuffer.append(left + "");
		rightBuffer.delete(0, rightBuffer.length());
		
	}

	//创建数组对象
	private void makeButton(JPanel panel,String title,JButton[] btns,int index){
		btns[index] = new JButton(title);
		panel.add(btns[index]);	
	}
	
	private class NumberHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i = 0;i < 10;i++){
				if(e.getSource() == buttons[i]){
					if(rightBuffer.length() == 0 && i == 0){
						return;
					}
					rightBuffer.append(i);
					field.setText(rightBuffer.toString());
					break;
				}
			
			}
			
		}
	}

	private class Operator implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			isPoint = false;
			int op = 1;
			for(int i = 12; i < 16; i++){
				if(e.getSource() == buttons[i]){
					op = 15 - i;
					break;
				}
			}	
			double left = 0;
			double right = 0;
			if(leftBuffer.length() > 0){
				left = Double.parseDouble(leftBuffer.toString());
				leftBuffer.delete(0, leftBuffer.length());
			}
			right = Double.parseDouble(rightBuffer.toString());
			switch(op){
			case 0:
				left += right;
				break;
			case 1:
				left -= right;
				break;
			case 2:
				left *= right;
				break;
			case 3:
				left /= right;
				break;
			}
			leftBuffer.append(String.valueOf(left));
			rightBuffer.delete(0, rightBuffer.length());
			field.setText(leftBuffer.toString());
		}
		
	}
	
	//输出界面
	public static void main(String[] args){
		new CalculatorFrame("计算器");
	}

	
}
