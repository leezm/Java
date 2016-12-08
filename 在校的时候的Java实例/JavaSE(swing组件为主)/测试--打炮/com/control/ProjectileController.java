package wang.com.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import wang.com.model.Projectile;
import wang.com.view.ProjectileView;

public class ProjectileController {
	private Projectile ball;
	private ProjectileView view;
	
	private CommonSlider velocitySlider;
	private CommonSlider degreeSlider;
	
	private Timer timer;
	
	public ProjectileController(){
		timer = new Timer(50,
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(ball != null){
						ball.move();
						if(ball.isReset()){
							ball.reset();
							velocitySlider.setValue(0);
							degreeSlider.setValue(0);
							velocitySlider.setEnabled(false);
							degreeSlider.setEnabled(true);
							timer.stop();
						}
					}
				}
			
		});
	}
	public void setView(ProjectileView v){
		view = v;
		view.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					velocitySlider.setEnabled(false);
					degreeSlider.setEnabled(false);
					timer.start();
				}
			});
	}
	public void setProjectile(Projectile ball){
		this.ball = ball;
	}
	
	public JPanel getSouth(){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		velocitySlider = new CommonSlider("³õËÙ", 0, 120, (int)ball.getVelocity());
		velocitySlider.setEnabled(false);
		degreeSlider = new CommonSlider("½Ç¶È", 0, 90, (int)(ball.getAlpha() * 180 / Math.PI));
		
		south.add(velocitySlider);
		south.add(degreeSlider);
		
		velocitySlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						ball.setVelocity(value);
					}
					
				});
		degreeSlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						if(velocitySlider.isEnabled() == false){
							velocitySlider.setEnabled(true);
						}
						ball.setAlpha(value * Math.PI / 180);
					}
					
				});
		
		return south;
	}
}
