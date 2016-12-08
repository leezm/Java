package Lee.com;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Ball {
	private double centerx;
	private double centery;
	private double radius = 15;
	private Color color = Color.black;
	private double deltax;
	private double deltay;
	
	private JPanel view;
	public Ball(JPanel v, double x, double y){
		this.view = v;
		this.centerx = x;
		this.centery = y;
		deltax = Math.random() * 20;
		deltay = Math.random() * 20;
		int sgnx = (int)(Math.random() * 2);
		int sgny = (int)(Math.random() * 2);
		if(sgnx == 0){
			deltax = -deltax;
		}
		if(sgny == 0){
			deltay = -deltay;
		}
	}
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
	}
	public void move(){
		centerx += deltax;
		centery += deltay;
		if(centerx <= radius){
			centerx = radius;
			deltax = -deltax;
		}
		if(centerx >= view.getWidth() - radius){
			centerx = view.getWidth() - radius;
			deltax = -deltax;
		}
		if(centery <= radius){
			centery = radius;
			deltay = -deltay;
		}
		if(centery >= view.getHeight() - radius){
			centery = view.getHeight() - radius;
			deltay = -deltay;
		}
		view.repaint();
	}
}
