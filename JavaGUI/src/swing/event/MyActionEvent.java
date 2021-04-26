package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyActionEvent extends JFrame {
	public MyActionEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		add(btn);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyActionEvent("액션 이벤트 연습", 300, 200);
	}
}
class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		String n = b.getText();
		if(n.equals("Action")) {
			b.setText("액션");
		} else {
			b.setText("Action");
		}
	}
	
}