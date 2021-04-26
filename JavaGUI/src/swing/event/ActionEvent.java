package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEvent extends JFrame implements ActionListener {
	JButton btn, btn2;
	public ActionEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		
		btn = new JButton("Action");
		btn.addActionListener(this);
		add(btn);
		
		btn2 = new JButton("자바");
		btn2.addActionListener(this);
		add(btn2);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new ActionEvent("액션 이벤트 연습", 300, 200);
	}
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btn) {
			System.out.println(btn.getText());
		} else if(obj == btn2) {
			System.out.println(btn2.getText());
		}
	}
}