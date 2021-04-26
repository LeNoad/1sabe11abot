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
		
		b1 = new JButton("��ġ�� ũ�� ����");
		b1.addActionListener(this);
		
		b2 = new JButton("��� ����");
		b2.setBackground(Color.YELLOW);
		b2.setForeground(Color.MAGENTA);
		b2.setFont(new Font("�ü�ü", Font.ITALIC, 20));
		b2.addActionListener(this);
		add(b1);
		add(b2);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CommonAPI("���� ��� Ȯ��", 200, 200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == b1) {
			System.out.println("��ġ : "+b1.getX()+ ", "+b1.getY());
			System.out.println("ũ�� : "+b1.getWidth()+", "+b1.getHeight());
		} else if(obj == b2) {
			System.out.println("��Ʈ : "+b2.getFont());
			System.out.println("���ڻ� : "+b2.getForeground());
		}
	}
}
