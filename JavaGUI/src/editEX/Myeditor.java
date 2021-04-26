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
		
		setMenu(); // 메뉴
		setJMenuBar(mbar);
		
		setVisible(true);
	}
	private void setMenu() {
		// TODO Auto-generated method stub
		mbar = new JMenuBar(); 
		
		menu_File = new JMenu("파일");
		mbar.add(menu_File);
		menu_item_new = new JMenuItem("새 파일");
		menu_item_new.addActionListener(this);
		menu_File.add(menu_item_new);
		menu_item_open = new JMenuItem("열기");
		menu_File.add(menu_item_open);
		menu_item_save = new JMenuItem("저장");
		menu_File.add(menu_item_save);
		menu_File.addSeparator();
		menu_item_exit = new JMenuItem("닫기");
		menu_item_exit.addActionListener(this);
		menu_File.add(menu_item_exit);
		
		menu_Edit = new JMenu("편집");
		menu_item_copy = new JMenuItem("복사");
		menu_Edit.add(menu_item_copy);
		menu_item_paste = new JMenuItem("붙혀넣기");
		menu_Edit.add(menu_item_paste);
		
		mbar.add(menu_Edit);
		
		menu_Info = new JMenu("정보");
		menu_item_info = new JMenuItem("프로그램 정보");
		menu_item_info.addActionListener(this);
		menu_Info.add(menu_item_info);
		mbar.add(menu_Info);
	}
	public static void main(String[] args) {
		new Myeditor("기본 에디터", 600, 400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == menu_item_exit) {
			int result = JOptionPane.showConfirmDialog(null, "정말 나갑니까?","나가기",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(1);
			} 
		} else if(obj == menu_item_info) {
			JOptionPane.showConfirmDialog(null, "기본 에디터","에디터",JOptionPane.CLOSED_OPTION);
		} else if(obj == menu_item_new) {
			String val1 = JOptionPane.showInputDialog("숫자1 입력");
			String val2 = JOptionPane.showInputDialog("숫자2 입력");
			int sum = Integer.parseInt(val1)+Integer.parseInt(val2);
			System.out.println(sum);
		}
	}
}
