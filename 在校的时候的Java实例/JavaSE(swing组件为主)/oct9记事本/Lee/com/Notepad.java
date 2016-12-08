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
	private String title1 = ("�ޱ���-���±�");
	public Notepad(String title){
		super(title);
		//�˵���
		JMenuBar bar = new JMenuBar();
		
		//�ļ��˵�
		JMenu fileMenu = new JMenu("�ļ�(F)");
		JMenuItem newItem = new JMenuItem("�½�(N)");
		JMenuItem saveItem = new JMenuItem("����(S)");
		JMenuItem saveAsItem = new JMenuItem("���Ϊ(A)...");
		JMenuItem openItem = new JMenuItem("��(O)...");
		JMenuItem exitItem = new JMenuItem("�˳�(E)");
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(new JSeparator());
		fileMenu.add(exitItem);
		
		//��ݼ�����
		fileMenu.setMnemonic('F');
		newItem.setMnemonic('N');
		//���ټ�
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		saveItem.setMnemonic('S');
		//���ټ�
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		saveAsItem.setMnemonic('A');
		//���ټ�
		saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		openItem.setMnemonic('O');
		//���ټ�
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		exitItem.setMnemonic('E');
		//���ټ�
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		
		bar.add(fileMenu);
		
		this.setJMenuBar(bar);
		//������
		this.getContentPane().add(new JScrollPane(textArea));
		
		//��
		openItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 JFileChooser chooser = new JFileChooser();
						    FileNameExtensionFilter filter = new FileNameExtensionFilter(
						        "�ı��ĵ�", "jpg", "gif");
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
							setTitle(title1 + '-'+"���±�");
				}
		});
		
		//����
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
									setTitle(title1 + '-'+"���±�");
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
		
		//���Ϊ
		saveAsItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFileChooser fileChooser = new JFileChooser();
						JFileChooser chooser = new JFileChooser();
					    FileNameExtensionFilter filter = new FileNameExtensionFilter(
					       "�ı��ĵ�(*.txt)", "txt");
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
										setTitle(title1 + '-'+"���±�");
									}catch(Exception ex){
										ex.printStackTrace();
								}
						}	
				}
		});
		
		//�½�
		newItem.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						textArea.setText("");
						filename = null;
						title1 = new String("�ޱ���");
						 setTitle(title1 + '-'+"���±�");
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
		
		//�༭
		JMenu compileMenu = new JMenu("�༭");
		JMenuItem cutItem = new JMenuItem("����");
		JMenuItem copyItem = new JMenuItem("����");		
		JMenuItem pasteItem = new JMenuItem("ճ��");
		JMenuItem deleteItem = new JMenuItem("ɾ��");
		JMenuItem findItem = new JMenuItem("����...");
		JMenuItem findnextItem = new JMenuItem("������һ��");
		JMenuItem replaceItem = new JMenuItem("�滻...");
		
		compileMenu.add(cutItem);
		compileMenu.add(copyItem);
		compileMenu.add(pasteItem);
		compileMenu.add(deleteItem);
		compileMenu.add(new JSeparator());
		compileMenu.add(findItem);
		compileMenu.add(findnextItem);
		compileMenu.add(replaceItem);
		bar.add(compileMenu);
		
		//��ʽ
		JMenu formMenu = new JMenu("��ʽ");
		JMenuItem feedItem = new JMenuItem("�Զ�����");
		JMenuItem scriptItem = new JMenuItem("����");
		
		formMenu.add(feedItem);
		formMenu.add(scriptItem);
		bar.add(formMenu);
		
		//����
		JMenu helpMenu = new JMenu("����");
		JMenuItem aboutItem = new JMenuItem("���ڼ��±�");
		
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
		
		//�ı���ߴ�
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad("���±�");
	}

}
