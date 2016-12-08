package Lee.com;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * @param args
	 */
	public MainFrame(){
	//	BallView view = new BallView();
	//	BallController controller = new BallController();
	//	controller.setBallView(view);
		
	//	this.getContentPane().add(view);
		DrawPane drawPane = new DrawPane();
		this.getContentPane().add(drawPane);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
