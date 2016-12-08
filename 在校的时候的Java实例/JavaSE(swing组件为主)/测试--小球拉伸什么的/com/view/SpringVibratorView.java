package wang.com.view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import wang.com.model.SpringVibrator;

public class SpringVibratorView extends JPanel {

	private SpringVibrator ball;
	
	public void setSpringVibrator(SpringVibrator ball){
		this.ball = ball;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2.0f));
		if(ball != null){
			ball.draw(g2);
		}
	}
	
}
