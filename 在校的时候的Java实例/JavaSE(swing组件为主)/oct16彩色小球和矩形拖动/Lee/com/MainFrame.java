package Lee.com;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * @param args
	 */
	public MainFrame(){
	    DrawPane drawPane = new DrawPane();
	//	DrawPane2 drawPane2 = new DrawPane2();
		this.getContentPane().add(drawPane);
	//	this.getContentPane().add(drawPane2);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
