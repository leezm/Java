package Lee.com.view;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Clock {

	private double minRadius = 12;
	private double secondRadius = 15;
	private double minAlpha = -Math.PI / 2;
	private double secondAlpha = -Math.PI / 2;
	
	private Ellipse2D circle = new Ellipse2D.Double();
	private Line2D minuteLine = new Line2D.Double();
	private Line2D secondLine = new Line2D.Double();
	
	private JPanel view;
	
	public Clock(JPanel view){
		this.view = view;
		circle.setFrameFromCenter(0, 0, -17, -17);
		minuteLine.setLine(0, 0, minRadius * Math.cos(minAlpha), minRadius * Math.sin(minAlpha));
		secondLine.setLine(0, 0, secondRadius * Math.cos(secondAlpha), secondRadius * Math.sin(secondAlpha));
	}
	
	public void reset(){
		minAlpha = -Math.PI / 2;
		secondAlpha = -Math.PI / 2;
		view.repaint();
	}
	public void draw(Graphics2D g){
		g.translate((double)view.getWidth() / 2, (double)view.getHeight() / 2);
		g.draw(circle);
		g.draw(secondLine);
		g.draw(minuteLine);
	}
	public void move(){
		minAlpha += Math.PI / 1800;
		secondAlpha += Math.PI / 30;
		minuteLine.setLine(0, 0, minRadius * Math.cos(minAlpha), minRadius * Math.sin(minAlpha));
		secondLine.setLine(0, 0, secondRadius * Math.cos(secondAlpha), secondRadius * Math.sin(secondAlpha));
		view.repaint();
	}
}
