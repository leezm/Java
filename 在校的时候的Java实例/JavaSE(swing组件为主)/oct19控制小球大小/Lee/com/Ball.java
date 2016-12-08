package Lee.com;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Ball {
	private double centerx;
	private double centery;
	private double radius;
	private Color color = Color.black;
	
	
	private JPanel view;
	public Ball(JPanel v){
		this.view = v;
	}
	public void setCenter(int x, int y){
		this.centerx = x;
		this.centery = y;
		view.repaint();
	}
	public void setRadius(double r){
		this.radius = r;
		view.repaint();
	}
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
	}
	
}
