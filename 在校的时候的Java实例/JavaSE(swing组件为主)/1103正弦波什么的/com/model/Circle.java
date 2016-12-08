package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Circle extends MoveObject {

	//vara为圆周的半径，varb为转速
	
	private double alpha = -Math.PI / 2;
	private Ellipse2D largeBall = new Ellipse2D.Double();
	private Line2D line = new Line2D.Double();
	public Circle(){
		vara = 50;
		varb = 0;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		
		g.draw(largeBall);
		
		g.draw(line);
		
		g.fill(ball);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		alpha += varb;
		double cx = (double)view.getWidth() / 2;
		double cy = (double)view.getHeight() / 2;
		centerx = cx + vara * Math.cos(alpha);
		centery = cy + vara * Math.sin(alpha);
		largeBall.setFrameFromCenter(cx, cy,cx - vara, cy - vara);
		line.setLine(cx, cy, centerx, centery);
		ball.setFrameFromCenter(centerx, centery, centerx - radius, centery - radius);
		
		view.repaint();
	}

}
