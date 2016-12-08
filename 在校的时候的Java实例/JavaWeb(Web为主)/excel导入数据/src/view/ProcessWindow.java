package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class ProcessWindow extends JWindow implements Runnable{
	private JProgressBar progressbar;
	private JLabel label;
	private int width;
	private int height;
	
	public ProcessWindow(){
		label = new JLabel(new ImageIcon("image/p.gif"));
		progressbar = new JProgressBar();
		progressbar.setStringPainted(true);
		progressbar.setIndeterminate(false);
		progressbar.setBorderPainted(false);
		progressbar.setBackground(Color.black);

		this.add(label,BorderLayout.NORTH);
		this.add(progressbar,BorderLayout.SOUTH);
		
		this.setSize(320,263);
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.setLocation(width / 2 - 200, height / 2 - 150);
		this.setVisible(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] progressValue = {0,1,3,7,9,15,16,19,20,27,29,34,38,45,51,54,56,63,67,69,75,77,81,94,96,97,98,99,100};
		for(int i = 0;i < progressValue.length;i++){
			try{
				Thread.sleep(300);
			}catch(Exception e){
				e.printStackTrace();
			}
			progressbar.setValue(progressValue[i]);
		}
		new LoginDialog(null, "欢迎进入此此管理系统");
		this.dispose();
	}
}
