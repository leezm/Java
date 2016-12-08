package Lee.com;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallView extends JPanel {
	private Ball ball;

	public void setBall(Ball ball){
		this.ball = ball;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		ball.draw(g2);
	}
	
}
