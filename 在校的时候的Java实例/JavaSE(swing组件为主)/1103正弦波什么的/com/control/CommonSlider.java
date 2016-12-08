package wang.com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CommonSlider extends JPanel {
	private JLabel label;
	private JSlider slider;
	private JTextField field;
	
	private ValueChangeHandler handler = null;
	
	private double scaleFactor = 1;
	
	public CommonSlider(){
		this("", 0, 100, 0);
	}
	public CommonSlider(String title, int min, int max, int cur){
		Box box = Box.createHorizontalBox();
		
		label = new JLabel(title);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		slider = new JSlider(min, max, cur);
		field = new JTextField(String.valueOf(slider.getValue()), 8);
		
		box.add(label);
		box.add(Box.createHorizontalStrut(5));
		box.add(slider);
		box.add(Box.createHorizontalStrut(5));
		box.add(field);
		
		add(box);
		
		slider.addChangeListener(
			new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int value = slider.getValue();
					consistency(value);
				}
				
			});
		field.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int value = Integer.parseInt(field.getText());
					consistency(value);
				}
				
			});
	}
	
	public void setScaleFactor(double scaleFactor){
		this.scaleFactor = scaleFactor;
	}
	
	public void setCommonSlider(String title, int min, int max, int cur){
		label.setText(title);
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setValue(cur);
		field.setText(String.valueOf(slider.getValue()));
	}
	
	private void consistency(int value){
		slider.setValue(value);
		int v = slider.getValue();
		field.setText(String.valueOf(v));
		if(handler != null){
			handler.valueChanged(v * scaleFactor);
		}
	}
	
	public void setValueChangeHandler(ValueChangeHandler handler){
		this.handler = handler;
	}
}
