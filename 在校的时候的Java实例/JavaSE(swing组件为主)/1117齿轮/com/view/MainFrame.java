package wang.com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import wang.com.model.Gear;

public class MainFrame extends JFrame {

	public MainFrame(){
		super("Gear Demo");
		
		GearView view = new GearView();
		Gear gear = new Gear(view);
		
		view.setGear(gear);
		
		this.getContentPane().add(view);
		this.getContentPane().add(view.getButtonsPane(),BorderLayout.SOUTH);
		
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
