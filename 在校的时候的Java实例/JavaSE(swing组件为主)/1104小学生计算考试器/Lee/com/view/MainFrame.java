package Lee.com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainFrame extends JFrame {

	private Timer timer;
	private final int MAX = 120;
	
	public MainFrame(){
		final TipPanel tipPanel = new TipPanel("认真，细心");
		this.getContentPane().add(tipPanel, BorderLayout.NORTH);	
		
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		final JButton startButton = new JButton("开始");
		startButton.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					timer.start();
					startButton.setEnabled(false);
				}
				
			});
		
		this.getContentPane().add(startButton, BorderLayout.SOUTH);
		timer = new Timer(1000, 
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					tipPanel.move();
				}
			
		});
	}
	public static void main(String[] args){
		new MainFrame();
	}
}
