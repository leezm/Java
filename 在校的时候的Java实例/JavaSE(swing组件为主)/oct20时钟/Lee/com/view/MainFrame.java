package Lee.com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Lee.com.control.MoveCircleController;
import Lee.com.model.MoveCircle;

public class MainFrame extends JFrame {

	public MainFrame(){
		MoveCircleView view = new MoveCircleView();
		MoveCircle circle = new MoveCircle(view);
		MoveCircleController controller = new MoveCircleController();
		controller.setMoveCircleView(view, circle);
		
		this.getContentPane().add(view);
		this.getContentPane().add(controller.getControllerView(), BorderLayout.SOUTH);
		
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

