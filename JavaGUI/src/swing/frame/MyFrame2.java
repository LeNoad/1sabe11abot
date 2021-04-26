package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {
	public MyFrame2(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 40));
		
		JButton b1 = new JButton("11111");
		add(b1);
		
		JButton b2 = new JButton("2");
		add(b2);
		
		JButton b3 = new JButton("3");
		add(b3);
		
		JButton b4 = new JButton("4");
		add(b4);
		
		JButton b5 = new JButton("5");
		add(b5);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame2("FlowLayout«¡∑π¿”", 300, 200);
	}
}
