package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEvent extends JFrame implements ActionListener, MouseListener {
	JButton btn, btn2;
	public MouseEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		
		btn = new JButton("마우스 이벤트 테스트 버튼");
		btn.addMouseListener(this);
		add(btn);
		
		btn2 = new JButton("Test");
		btn2.addMouseListener(this);
		add(btn2);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseEvent("마우스 이벤트 연습", 300, 200);
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.RED);
		} else if(obj == btn2) {
			btn2.setBackground(Color.YELLOW);
		}
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.YELLOW);
		} else if(obj == btn2) {
			btn2.setBackground(Color.RED);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}