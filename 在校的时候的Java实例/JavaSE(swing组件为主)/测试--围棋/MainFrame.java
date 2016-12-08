package zhang;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

	public MainFrame(){
		GameView view = new GameView();
		Game game = new Game(view);
		GameController controller = new GameController();
		controller.setView(game, view);
		
		this.getContentPane().add(view,BorderLayout.CENTER);
		this.getContentPane().add(controller.getSouth(), BorderLayout.SOUTH);
		
		this.setSize(800,750);
		this.setResizable(true);
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
