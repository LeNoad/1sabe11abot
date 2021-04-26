package swing.swing_Event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyEvent extends JFrame implements KeyListener{

	private JPanel panBase;
	
	private JLabel lbl_code;
	private JLabel lbl_char;
	private JLabel lbl_text;
	
	public MyEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panBase = new JPanel();
		panBase.setBackground(Color.YELLOW);
		panBase.addKeyListener(this);
		add(panBase);
		
		lbl_code = new JLabel("getKeyCode");
		lbl_code.setOpaque(true);
		lbl_code.setBackground(Color.CYAN);
		
		lbl_char = new JLabel("getKeyChar");
		lbl_char.setOpaque(true);
		lbl_char.setBackground(Color.CYAN);
		
		lbl_text = new JLabel("getKeyText");
		lbl_text.setOpaque(true);
		lbl_text.setBackground(Color.CYAN);
		
		panBase.add(lbl_code);
		panBase.add(lbl_char);
		panBase.add(lbl_text);
		
		setVisible(true);
		panBase.requestFocus();
	}
	
	public static void main(String[] args) {
		new MyEvent("MyKeyEvent", 300, 300);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		lbl_code.setText(keyCode+"");
		char Keychar = e.getKeyChar();
		lbl_char.setText(Keychar+"");
		String KeyText = KeyEvent.getKeyText(keyCode);
		lbl_text.setText(KeyText);
		
		if(keyCode == KeyEvent.VK_UP) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
