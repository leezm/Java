package zhang;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Game {
	private double cx;
	private double cy;
	private final double radius = 15;
	private final int lineCount = 18;
	
	private JPanel view;
	private Color color;

	private Line2D line1 = new Line2D.Double();
	private Line2D line2 = new Line2D.Double();
	private Ellipse2D ellipse = new Ellipse2D.Double();
	
	public Game(JPanel v) {
		this(v,0,0);
	}
	
	public Game(JPanel v,double x, double y){
		this.view = v;
		this.cx = x;
		this.cy = y;
	}
	
	public void draw(Graphics2D g){
		//ª≠∆Â≈ÃÕ¯∏Ò
		double x1 = view.getWidth() / lineCount;
		double y1 = view.getHeight() / lineCount;
		for(int i = 0; i <= lineCount; i ++){
			line1.setLine(x1 * i, 0, x1 * i, view.getHeight());
			line2.setLine(0, y1 * i, view.getWidth(), y1 * i);
			g.setPaint(Color.black);
			g.draw(line1);
			g.draw(line2);
		}
		
		//ª≠∆Â◊”
		ellipse.setFrameFromCenter(cx, cy, cx - radius, cy - radius);
		g.setPaint(color);
		g.fill(ellipse);
			
	}
	

	public void move(){	
		if(cx - radius <= 0){
			cx = radius;
			
		}else if(cy - radius <= 0){
			cy = radius;
			
		}else if(cx + radius >= view.getWidth()){
			cx = view.getWidth() - radius;
			
		}else if(cy + radius >= view.getHeight()){
			cy = view.getHeight() - radius;
		}
		view.repaint();
		
	}
	
	public void setCxy(double cx,double cy) {
		this.cx = cx;
		this.cy = cy;
		view.repaint();
	}
	
	public void setColor(Color color) {
		this.color = color;
		view.repaint();
	}

	

}
