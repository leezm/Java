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
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener{
	
	public class StartHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//获取文本框的数据并转换为整数；
			max =  Integer.parseInt(field.getText());
			timer.start();
		}

	}

	public class ExitHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);		
			startButton.setEnabled(false);
			field.setEditable(false);
		}

	}
	private int max = 0;
	private Timer timer = new Timer(1000,this);
	private JLabel label;
	private JTextField field;
	private JButton startButton;
	private JButton exitButton;
	
	public MainFrame(String title){
		super(title);
		label = new JLabel("00:00");
		//设置字体、字形、字号
		label.setFont(new Font("黑体",Font.BOLD + Font.ITALIC,45));
		//设置字体效果；
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		label.setBorder(border);
		//设置不透明；
		label.setOpaque(true);
		//设置前景背景颜色
		label.setBackground(Color.blue);
		label.setForeground(Color.red);
		//设置水平对齐；---------------------垂直对齐是label.setVerticalAlignment(alignment);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		field = new JTextField();
		//设置开始结束按钮；
		startButton = new JButton("开始");
		exitButton = new JButton("退出");
		JPanel startPanel = new JPanel();
		JPanel exitPanel = new JPanel();
		startPanel.add(startButton);
		exitPanel.add(exitButton);
		Container c = this.getContentPane();
		//设置行列间距；(布局管理器）
		setLayout(new GridLayout(2,2,1,1));
		//按照由上到下，由左到右的顺序显示；
		c.add(label);
		c.add(field);
		c.add(startPanel);
		c.add(exitPanel);
		ExitHandler exitHandler  = new ExitHandler();
		exitButton.addActionListener(exitHandler);
		StartHandler startHandler = new StartHandler();
		startButton.addActionListener(startHandler);
		
		//锁定窗口
		this.setResizable(false);
		this.setSize(300,110);
		this.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("倒计时牌（单位：秒）");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(max > 0){
			field.setText("");
			startButton.setEnabled(false);
			field.setEditable(false);
			max -= 1;
		}else if(max <= 0){
			startButton.setEnabled(true);
			field.setEditable(true);
		}
		int minute = max / 60;
		int second = max % 60;
		String value = ((minute < 10) ? "0" : "") + minute + ":" + ((second < 10) ? "0" : "") + second;
		label.setText(value);
	}

}
