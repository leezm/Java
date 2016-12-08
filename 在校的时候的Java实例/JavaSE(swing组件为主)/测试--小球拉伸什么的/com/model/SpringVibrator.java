package wang.com.model;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class SpringVibrator {

	private double amplitude = 50;
	private double frequency = 0;
	private double t = 0;
	private double delta = 0.01;
	
	private double centerx = 0;
	
	private final double radius = 15;
	private Ellipse2D ball = new Ellipse2D.Double();
	private Line2D line = new Line2D.Double();
	private Line2D subline = new Line2D.Double();
	
	private JPanel view;
	
	public void setView(JPanel v){
		this.view = v;
		centerx = (double)view.getWidth() / 2;
	}

	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
	public void draw(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.translate((double)view.getWidth() / 2, (double)view.getHeight() / 2);
		
		double x = amplitude * Math.sin(frequency * t);
		
		line.setLine(x, 0, centerx, 0);
		subline.setLine(-view.getWidth() / 2, radius, view.getWidth() / 2, radius);
		ball.setFrameFromCenter(x, 0, x - radius, - radius);
		
		g.draw(subline);
		g.draw(line);
		g.fill(ball);
	}
	
	public void move(){
		t += delta;
		view.repaint();
	}
}
