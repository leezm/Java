package Lee.com;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MouseDemo extends JPanel {
	
	private int fromx;
	private int fromy;
	private int tox;
	private int toy;
	
	public MouseDemo(){
		MouseHandler handler = new MouseHandler();
		MouseMotionHandler mHandler = new MouseMotionHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(mHandler);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawLine(fromx, fromy, tox, toy);
	}
	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			fromx = e.getX();
			fromy = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			tox = e.getX();
			toy = e.getY();
			repaint();
		}
	}
	private class MouseMotionHandler implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			tox = e.getX();
			toy = e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
