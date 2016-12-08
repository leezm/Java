package wang.com.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


import wang.com.model.SpringVibrator;
import wang.com.view.SpringVibratorView;

public class SpringVibratorController {

	private SpringVibrator ball;
	private SpringVibratorView view;
	
	private CommonSlider amplitudeSlider;
	private CommonSlider frequencySlider;
	
	private Timer timer;
	
	public SpringVibratorController(){
		timer = new Timer(50,
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(ball != null){
						ball.move();
					}
				}
			
		});
	}
	
	public void setSpringVibrator(SpringVibrator ball){
		this.ball = ball;
	}
	public void setView(SpringVibratorView view){
		this.view = view;
		this.view.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					timer.start();
				}
			});
	}
	
	public JPanel getSouth(){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		
		amplitudeSlider = new CommonSlider("·ù¶È", 50, 240, (int)ball.getAmplitude());
		frequencySlider = new CommonSlider("ÆµÂÊ", 0, 40, (int)ball.getFrequency());
		
		south.add(amplitudeSlider);
		south.add(frequencySlider);
		
		amplitudeSlider.setValueChangeHandler(
			new ValueChangeHandler(){

				@Override
				public void valueChanged(double value) {
					// TODO Auto-generated method stub
					ball.setAmplitude(value);
				}
				
			});
		frequencySlider.setValueChangeHandler(
			new ValueChangeHandler(){

				@Override
				public void valueChanged(double value) {
					// TODO Auto-generated method stub
					ball.setFrequency(value);
				}
				
			});
		
		return south;
	}
}
