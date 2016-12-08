package Lee.com.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StringTipPanel extends JPanel {

	private JLabel label;
	
	public StringTipPanel(String text){
		this.setLayout(new GridLayout(1,1));
		label = new JLabel(text);
		label.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
	}
	
	public void setText(String text){
		label.setText(text);
	}
}
