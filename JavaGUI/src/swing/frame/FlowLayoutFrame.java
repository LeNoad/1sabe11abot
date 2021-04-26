package swing.frame;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
	public FlowLayoutFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		setResizable(false);
		JButton b1 = new JButton("A");
		JButton b2 = new JButton("B");
		JButton b3 = new JButton("C");
		JButton b4 = new JButton("D");
		JButton b5 = new JButton("E");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlowLayoutFrame("FlowLayout", 300, 300);
	}
}
