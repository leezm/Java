/* package Lee.com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.LinearGradientPaint;

import javax.swing.JPanel;

public class DrawPane2 extends JPanel {
	
	public DrawPane2(){
		super();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	//sinÍ¼Ïñ	
		int y0 = this.getHeight() / 2;
		int x0 = this.getWidth() / 2;
		int a = 200;
		g.drawLine(0, y0, getWidth(), y0);
		g.drawLine(x0, 0, x0,getHeight());
		
		for(int x = 0; x < this.getWidth(); x += 2){
			g.drawLine(x, y0 - (int)(a *Math.sin((double)(x - x0) / 20)), x + 2, y0 - (int)(a *Math.sin((double)(x - x0 + 2) / 20)));
		}
		for(int x = 0; x > 0; x -= 2){
			g.drawLine(x, y0 - (int)(a *Math.sin((double)x / 20)), x + 2, y0 - (int)(a *Math.sin((double)(x+2) / 20)));
		} 
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(3.0f));
		
		Paint paint = new LinearGradientPaint();
		g2.setPaint(Color.red);
				
		Ellipse2D elli = new Ellipse2D.Double(100,100,300,300);
		
		g2.draw(elli);
		
	}  */
	package Lee.com;

	import java.awt.BasicStroke;
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.LayoutManager;
	import java.awt.Paint;
	import java.awt.RenderingHints;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseMotionListener;
	import java.awt.geom.Ellipse2D;
	import java.awt.geom.Rectangle2D;
	import java.awt.LinearGradientPaint;
	import java.awt.RadialGradientPaint;
	import javax.swing.JPanel;

	public class DrawPane2 extends JPanel {
		
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//	g2.setStroke(new BasicStroke(3.0f));
			float[] f = {0.0f,0.2f,0.4f,1.0f};
			Color[] colors = {Color.blue,Color.white,Color.yellow,Color.red};
			Paint paint = new RadialGradientPaint(250,250,150,f,colors);
			
			g2.setPaint(paint);
			
			Ellipse2D elli = new Ellipse2D.Double(100,100,300,300);
			
			g2.fill(elli);
			
		}
		
		
		
	}

	

