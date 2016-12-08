package Lee.com.view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Lee.com.model.MoveCircle;

public class MoveCircleView extends JPanel {

	private MoveCircle moveCircle;

	public void setMoveCircle(MoveCircle moveCircle){
		this.moveCircle = moveCircle;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2.0f));
		if(moveCircle == null){
			return;
		}
		moveCircle.setCenterx(this.getWidth() / 2);
		moveCircle.setCentery(this.getHeight() / 2);
		
		moveCircle.draw(g2);
	}
}
