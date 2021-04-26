package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldAreaEx extends JFrame implements ActionListener {
	private JPanel panCenter;
	private JPanel panSouth;
	private JTextField tf;
	private JButton btn_ok;
	private JTextArea ta;
	
	public TextFieldAreaEx(String title, int width, int height) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(this);
		
		setCenter();
		setSouth();
		
		add(panCenter,BorderLayout.CENTER);
		add(panSouth,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void setCenter() {
		// TODO Auto-generated method stub
		panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		panCenter.setBackground(Color.YELLOW);
		
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta.setEditable(false);
		panCenter.add(js);
		
	}
	
	private void setSouth() {
		// TODO Auto-generated method stub
		panSouth = new JPanel();
		panSouth.setBackground(Color.BLUE);
		
		tf = new JTextField(18);
		tf.addActionListener(this);
		panSouth.add(tf);
		
		btn_ok = new JButton("»Æ¿Œ");
		btn_ok.addActionListener(this);
		panSouth.add(btn_ok);
	}
	public static void main(String[] args) {
		new TextFieldAreaEx("My Chat", 300, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_ok || obj == tf) {
			printText();
	}
}

	private void printText() {
		ta.append(tf.getText()+"\n");
		tf.setText("");
		tf.requestFocus(true);
	}

}