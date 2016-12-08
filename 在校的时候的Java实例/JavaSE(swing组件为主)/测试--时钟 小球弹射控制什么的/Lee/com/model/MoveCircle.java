package Lee.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class MoveCircle {

	private double centerx;
	private double centery;
	private final double radius = 15;
	private double largeRadius = 260;
	private double alpha = -Math.PI / 2;
	private double delta;
	
	private Ellipse2D smallCircle = new Ellipse2D.Double();
	private Line2D line = new Line2D.Double();
	private Ellipse2D largeCircle = new Ellipse2D.Double();
	
	private JPanel view;
	
	public void setMoveCircleView(JPanel view){
		this.view = view;
	}
	
	public double getCenterx() {
		return centerx;
	}


	public void setCenterx(double centerx) {
		this.centerx = centerx;
	}


	public double getCentery() {
		return centery;
	}


	public void setCentery(double centery) {
		this.centery = centery;
	}


	public double getLargeRadius() {
		return largeRadius;
	}

	public void setLargeRadius(double largeRadius) {
		this.largeRadius = largeRadius;
		view.repaint();
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
		view.repaint();
	}
	
	public void draw(Graphics2D g){
		double x = centerx + largeRadius * Math.cos(alpha);
		double y = centery + largeRadius * Math.sin(alpha);
		
		smallCircle.setFrameFromCenter(x, y, x - radius, y - radius);
		line.setLine(centerx, centery, x, y);
		largeCircle.setFrameFromCenter(centerx, centery, centerx - largeRadius, centery - largeRadius);
		
		g.draw(largeCircle);
		g.draw(line);
		g.fill(smallCircle);
		
	}
	public void move(){
		alpha += delta;
		view.repaint();
	}
}
