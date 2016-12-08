package Lee.com;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	public class ExitHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);

		}

	}
	private static final String SwingConstands = null;
	private JLabel label;
	private JTextField field;
	private JButton startButton;
	private JButton exitButton;
	
	
	public MainFrame(String title){
		super(title);
		label = new JLabel("00:00");
		label.setFont(new Font("黑体",Font.BOLD + Font.ITALIC,20));
		Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		label.setBorder(border);
		
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setForeground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		field = new JTextField();
		
		startButton = new JButton("开始");
		exitButton = new JButton("退出");
		
	
		JPanel startPanel = new JPanel();
		startPanel.add(startButton);
		JPanel exitPanel = new JPanel();
		exitPanel.add(exitButton);
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2,2,1,1));
		c.add(label);
		c.add(field);
		c.add(startButton);
		c.add(exitButton);
		
		this.setResizable(false);
		this.setSize(240,90);
		this.setVisible(true);
	
		ExitHandler handler = new ExitHandler();
		exitButton.addActionListener(handler);
		
		
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MainFrame("倒计时牌");

	}

}
