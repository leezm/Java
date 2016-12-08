package wang.com.view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import wang.com.model.MoveObject;

public class MoveObjectView extends JPanel {
	private MoveObject moveObject;

	public void setMoveObject(MoveObject moveObject) {
		this.moveObject = moveObject;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2.0f));
		if(moveObject != null){
			moveObject.draw(g2);
		}
	}
	
	
}
