package Lee.com.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TipPanel extends JPanel {
	private ClockView clockView;
	private StringTipPanel sTipPanel;
	
	public TipPanel(String text){
		this.setLayout(new BorderLayout());
		clockView = new ClockView();
		sTipPanel = new StringTipPanel(text);
		add(clockView, BorderLayout.WEST);
		add(sTipPanel, BorderLayout.CENTER);
	}
	
	public void move(){
		clockView.move();
	}
	
	public void setText(String text){
		sTipPanel.setText(text);
	}
}
