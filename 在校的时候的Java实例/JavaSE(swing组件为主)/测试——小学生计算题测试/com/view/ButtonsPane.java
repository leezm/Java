package wang.com.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPane extends JPanel {
	private int size = 2;
	private JButton[] buttons;
	public ButtonsPane(){
		this(2);
	}
	
	public ButtonsPane(int amt){
		size = amt;
		setLayout(new GridLayout(1, size, 1, 1));
		
		buttons = new JButton[size];
		for(int i = 0; i < size; i++){
			buttons[i] = new JButton();
			add(buttons[i]);
		}
	}
	
	public void setTitles(String[] titles){
		if(titles.length != size){
			throw new RuntimeException("数组长度不匹配");
		}
		for(int i = 0; i < size; i++){
			buttons[i].setText(titles[i]);
		}
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
}
