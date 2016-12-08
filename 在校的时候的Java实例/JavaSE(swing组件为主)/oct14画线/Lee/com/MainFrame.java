package Lee.com;



import java.awt.Container;

import javax.swing.JFrame;




public class MainFrame extends JFrame {
	
	
	public MainFrame(){
		MouseDemo view = new MouseDemo();
	//	KeyDemo view = new KeyDemo();
		Container  c = this.getContentPane();
		c.add(view);
		
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args){
		new MainFrame();
		
	}
}
