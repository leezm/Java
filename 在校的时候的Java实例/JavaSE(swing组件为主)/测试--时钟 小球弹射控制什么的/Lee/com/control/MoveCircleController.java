package Lee.com.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Lee.com.model.MoveCircle;
import Lee.com.view.MoveCircleView;


public class MoveCircleController {
	private MoveCircle circle;
	private MoveCircleView view;
	private CommonSlider radiusSlider;
	private CommonSlider angularVelocitySlider;
	
	private Timer timer;
	public MoveCircleController(){
		timer = new Timer(50, 
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					circle.move();
				}
			
		});
		timer.start();
	}
	
	
	public void setMoveCircleView(MoveCircleView v, MoveCircle c){
		this.view = v;
		this.circle = c;
	}
	
	public JPanel getControllerView(){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		
		radiusSlider = new CommonSlider("°ë¾¶",30, 290, (int)circle.getLargeRadius());
		radiusSlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						circle.setLargeRadius(value);
					}
					
				});
		
		angularVelocitySlider = new CommonSlider("×ªËÙ", 0, 100, (int)(circle.getDelta() * 200));
		angularVelocitySlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						circle.setDelta(value / 200);
					}
					
				});
		
		south.add(radiusSlider);
		south.add(angularVelocitySlider);
		return south;
	}
}
