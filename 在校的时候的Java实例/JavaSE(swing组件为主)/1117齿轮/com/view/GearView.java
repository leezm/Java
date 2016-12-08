package wang.com.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import wang.com.model.Gear;

public class GearView extends JPanel {
	private ArrayList<Gear> gears = new ArrayList<Gear>();
	private Timer timer;
	private boolean isRun = false;
	private double startx;
	private double starty;
	private double endx;
	private double endy;
	public GearView(){
		timer = new Timer(50, 
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int index = 0; index < gears.size(); index++){
						gears.get(index).move();
					}
				}
		});
		this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent e){
					
					for(int index = 0; index < gears.size(); index++){
						Gear gear = gears.get(index);
						if(gear.isSelected()){
							endx = e.getX();
							endy = e.getY();
							gear.transform(endx - startx, endy - starty);
							startx = endx;
							starty = endy;
						}
					}
					
				}
			});
		this.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					for(int index = 0; index < gears.size(); index++){
						Gear gear = gears.get(index);
						boolean selected = gear.isSelected();
						if(gear.getBounds().contains(e.getX(), e.getY())){
							gear.setSelected(!selected);
						}
					}
					
				}
				public void mousePressed(MouseEvent e){
					startx = e.getX();
					starty = e.getY();
				}
				public void mouseReleased(MouseEvent e){
					startx = endx = 0;
					starty = endy = 0;
				}
			});
	}
	public void setGear(Gear gear){
		gears.add(gear);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for(int index = 0; index < gears.size(); index++){
			gears.get(index).draw(g2);
		}
	}
	
	public JPanel getButtonsPane(){
		JPanel pane = new JPanel();
		final JButton start = new JButton("开始");
		final JButton stop = new JButton("停止");
		final JButton create = new JButton("创建");
		
		start.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					timer.start();
					start.setEnabled(false);
					stop.setEnabled(true);
					create.setEnabled(false);
				}
				
			});
		
		stop.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					timer.stop();
					start.setEnabled(true);
					stop.setEnabled(false);
					create.setEnabled(true);
				}
				
			});
		
		
		create.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Gear gear = new Gear(GearView.this);
					gears.add(gear);
					repaint();
				}
				
			});
		stop.setEnabled(false);
		
		add(start);
		add(stop);
		add(create);
		return pane;
	}
	
}
