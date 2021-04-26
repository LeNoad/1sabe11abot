package swing.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class CheckBoxEx extends JFrame implements ItemListener {
	
	private JCheckBox chk1, chk2, chk3;
	private JLabel lblsum;
	private int sum = 0;
	public CheckBoxEx(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JLabel lbl1 = new JLabel("��� 100��, �� 500��, ü�� 2000��");
		chk1 = new JCheckBox("���");
		chk1.addItemListener(this);
		
		chk2 = new JCheckBox("��");
		chk2.addItemListener(this);
		
		chk3 = new JCheckBox("ü��");
		chk3.addItemListener(this);
		lblsum = new JLabel("���� 0 �� �Դϴ�.");
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rbMan = new JRadioButton("����");
		JRadioButton rbWoman = new JRadioButton("����");
		bg.add(rbMan);
		bg.add(rbWoman);
		
		add(lbl1);
		
		add(chk1);
		add(chk2);
		add(chk3);
		
		add(lblsum);
		
		add(rbMan);
		add(rbWoman);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxEx("üũ�ڽ� ����", 250, 200);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int i = 1;
		if(e.getStateChange() == ItemEvent.SELECTED) {
			i = 1;
		} else {
			i = -1;
		}
		if(e.getItem() == chk1) {
			sum = sum + 100 * i;
		} else if(e.getSource() == chk2) {
			sum = sum + 500 * i;
		} else if(e.getSource() == chk3) {
			sum = sum + 2000 * i;
		}
		lblsum.setText("���� " + sum + " �� �Դϴ�.");
	}

}
