package wang.com.model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends MoveObject{
	@Override
	
	//vara为水平速率，varb竖直速率
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fill(ball);
	}

	@Override
	public void setVara(double vara) {
		// TODO Auto-generated method stub
		if(this.vara < 0){
			this.vara = -vara;
		}else{
			this.vara = vara;
		}
	}

	@Override
	public void setVarb(double varb) {
		// TODO Auto-generated method stub
		if(this.varb < 0){
			this.varb = -varb;
		}else{
			this.varb = varb;
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		centerx += this.vara;
		centery += this.varb;
		if(centerx <= radius){
			centerx = radius;
			vara = -vara;
		}
		if(centerx >= view.getWidth() - radius){
			centerx = view.getWidth() - radius;
			vara = -vara;
		}
		if(centery <= radius){
			centery = radius;
			varb = -varb;
		}
		if(centery >= view.getHeight() - radius){
			centery = view.getHeight() - radius;
			varb = -varb;
		}
		ball.setFrameFromCenter(centerx, centery, centerx - radius, centery - radius);
		view.repaint();
	}
	
	

}
