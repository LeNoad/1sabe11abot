package swing.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CommonAPI extends JFrame implements ActionListener{
	
	private JButton b1, b2;
	
	public CommonAPI(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());
		
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(this);
		
		b2 = new JButton("모양 정보");
		b2.setBackground(Color.YELLOW);
		b2.setForeground(Color.MAGENTA);
		b2.setFont(new Font("궁서체", Font.ITALIC, 20));
		b2.addActionListener(this);
		add(b1);
		add(b2);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CommonAPI("공통 기능 확인", 200, 200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == b1) {
			System.out.println("위치 : "+b1.getX()+ ", "+b1.getY());
			System.out.println("크기 : "+b1.getWidth()+", "+b1.getHeight());
		} else if(obj == b2) {
			System.out.println("폰트 : "+b2.getFont());
			System.out.println("글자색 : "+b2.getForeground());
		}
	}
}
