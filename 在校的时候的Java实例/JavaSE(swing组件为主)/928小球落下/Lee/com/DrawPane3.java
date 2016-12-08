package Lee.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.Timer;

import javax.swing.JPanel;

import Lee.com.model.Ball;

public class DrawPane3 extends JPanel {
	
	private Ball ball;
	private Timer timer;
	public DrawPane3(){
		ball = new Ball(400,300, this);
		timer = new Timer(50,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ball.move();
			}
			
		});
		timer.start();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ball.drawBall(g);
		
	}



	public static void main(String[] args){
		DrawPane drawPane = new DrawPane();
		
		JFrame f = new JFrame();
		f.getContentPane().add(drawPane);
		
		f.setSize(1400,900);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
