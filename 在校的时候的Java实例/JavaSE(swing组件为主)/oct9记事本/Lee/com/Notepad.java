package Lee.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;

public class Notepad extends JFrame {
	private JTextArea textArea = new JTextArea();
	private String filename = null;
	private String title1 = ("无标题-记事本");
	public Notepad(String title){
		super(title);
		//菜单栏
		JMenuBar bar = new JMenuBar();
		
		//文件菜单
		JMenu fileMenu = new JMenu("文件(F)");
		JMenuItem newItem = new JMenuItem("新建(N)");
		JMenuItem saveItem = new JMenuItem("保存(S)");
		JMenuItem saveAsItem = new JMenuItem("另存为(A)...");
		JMenuItem openItem = new JMenuItem("打开(O)...");
		JMenuItem exitItem = new JMenuItem("退出(E)");
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(new JSeparator());
		fileMenu.add(exitItem);
		
		//快捷键设置
		fileMenu.setMnemonic('F');
		newItem.setMnemonic('N');
		//加速键
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		saveItem.setMnemonic('S');
		//加速键
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		saveAsItem.setMnemonic('A');
		//加速键
		saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		openItem.setMnemonic('O');
		//加速键
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		exitItem.setMnemonic('E');
		//加速键
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		
		bar.add(fileMenu);
		
		this.setJMenuBar(bar);
		//滚动条
		this.getContentPane().add(new JScrollPane(textArea));
		
		//打开
		openItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 JFileChooser chooser = new JFileChooser();
						    FileNameExtensionFilter filter = new FileNameExtensionFilter(
						        "文本文档", "jpg", "gif");
						    chooser.setFileFilter(filter);
						    int returnVal = chooser.showOpenDialog(getParent());
						    if(returnVal == JFileChooser.APPROVE_OPTION) {
						       System.out.println("You chose to open this file: " +
						            chooser.getSelectedFile().getName());
						    }
						JFileChooser fileChooser = new JFileChooser();
						if(fileChooser.showOpenDialog(Notepad.this) == JFileChooser.APPROVE_OPTION){
									try{
										File file = fileChooser.getSelectedFile();
										filename = file.getAbsolutePath();
										
										InputStream is = new FileInputStream(filename);
										int len = is.available();
										byte[] bs = new byte[len];
										String msg = new String(bs);
										textArea.setText(msg);
										is.close();
									}catch(Exception ex){
										ex.printStackTrace();
									}
							}
							int index = filename.lastIndexOf('\\');
							String title1 = filename.substring(index+1);
							setTitle(title1 + '-'+"记事本");
				}
		});
		
		//保存
		saveItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(filename == null){
							JFileChooser fileChooser = new JFileChooser();
							if(fileChooser.showSaveDialog(Notepad.this) == JFileChooser.APPROVE_OPTION){
								try{
									File file = fileChooser.getSelectedFile();
									filename = file.getAbsolutePath();
									String msg = textArea.getText();
									OutputStream os = new FileOutputStream(filename);
									os.write(msg.getBytes());
									os.close();
									int index = filename.lastIndexOf('\\');
									String title1 = filename.substring(index+1);
									setTitle(title1 + '-'+"记事本");
								}catch(Exception ex){
									ex.printStackTrace();
								}       		
							}
						}else{
							try{
								String msg = textArea.getText();
								OutputStream os = new FileOutputStream(filename);
								os.write(msg.getBytes());
							}catch(IOException ioe){
								ioe.printStackTrace();
							}
						}
							System.out.println(filename);
				}
		});
		
		//另存为
		saveAsItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFileChooser fileChooser = new JFileChooser();
						JFileChooser chooser = new JFileChooser();
					    FileNameExtensionFilter filter = new FileNameExtensionFilter(
					       "文本文档(*.txt)", "txt");
					    chooser.setFileFilter(filter);
					    int returnVal = chooser.showSaveDialog(getParent());
						if(returnVal == JFileChooser.APPROVE_OPTION){
							System.out.println("You chose to open this file: " +
						            chooser.getSelectedFile().getName());
						}
						if(fileChooser.showSaveDialog(Notepad.this) == JFileChooser.APPROVE_OPTION){
									try{
										File file = fileChooser.getSelectedFile();
										filename = file.getAbsolutePath();
										String msg = textArea.getText();
										OutputStream os = new FileOutputStream(filename);
										os.write(msg.getBytes());
										os.close();
										int index = filename.lastIndexOf('\\');
										String title1 = filename.substring(index+1);
										setTitle(title1 + '-'+"记事本");
									}catch(Exception ex){
										ex.printStackTrace();
								}
						}	
				}
		});
		
		//新建
		newItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						textArea.setText("");
						filename = null;
						title1 = new String("无标题");
						 setTitle(title1 + '-'+"记事本");
					}
			
		});
		exitItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
			
		});
		
		//编辑
		JMenu compileMenu = new JMenu("编辑");
		JMenuItem cutItem = new JMenuItem("剪切");
		JMenuItem copyItem = new JMenuItem("复制");		
		JMenuItem pasteItem = new JMenuItem("粘贴");
		JMenuItem deleteItem = new JMenuItem("删除");
		JMenuItem findItem = new JMenuItem("查找...");
		JMenuItem findnextItem = new JMenuItem("查找下一个");
		JMenuItem replaceItem = new JMenuItem("替换...");
		
		compileMenu.add(cutItem);
		compileMenu.add(copyItem);
		compileMenu.add(pasteItem);
		compileMenu.add(deleteItem);
		compileMenu.add(new JSeparator());
		compileMenu.add(findItem);
		compileMenu.add(findnextItem);
		compileMenu.add(replaceItem);
		bar.add(compileMenu);
		
		//格式
		JMenu formMenu = new JMenu("格式");
		JMenuItem feedItem = new JMenuItem("自动换行");
		JMenuItem scriptItem = new JMenuItem("字体");
		
		formMenu.add(feedItem);
		formMenu.add(scriptItem);
		bar.add(formMenu);
		
		//帮助
		JMenu helpMenu = new JMenu("帮助");
		JMenuItem aboutItem = new JMenuItem("关于记事本");
		
		helpMenu.add(aboutItem);
		bar.add(helpMenu);
		aboutItem.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null,"");
					}
			
		});
		
		//文本框尺寸
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad("记事本");
	}

}
