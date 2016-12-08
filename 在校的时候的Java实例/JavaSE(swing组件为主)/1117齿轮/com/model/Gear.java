package wang.com.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Gear {
	private double radius = 140;
	private double rotateAngle = 1.7;
	private Area gearArea;
	private Area showGearArea;
	
	private JPanel view;
	private Rectangle2D bounds;
	
	private boolean selected = false;
	
	public Gear(JPanel v){
		this.view = v;
		createGear();
	}
	public void setSelected(boolean b){
		this.selected = b;
		view.repaint();
	}
	public boolean isSelected(){
		return this.selected;
	}
	public void createGear(){
		double centerx = 400;
		double centery = 200;
		double alpha = Math.PI / 6;
		double beta = Math.PI / 12;
		double innerRadius = radius / (2 * Math.cos(beta));
		
		GeneralPath path = new GeneralPath();
		path.moveTo(centerx + radius, centery);
		
		for(int i = 0; i < 12; i++){
			path.lineTo(centerx + innerRadius * Math.cos(beta), centery + innerRadius * Math.sin(beta));
			path.lineTo(centerx + radius * Math.cos(alpha), centery + radius * Math.sin(alpha));
			beta += Math.PI / 6;
			alpha += Math.PI / 6;
		}
		
		path.closePath();
		
		gearArea = new Area(path);
		gearArea.add(new Area(new Ellipse2D.Double(centerx - innerRadius - 8, centery - innerRadius - 8, 2 * (innerRadius + 8), 2 * (innerRadius + 8))));
		gearArea.intersect(new Area(new Ellipse2D.Double(centerx - radius + 15, centery - radius + 15, 2 * (radius - 15), 2 * (radius - 15))));
		gearArea.subtract(new Area(new Ellipse2D.Double(centerx -15, centery - 15, 30, 30)));
		
		showGearArea = (Area)gearArea.clone();
		showGearArea.transform(AffineTransform.getRotateInstance(Math.PI / 100, centerx, centery));
		
		bounds = gearArea.getBounds2D();
		bounds.add(showGearArea.getBounds2D());
	}
	
	public void draw(Graphics2D g){
		g.setPaint(Color.darkGray);
		g.fill(showGearArea);
		float[] dist = {0.0f, 0.3f, 0.6f, 1.0f};
		Color[] colors = {Color.black, Color.darkGray, new Color(128, 128, 150), Color.lightGray};
		Paint paint = new RadialGradientPaint((float)bounds.getCenterX(), (float)bounds.getCenterY(), (float)radius - 15, dist, colors);
		g.setPaint(paint);
		g.fill(gearArea);
		if(selected){
			g.draw(bounds);
		}
		
	}
	
	public void move(){
		gearArea.transform(AffineTransform.getRotateInstance(rotateAngle, bounds.getCenterX(), bounds.getCenterY()));
		showGearArea.transform(AffineTransform.getRotateInstance(rotateAngle, bounds.getCenterX(), bounds.getCenterY()));
		view.repaint();
	}
	public void transform(double dx, double dy){
		bounds.setFrame(bounds.getX() + dx, bounds.getY() + dy, bounds.getWidth(), bounds.getHeight());
		AffineTransform t = AffineTransform.getTranslateInstance(dx, dy);
		gearArea.transform(t);
		showGearArea.transform(t);
		view.repaint();
	}
	
	public Rectangle2D getBounds(){
		return bounds;
	}
}
