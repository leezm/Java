package Lee.com;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawPane extends JPanel {
		private int left = 100;
		private int top =  50;
		private final int width = 200;
		private final int height = 150;
		private int offsetx;
		private int offsety;
		private boolean is = false;
		
		public DrawPane(){
			super();
			this.addMouseListener(new MouseHandler());
			this.addMouseMotionListener(new MotionMouseHandler());
		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.fillRect(left, top, width, height);
		}
		
		private class MouseHandler implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				if(left <= x && x <=left + width && top <= y && y <= top + height){
					offsetx = x - left;
					offsety = y - top;
					is = true;
				}else{
					is = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
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
			
		}
		
		private class MotionMouseHandler implements MouseMotionListener{

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				if(is){left = x - offsetx;
				top = y - offsety;
				repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
}
