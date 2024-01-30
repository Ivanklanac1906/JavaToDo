package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame{

	private TitleBar title;
	private List list;
	private ButtonPanel btnpanel;
	
	private JButton addTask;
	private JButton clear;
	
	//konstruktor
	AppFrame(){
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		title = new TitleBar();
		list = new List();
		btnpanel = new ButtonPanel();
		this.add(title,BorderLayout.NORTH);
		this.add(btnpanel,BorderLayout.SOUTH);
		
		this.add(list,BorderLayout.CENTER);
		
		addTask = btnpanel.getNewTask();
		clear = btnpanel.getClear();
		
		addListeners();
		
	}
	
	public void addListeners() {
		addTask.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			Task task = new Task ();
			list.add(task);
			list.updateNumbers();
			
			task.getDone().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				task.changeState();
				revalidate();
			}
			});
			revalidate();
		}
		});
	}
}
