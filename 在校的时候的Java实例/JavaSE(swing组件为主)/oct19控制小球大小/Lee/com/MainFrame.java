package Lee.com;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame(){
		BallView view = new BallView();
		BallController controller = new BallController();
		
		
		this.getContentPane().add(view);
		this.getContentPane().add(controller.getSouth(), BorderLayout.SOUTH);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		controller.setBallView(view);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
