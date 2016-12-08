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
	private ValueChangeHandler valueChangeHandler;

	private JLabel label;
	private JSlider slider;
	private JTextField field;
	
	public CommonSlider(){
		this("",0,100,0);
	}
	public CommonSlider(String title, int min, int max, int current){
		label = new JLabel(title);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		slider = new JSlider(min, max, current);
		field = new JTextField(String.valueOf(current), 8);
		
		Box box = Box.createHorizontalBox();
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
	
	private void consistency(int value){
		slider.setValue(value);
		int v = slider.getValue();
		field.setText(String.valueOf(v));
		if(valueChangeHandler != null){
			valueChangeHandler.valueChanged(v);
		}
	}
	
	public void setValueChangeHandler(ValueChangeHandler valueChangeHandler) {
		this.valueChangeHandler = valueChangeHandler;
	}
	
	public void setEnabled(boolean b){
		slider.setEnabled(b);
		field.setEnabled(b);
	}
	
	public boolean isEnabled(){
		return slider.isEnabled();
	}
	
	public void setValue(int value){
		slider.setValue(value);
		field.setText(String.valueOf(slider.getValue()));
	}
	
	public int getValue(){
		return slider.getValue();
	}
}
