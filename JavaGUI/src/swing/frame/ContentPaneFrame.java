package swing.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneFrame extends JFrame{
	public ContentPaneFrame(String title, int width, int height){
		setTitle(title);
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		setLayout(new FlowLayout());
		
		Container c = getContentPane();
		c.setBackground(Color.ORANGE);
		
		JButton b1 = new JButton("OK");
		b1.setBackground(Color.RED);
		add(b1);
		
		JButton b2 = new JButton("Cancle");
		add(b2);
		
		JButton b3 = new JButton("Ignore");
		add(b3);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ContentPaneFrame("ContentPaneFrame", 300, 200);
	}

}
