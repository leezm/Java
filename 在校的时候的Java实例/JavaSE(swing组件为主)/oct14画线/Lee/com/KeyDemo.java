package Lee.com;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KeyDemo extends JPanel {
	private int left = 50;
	private int top = 400;
	private JButton button;
	
	public KeyDemo(){
		this.setLayout(null);
		button = new JButton();
		button.setBounds(left, top, 80, 30);
		add(button);
		KeyHandler handler = new KeyHandler();
		button.addKeyListener(handler);
	}
	private class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				left += 10;
				button.setLocation(left, top);
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				left -= 10;
				button.setLocation(left, top);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
