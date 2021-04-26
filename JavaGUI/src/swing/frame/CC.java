package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CC extends JFrame{
	JPanel top_Panel; // 최상위 패널
	
	// 왼쪽 필드
	JLabel type_id;
	JTextField field_type_id;
	JLabel type_password;
	JTextField field_type_password;
	
	// 오른쪽 필드
	JLabel checkbox_text;
	JCheckBox checkbox_c_sharp;
	JCheckBox checkBox_c_plusplus;
	
	JButton btn_ok;
	
	public CC(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		Container c = getContentPane();
		top_Panel = new JPanel();

		add(top_Panel);
		
		set_leftjpanel();
		set_rightjpanel();
		
		setVisible(true);
		
	}
	public void set_leftjpanel(){
		JPanel left_Panel = new JPanel();
		left_Panel.setLayout(new GridLayout(7,1));
		left_Panel.setBackground(Color.YELLOW);
		left_Panel.setPreferredSize(new Dimension(180,200));
		type_id = new JLabel("TYPE ID");
		type_id.setHorizontalAlignment(JLabel.CENTER);
		
		field_type_id = new JTextField();
		field_type_id.setHorizontalAlignment(JTextField.CENTER);
		
		type_password = new JLabel("TYPE PASSWORD");
		type_password.setHorizontalAlignment(JLabel.CENTER);
		
		field_type_password = new JTextField();
		field_type_password.setHorizontalAlignment(JTextField.CENTER);
		
		left_Panel.add(type_id);
		left_Panel.add(field_type_id);
		left_Panel.add(type_password);
		left_Panel.add(field_type_password);
		
		top_Panel.add(left_Panel);
	}
	
	public void set_rightjpanel(){
		
		JPanel right_Panel = new JPanel();
		right_Panel.setLayout(new GridLayout(7,1));
		right_Panel.setBackground(Color.GREEN);
		right_Panel.setPreferredSize(new Dimension(180,200));
		checkbox_text = new JLabel("Please Check!!");
		checkbox_text.setHorizontalAlignment(JLabel.CENTER);
		checkbox_c_sharp = new JCheckBox("C# JCheckBox");
		checkbox_c_sharp.setHorizontalAlignment(JCheckBox.CENTER);
		checkBox_c_plusplus = new JCheckBox("C++ JCheckBox");
		checkBox_c_plusplus.setHorizontalAlignment(JCheckBox.CENTER);
		
		right_Panel.add(checkbox_text);
		right_Panel.add(checkbox_c_sharp);
		right_Panel.add(checkBox_c_plusplus);
		
		top_Panel.add(right_Panel);
	}

	public static void main(String[] args) {
		new CC("Container & Component", 400, 300);
	}
}
