package swing.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NoLayoutFrame extends JFrame {
	public NoLayoutFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		setResizable(true);
		
		JButton b1 = new JButton("1");
		b1.setSize(50,25);
		b1.setLocation(10, 10);
		add(b1);
		
		JButton b2 = new JButton("2");
		b2.setSize(50, 25);
		b2.setLocation(10,50);
		add(b2);
		
		JButton b3 = new JButton("3");
		b3.setBounds(100, 100, 100, 20);
		add(b3);
		
		JButton b4 = new JButton("4");
		b4.setBounds(100,50,50,25);
		add(b4);
		
		JButton b5 = new JButton("5");
		b5.setBounds(150,50,50,25);
		add(b5);
		
		JButton b6 = new JButton("6");
		b6.setBounds(300,200,50,25);
		add(b6);

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new NoLayoutFrame("NoLayout", 300, 300);
	}
}
