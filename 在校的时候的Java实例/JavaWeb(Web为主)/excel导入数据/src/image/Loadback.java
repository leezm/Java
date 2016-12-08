package image;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Loadback extends JPanel {
	private Image img;
	public Loadback() {
		try{
			img = ImageIO.read(new File("image/fo.jpg"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, 0, 0, 450, 400, this);
	}
	
}
