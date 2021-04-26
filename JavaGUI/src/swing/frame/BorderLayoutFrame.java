package swing.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame extends JFrame {
	public BorderLayoutFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout(10,20));
		setResizable(true);
		
		JButton b1 = new JButton("111111");
		add(b1,BorderLayout.NORTH);
		
		JButton b2 = new JButton("2");
		add(b2,BorderLayout.SOUTH);
		
		JButton b3 = new JButton("3");
		add(b3,BorderLayout.EAST);
		
		JButton b4 = new JButton("4");
		add(b4,BorderLayout.WEST);
		
		JButton b5 = new JButton("5");
		add(b5,BorderLayout.CENTER);

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutFrame("BorderLayout «¡∑π¿”", 300, 300);
	}
}
