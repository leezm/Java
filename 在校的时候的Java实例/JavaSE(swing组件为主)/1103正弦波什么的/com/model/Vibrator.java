package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Vibrator extends MoveObject {

	//varaÕñ·ù,varbÆµÂÊ
	private double t = 0;
	private double delta = 0.1;
	
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		double cx = (double)view.getWidth() / 2;
		double cy = (double)view.getHeight() / 2;
		centery = cy;
		centerx = cx + vara * Math.sin(varb * t);
		
		g.draw(new Line2D.Double(cx, cy, centerx, centery));
		g.fill(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
		
		g.draw(new Line2D.Double(0, centery + radius, view.getWidth(), centery + radius));
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		t += delta;
		view.repaint();
	}

}
