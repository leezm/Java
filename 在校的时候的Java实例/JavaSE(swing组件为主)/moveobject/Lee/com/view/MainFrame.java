package Lee.com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import Lee.com.control.MoveObjectController;
import Lee.com.model.Ball;
import Lee.com.model.MoveObject;

public class MainFrame extends JFrame {

	private MoveObjectView view = null;
	
	private MoveObjectController controller;
	public MainFrame(){
		view = new MoveObjectView();
		controller = new MoveObjectController();
		controller.setMoveObjectView(view);
		
		this.getContentPane().add(view);
		this.getContentPane().add(controller.getSouth(),BorderLayout.SOUTH);
		
		
		JMenuBar bar = new JMenuBar();
		bar.add(controller.getMoveObjectMenu());
		this.setJMenuBar(bar);
		
		this.setSize(1000,700);
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
