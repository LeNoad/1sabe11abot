package swing.swing_Event;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

public class MyMouseEvent extends JFrame implements KeyListener,MouseListener {

	private JLabel lbl_text;
	private Container c;

	public MyMouseEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
//		setLocation(100, 200);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		c = getContentPane();
		c.setLayout(null);
		
		lbl_text = new JLabel("ȫ�浿");
		lbl_text.setSize(50, 25);
		c.add(lbl_text);
		c.addKeyListener(this);
		c.addMouseListener(this);
		
		setVisible(true);
		c.requestFocus();

	}
	public static void main(String[] args) {
		new MyMouseEvent("MyMouseEvent", 300, 300);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode){
			case KeyEvent.VK_UP:
				lbl_text.setLocation(lbl_text.getX(),lbl_text.getY()-5);
				break;
			case KeyEvent.VK_DOWN:
				lbl_text.setLocation(lbl_text.getX(),lbl_text.getY()+5);
				break;
			case KeyEvent.VK_RIGHT:
				lbl_text.setLocation(lbl_text.getX()+5,lbl_text.getY());
				break;
			case KeyEvent.VK_LEFT:
				lbl_text.setLocation(lbl_text.getX()-5,lbl_text.getY());
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		lbl_text.setLocation(e.getX(),e.getY());
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
