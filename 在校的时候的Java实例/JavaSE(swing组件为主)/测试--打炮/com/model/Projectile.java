package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Projectile {
	private final double radius = 15;
	private double centerx = radius;
	private double centery = -radius;
	private double t = 0;
	private double delta = 0.1;
	private double alpha = 0;
	private double velocity = 0;
	
	private double x1 = centerx;
	private double y1 = centery;
	private double x2 = centerx;
	private double y2 = centery;
	
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();
	
	private Ellipse2D ball = new Ellipse2D.Double();
	
	private JPanel view;

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public void setView(JPanel view) {
		this.view = view;
	}
	
	public void reset(){
		centerx = radius;
		centery = -radius;
		t = 0;
		alpha = 0;
		velocity = 0;
		x2 = x1 = centerx;
		y2 = y1 = centery;
		view.repaint();
	}
	public void draw(Graphics2D g){
		g.translate(0, view.getHeight());
		
		ball.setFrameFromCenter(centerx, centery, centerx - radius, centery - radius);
		g.fill(ball);
		for(int index = 0; index < lines.size(); index++){
			g.draw(lines.get(index));
		}
	}
	
	public boolean isReset(){
		if(centery >= -radius){
			return true;
		}else{
			return false;
		}
	}
	public void move(){
		if(velocity == 0){
			return;
		}
		t += delta;
		x1 = x2;
		y1 = y2;
		centerx = velocity * Math.cos(alpha) * t + radius;
		centery = -velocity * Math.sin(alpha) * t + 5 * t * t - radius;
		x2 = centerx;
		y2 = centery;
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		lines.add(line);
		view.repaint();
		
	}
}
