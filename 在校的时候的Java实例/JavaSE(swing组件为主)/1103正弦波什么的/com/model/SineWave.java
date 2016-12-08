package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class SineWave extends MoveObject {

	private double t = 0;
	private double delta = 0.1;
	
	public SineWave(){
		this.vara = 20;
		this.varb = 0.1;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		centerx = (double)view.getWidth() / 2;
		centery = (double)view.getHeight() / 2;
		g.translate(centerx, centery);
		
		int left = -(int)centerx;
		int right = (int)centerx;
		
		for(int x = left; x < right; x += 2){
			Line2D line = new Line2D.Double(x, 100 * Math.sin(this.varb * (t + x / this.vara)), x + 2, 100 * Math.sin(this.varb * (t + (x + 2) / this.vara)));
			g.draw(line);
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		t += delta;
		view.repaint();
	}

}
