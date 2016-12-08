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
	private JButton[] digitButtons = new JButton[10]; //����JButton������
	private JButton addButton;//����������������ص�JBUtton����
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton devidedButton; 
	private JButton pointButton;//������С���㡢�Ⱥ���ص�JBUtton����
	private JButton equalButton;
	
	public Calculator(){
		setLayout(new BorderLayout());
		field = new JTextField(); 
		field.setPreferredSize(new Dimension(200,30));//����field�����ǡ���ߴ�
		field.setHorizontalAlignment(SwingConstants.RIGHT); //����field�����е��ַ����뷽ʽΪ�Ҷ���
		field.setEditable(false); //����field����ʧЧ
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		field.setBorder(border);
		add(field,BorderLayout.NORTH); //��field������õ�this����ı���
		JPanel center = new JPanel(new GridLayout(4,4,1,1)); //�����������а�ť������
		for(int i = 0; i < digitButtons.length; i++){
			digitButtons[i] = createButton(String.valueOf(i),center);
		}
		pointButton = createButton(".",center);
		equalButton = createButton("=",center);
		addButton   = createButton("+",center);
		subtractButton = createButton("-",center);
		multiplyButton = createButton("*",center);
		devidedButton = createButton("/",center);
		add(center,BorderLayout.CENTER); //��center���õ�this��������������
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
		f.setTitle("������");
		f.setResizable(false); //���ÿ�ܵĴ�С���ܱ仯
		f.setSize(200,210);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

}
