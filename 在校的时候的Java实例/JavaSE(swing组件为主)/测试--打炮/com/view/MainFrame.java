package wang.com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;


import wang.com.control.ProjectileController;

import wang.com.model.Projectile;



public class MainFrame extends JFrame {

	public MainFrame(){
		
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		ProjectileView view = new ProjectileView();
		Projectile ball = new Projectile();
		
		view.setProjectile(ball);
		ball.setView(view);
		
		ProjectileController controller = new ProjectileController();
		controller.setView(view);
		controller.setProjectile(ball);
		
		
		this.getContentPane().add(view);
		this.getContentPane().add(controller.getSouth(), BorderLayout.SOUTH);
		this.validate();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
