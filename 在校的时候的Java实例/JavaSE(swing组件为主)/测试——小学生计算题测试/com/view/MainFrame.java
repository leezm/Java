package wang.com.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import wang.com.control.ArithmeticController;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		ArithmeticView view = new ArithmeticView();
		ArithmeticController control = new ArithmeticController();
		control.setArithmeticView(view);
		
		Container c = this.getContentPane();
		c.add(view, BorderLayout.CENTER);
		c.add(control.getButtonsPane(), BorderLayout.SOUTH);
		
		this.setSize(520, 460);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
