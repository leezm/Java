package Lee.com.model;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class MoveObject {

	protected double centerx;
	protected double centery;
	protected final double radius = 15;
	protected double vara;
	protected double varb;
	
	protected JPanel view;
	
	public void setView(JPanel view){
		this.view = view;
	}

	public void setCenter(int x, int y){
		this.centerx = x;
		this.centery = y;
	}
	
	
	
	public double getCenterx() {
		return centerx;
	}

	public double getCentery() {
		return centery;
	}

	public double getVara() {
		return vara;
	}

	public void setVara(double vara) {
		this.vara = vara;
	}

	public double getVarb() {
		return varb;
	}

	public void setVarb(double varb) {
		this.varb = varb;
	}
	
	public abstract void draw(Graphics2D g);
	public abstract void move();
	
}
