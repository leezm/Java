package Lee.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private JButton center;
	private JButton east;
	private JButton south;
	private JButton west;
	private JButton north;
	
	public MainFrame(String title){
		super(title);
		
		Container c = this.getContentPane();
		
		east = new JButton("EAST");
		south = new JButton("SOUTH");
		west = new JButton("WEST");
		north = new JButton("NORTH");
		center = new JButton("CENTER");
		
		
		ActionHandler handler = new ActionHandler();
		east.addActionListener(handler);
		south.addActionListener(handler);
		west.addActionListener(handler);
		north.addActionListener(handler);
		center.addActionListener(handler);
		
		
		
		c.add(east,BorderLayout.EAST);
		c.add(south,BorderLayout.SOUTH);
		c.add(west,BorderLayout.WEST);
		c.add(north,BorderLayout.NORTH);
		c.add(center);
		
		this.setSize(600,800);
		this.setVisible(true);
	}
	
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == east){
				east.setBackground(new Color(255,0,0));
			}else if(e.getSource() == south){
				south.setBackground(new Color(0,255,0));
			}else if(e.getSource() == west){
				west.setBackground(new Color(0,0,255));
			}else if(e.getSource() == north){
				north.setBackground(new Color(255,255,0));
			}else if(e.getSource() == center){
				center.setBackground(new Color(255,0,255));
			}
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("Test");
	}

}
