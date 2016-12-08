package wang.com.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import wang.com.model.Projectile;

public class ProjectileView extends JPanel {
	private Projectile ball;

	public void setProjectile(Projectile ball) {
		this.ball = ball;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(ball != null){
			ball.draw(g2);
		}
	}
	
}
