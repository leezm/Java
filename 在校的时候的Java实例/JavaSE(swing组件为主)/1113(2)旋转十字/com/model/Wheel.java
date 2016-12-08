package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Wheel {
	private Area wheelArea;
	private double centerx;
	private double centery;
	private final double radius = 30;
	private double alpha = 0;
	private JPanel view;
	
	public Wheel(JPanel v){
		this.view = v;
		
		centerx = (double)view.getWidth() / 2;
		centery = (double)view.getHeight() / 2;
		
		wheelArea = new Area(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
		wheelArea.subtract(new Area(new Rectangle2D.Double(centerx - 2, centery - radius, 4, 2 * radius)));
		wheelArea.subtract(new Area(new Rectangle2D.Double(centerx - radius, centery - 2, 2 * radius, 4)));
	}
	
	public void draw(Graphics2D g){
		g.fill(wheelArea);
	}
	
	public void move(){
		wheelArea.transform(AffineTransform.getRotateInstance(Math.PI / 20, centerx, centery));
		view.repaint();
	}
}
