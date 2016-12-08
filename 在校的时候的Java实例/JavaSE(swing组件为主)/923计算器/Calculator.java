package Lee.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Calculator extends JPanel {

	/**
	 * @param args
	 */
	private JTextField field; 
	private JButton[] digitButtons = new JButton[10]; //产生JButton的数组
	private JButton addButton;//定义与四则运算相关的JBUtton引用
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton devidedButton; 
	private JButton pointButton;//定义与小数点、等号相关的JBUtton引用
	private JButton equalButton;
	
	public Calculator(){
		setLayout(new BorderLayout());
		field = new JTextField(); 
		field.setPreferredSize(new Dimension(200,30));//设置field对象的恰当尺寸
		field.setHorizontalAlignment(SwingConstants.RIGHT); //设置field对象中的字符对齐方式为右对齐
		field.setEditable(false); //设置field对象失效
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		field.setBorder(border);
		add(field,BorderLayout.NORTH); //将field对象放置到this对象的北区
		JPanel center = new JPanel(new GridLayout(4,4,1,1)); //创建放置所有按钮的容器
		for(int i = 0; i < digitButtons.length; i++){
			digitButtons[i] = createButton(String.valueOf(i),center);
		}
		pointButton = createButton(".",center);
		equalButton = createButton("=",center);
		addButton   = createButton("+",center);
		subtractButton = createButton("-",center);
		multiplyButton = createButton("*",center);
		devidedButton = createButton("/",center);
		add(center,BorderLayout.CENTER); //将center放置到this容器的中央区域
	}
		private JButton createButton(String title,JPanel panel){
			JButton button = new JButton(title);
			button.setFont(new Font("Afrial",Font.BOLD,14));
			panel.add(button);
			return button;
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(190,190);	
		}
		public Dimension getMaximumSize(){
			return new Dimension(200,200);
		}
		
		public Dimension getMinimumSize(){
			return getPreferredSize();
		}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.getContentPane().add(new Calculator());
		f.setTitle("计算器");
		f.setResizable(false); //设置框架的大小不能变化
		f.setSize(200,210);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

}
