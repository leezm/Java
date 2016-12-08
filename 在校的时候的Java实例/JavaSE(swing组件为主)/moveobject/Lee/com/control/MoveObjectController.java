package Lee.com.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;

import Lee.com.model.Ball;
import Lee.com.model.Circle;
import Lee.com.model.MoveObject;
import Lee.com.view.MoveObjectView;

public class MoveObjectController {

	private MoveObject moveObject;
	private MoveObjectView moveObjectView;
	
	private CommonSlider varaSlider;
	private CommonSlider varbSlider;
	
	private Timer timer;
	
	private boolean isRun = false;
	
	public MoveObjectController(){
		timer = new Timer(50,
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(moveObject != null){
						moveObject.move();
					}
				}
			
		});
	}
	
	
	public void setMoveObject(MoveObject moveObject) {
		this.moveObject = moveObject;
	}
	public void setMoveObjectView(MoveObjectView moveObjectView) {
		this.moveObjectView = moveObjectView;
		this.moveObjectView.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(isRun){
						timer.stop();
					}else{
						timer.start();
					}
					isRun = !isRun;
				}
			});
	}
	
	public void setCommonSliders(String[] titles, int[] mins, int[] maxs, int[] curs){
		varaSlider.setCommonSlider(titles[0], mins[0], maxs[0], curs[0]);
		varbSlider.setCommonSlider(titles[1], mins[1], maxs[1], curs[1]);
	}
	public JPanel getSouth(String[] titles, int[] mins, int[] maxs, int[] curs){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		varaSlider = new CommonSlider(titles[0], mins[0], maxs[0], curs[0]);
		varbSlider = new CommonSlider(titles[1], mins[1], maxs[1], curs[1]);
		
		varaSlider.setValueChangeHandler(
			new ValueChangeHandler(){

				@Override
				public void valueChanged(double value) {
					// TODO Auto-generated method stub
					moveObject.setVara(value);
				}
				
			});
		
		varbSlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						
						moveObject.setVarb(value);
					}
					
				});
		
		south.add(varaSlider);
		south.add(varbSlider);
		
		return south;
	}
	
	public JPanel getSouth(){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		varaSlider = new CommonSlider("", 0, 100, 0);
		varbSlider = new CommonSlider("", 0, 100, 0);
		
		varaSlider.setValueChangeHandler(
			new ValueChangeHandler(){

				@Override
				public void valueChanged(double value) {
					// TODO Auto-generated method stub
					moveObject.setVara(value);
				}
				
			});
		
		varbSlider.setValueChangeHandler(
				new ValueChangeHandler(){

					@Override
					public void valueChanged(double value) {
						// TODO Auto-generated method stub
						
						moveObject.setVarb(value);
					}
					
				});
		
		south.add(varaSlider);
		south.add(varbSlider);
		
		return south;
	}
	
	public JMenu getMoveObjectMenu(){
		JMenu menu = new JMenu("运动物体");
		JRadioButtonMenuItem moveballItem = new JRadioButtonMenuItem("运动小球", true);
		JRadioButtonMenuItem circlemoveItem = new JRadioButtonMenuItem("圆周运动");
		
		moveObject = new Ball();
		moveObject.setCenter(moveObjectView.getWidth() / 2, moveObjectView.getHeight() / 2);
		
		moveObject.setView(moveObjectView);
		moveObjectView.setMoveObject(moveObject);
		
		varaSlider.setCommonSlider("水平", 0, 40, (int)moveObject.getVara());
		varbSlider.setCommonSlider("竖直", 0, 40, (int)moveObject.getVarb());
		
		moveballItem.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//
					moveObject = new Ball();
					moveObjectView.setMoveObject(moveObject);
					moveObject.setView(moveObjectView);
		
					moveObject.setCenter(moveObjectView.getWidth() / 2, moveObjectView.getHeight() / 2);
					//
					varaSlider.setCommonSlider("水平", 0, 40, (int)moveObject.getVara());
					varbSlider.setCommonSlider("竖直", 0, 40, (int)moveObject.getVarb());
					varaSlider.setScaleFactor(1);
					varbSlider.setScaleFactor(1);
					
				}
				
			});
		moveballItem.setSelected(true);
		
		circlemoveItem.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						moveObject = new Circle();
						varaSlider.setCommonSlider("半径", 50, 280, (int)moveObject.getVara());
						varbSlider.setCommonSlider("转速", 0, 30, (int)moveObject.getVarb());
						
						varbSlider.setScaleFactor(Math.PI / 180);
						
						moveObjectView.setMoveObject(moveObject);
						moveObject.setView(moveObjectView);
					}
					
				});
		
		ButtonGroup group = new ButtonGroup();
		group.add(moveballItem);
		group.add(circlemoveItem);
		
		menu.add(moveballItem);
		menu.add(circlemoveItem);
		
		return menu;
	}
	
}
