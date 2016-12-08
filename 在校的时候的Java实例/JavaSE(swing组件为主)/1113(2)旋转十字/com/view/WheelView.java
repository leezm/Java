package wang.com.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import wang.com.model.Wheel;

public class WheelView extends JPanel {
	private Wheel wheel;
	
	public void setWheel(Wheel wl){
		this.wheel = wl;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(wheel != null){
			wheel.draw(g2);
		}
	}
	
	
}
