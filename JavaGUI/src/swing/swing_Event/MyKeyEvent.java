package swing.swing_Event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyKeyEvent extends JFrame implements ActionListener{

	private JButton btn1;
	private JButton btn2;

	public MyKeyEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
//		setLocation(100, 200);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		
		btn1 = new JButton("ok");
		add(btn1);
		btn1.addActionListener(this);
		btn2 = new JButton("2");
		add(btn2);
		btn2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MyKeyEvent("My Event", 300, 300);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==btn1) {
			System.out.println(1);
		} else if (obj==btn2) {
			System.out.println(2);
		}
	}

}
