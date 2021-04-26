package editEX;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Myeditor extends JFrame implements ActionListener{
	private JMenuBar mbar;
	private JMenuItem mitem;
	private JMenu menu_File;
	private JMenu menu_Edit;
	private JMenu menu_Info;
	private JMenuItem menu_item_new;
	private JMenuItem menu_item_open;
	private JMenuItem menu_item_save;
	private JMenuItem menu_item_exit;
	private JMenuItem menu_item_paste;
	private JMenuItem menu_item_copy;
	private JMenuItem menu_item_info;
	
	public Myeditor(String title, int width, int height) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setResizable(false);
		
		setMenu(); // �޴�
		setJMenuBar(mbar);
		
		setVisible(true);
	}
	private void setMenu() {
		// TODO Auto-generated method stub
		mbar = new JMenuBar(); 
		
		menu_File = new JMenu("����");
		mbar.add(menu_File);
		menu_item_new = new JMenuItem("�� ����");
		menu_item_new.addActionListener(this);
		menu_File.add(menu_item_new);
		menu_item_open = new JMenuItem("����");
		menu_File.add(menu_item_open);
		menu_item_save = new JMenuItem("����");
		menu_File.add(menu_item_save);
		menu_File.addSeparator();
		menu_item_exit = new JMenuItem("�ݱ�");
		menu_item_exit.addActionListener(this);
		menu_File.add(menu_item_exit);
		
		menu_Edit = new JMenu("����");
		menu_item_copy = new JMenuItem("����");
		menu_Edit.add(menu_item_copy);
		menu_item_paste = new JMenuItem("�����ֱ�");
		menu_Edit.add(menu_item_paste);
		
		mbar.add(menu_Edit);
		
		menu_Info = new JMenu("����");
		menu_item_info = new JMenuItem("���α׷� ����");
		menu_item_info.addActionListener(this);
		menu_Info.add(menu_item_info);
		mbar.add(menu_Info);
	}
	public static void main(String[] args) {
		new Myeditor("�⺻ ������", 600, 400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == menu_item_exit) {
			int result = JOptionPane.showConfirmDialog(null, "���� �����ϱ�?","������",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(1);
			} 
		} else if(obj == menu_item_info) {
			JOptionPane.showConfirmDialog(null, "�⺻ ������","������",JOptionPane.CLOSED_OPTION);
		} else if(obj == menu_item_new) {
			String val1 = JOptionPane.showInputDialog("����1 �Է�");
			String val2 = JOptionPane.showInputDialog("����2 �Է�");
			int sum = Integer.parseInt(val1)+Integer.parseInt(val2);
			System.out.println(sum);
		}
	}
}
