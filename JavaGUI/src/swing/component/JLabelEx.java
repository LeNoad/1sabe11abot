package swing.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelEx extends JFrame {
	
	
	public JLabelEx(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		ImageIcon icon = new ImageIcon("Image/tel.png");
		JLabel lblImg = new JLabel(icon);
		
		
		ImageIcon icon2 = new ImageIcon("Image/java.jpg");
		JLabel lblImg2 = new JLabel(icon2);
		
		ImageIcon icon3 = new ImageIcon("Image/arrow1.png");
		ImageIcon icon4 = new ImageIcon("Image/arrow2.png");
		ImageIcon icon5 = new ImageIcon("Image/arrow3.png");
		
		JButton btn = new JButton("버튼",icon3);
		btn.setVerticalTextPosition(SwingConstants.TOP);
		btn.setRolloverIcon(icon4);
		btn.setPressedIcon(icon5);
		
		add(lblImg);
		add(lblImg2);
		add(btn);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new JLabelEx("JLabel 연습", 680, 600);
	}

}
