package Lee.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Circle extends MoveObject {

	//vara为圆周的半径，varb为转速
	
	private double alpha = -Math.PI / 2;
	
	public Circle(){
		vara = 50;
		varb = 0;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		double cx = (double)view.getWidth() / 2;
		double cy = (double)view.getHeight() / 2;
		centerx = cx + vara * Math.cos(alpha);
		centery = cy + vara * Math.sin(alpha);
		
		g.draw(new Ellipse2D.Double(cx - vara, cy - vara, 2 * vara, 2 * vara));
		
		g.draw(new Line2D.Double(cx, cy, centerx, centery));
		
		g.fill(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		alpha += varb;
		view.repaint();
	}

}
