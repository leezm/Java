package wang.com.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class StringTipPane extends JPanel {

	private JLabel label;
	public StringTipPane(String tip){
		label = new JLabel(tip);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("ºÚÌå", Font.BOLD, 20));
		setLayout(new GridLayout(1, 1));
		add(label);
	}
	
	public void setText(String tip){
		label.setText(tip);
	}
}
