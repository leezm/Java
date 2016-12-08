package wang.com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import wang.com.control.SpringVibratorController;
import wang.com.model.SpringVibrator;




public class MainFrame extends JFrame {

	public MainFrame(){
		SpringVibratorView view = new SpringVibratorView();
		SpringVibrator ball = new SpringVibrator();
		view.setSpringVibrator(ball);
		ball.setView(view);
		
		SpringVibratorController controller = new SpringVibratorController();
		controller.setSpringVibrator(ball);
		controller.setView(view);
		
		this.getContentPane().add(view);
		this.getContentPane().add(controller.getSouth(), BorderLayout.SOUTH);
		
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
