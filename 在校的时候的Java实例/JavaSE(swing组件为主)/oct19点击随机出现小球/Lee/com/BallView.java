package Lee.com;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallView extends JPanel {
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	

	public void addBall(Ball ball){
		balls.add(ball);
		repaint();
	}
	public ArrayList<Ball> getBalls(){
		return balls;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(int index = 0; index < balls.size(); index++){
			balls.get(index).draw(g2);
		}
		
	}
	
}
