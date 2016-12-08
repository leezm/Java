package zhang;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class GameController {
	private Game game = null;
	private GameView view;
	private ArrayList<Game> arrays;
	
	private JLabel label;
	private JRadioButton blackRadio;
	private JRadioButton whiteRadio;
	

	public void setView(Game g, GameView v) {
		this.view = v;
		
		view.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				game = new Game(view,e.getX(),e.getY());
				view.addGame(game);
				for(int index = 0; index < arrays.size(); index++){
					arrays.get(index).move();
				}
				
				view.repaint();
			}
			
		});
		arrays = view.getArrays();
	}
	
	
	
	public JPanel getSouth(){
		JPanel south = new JPanel();
		label = new JLabel("Ë­ÏÈ³öÆå£¿");
		blackRadio = new JRadioButton("ºÚÆå");
		whiteRadio = new JRadioButton("°×Æå");
		
		ButtonGroup group = new ButtonGroup();
		group.add(blackRadio);
		group.add(whiteRadio);
		blackRadio.setSelected(true);
		
		south.add(label);
		south.add(blackRadio);
		south.add(whiteRadio);
		
		if(blackRadio.isSelected()){
			view.setMark(false);
		}
		if(whiteRadio.isSelected()){
			view.setMark(true);
		}
		
		return south;
	}
	
	

}
