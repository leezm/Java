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
			//��ȡ�ı�������ݲ�ת��Ϊ������
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
		//�������塢���Ρ��ֺ�
		label.setFont(new Font("����",Font.BOLD + Font.ITALIC,45));
		//��������Ч����
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		label.setBorder(border);
		//���ò�͸����
		label.setOpaque(true);
		//����ǰ��������ɫ
		label.setBackground(Color.blue);
		label.setForeground(Color.red);
		//����ˮƽ���룻---------------------��ֱ������label.setVerticalAlignment(alignment);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		field = new JTextField();
		//���ÿ�ʼ������ť��
		startButton = new JButton("��ʼ");
		exitButton = new JButton("�˳�");
		JPanel startPanel = new JPanel();
		JPanel exitPanel = new JPanel();
		startPanel.add(startButton);
		exitPanel.add(exitButton);
		Container c = this.getContentPane();
		//�������м�ࣻ(���ֹ�������
		setLayout(new GridLayout(2,2,1,1));
		//�������ϵ��£������ҵ�˳����ʾ��
		c.add(label);
		c.add(field);
		c.add(startPanel);
		c.add(exitPanel);
		ExitHandler exitHandler  = new ExitHandler();
		exitButton.addActionListener(exitHandler);
		StartHandler startHandler = new StartHandler();
		startButton.addActionListener(startHandler);
		
		//��������
		this.setResizable(false);
		this.setSize(300,110);
		this.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("����ʱ�ƣ���λ���룩");
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
