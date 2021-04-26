package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Calc2 extends JFrame implements ActionListener {
	
	private final String btn_pad[] = 
		   {"7", "8", "9", "+",
			"4", "5", "6", "-",
			"1", "2", "3", "*",
			"C", "0", "=", "/"};
	
	JMenu jm_Edit, jm_Help; // edit help 메뉴
	JMenuItem jmi_Copy, jmi_Paste, jmi_Help, jmi_Info; // JMenu Item
	JMenuBar jmb;
	JPanel pad_Panel; // 패드 패널
	JPanel result_Panel; // 계산기의 입력부분 패널
	JLabel jlb_Result1;
	
	JTextField jlb_Result2;
	
	Clipboard clip;
	
	private String func = "ADD";
	private int firstNumber;
	
	public Calc2(String title, int width, int height) {
		
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(null);  // 전체레이아웃을 보더레이아웃으로 지정
		setResizable(false);

		result_Panel = new JPanel(new BorderLayout()); // 패널부분을 보더레이아웃으로 지정
		jlb_Result1 = new JLabel("",JLabel.RIGHT);
		jlb_Result2 = new JTextField();
		jlb_Result2.setBackground(Color.WHITE);
		jlb_Result2.setEditable(false);
		jlb_Result2.setFont(new Font("Arial",Font.BOLD,50));
		jlb_Result2.setBounds(8,10,270,70);
		jlb_Result2.setHorizontalAlignment(JTextField.RIGHT);
		
//		result_Panel.add(jlb_Result1,BorderLayout.NORTH);
		result_Panel.add(jlb_Result2,BorderLayout.SOUTH);
		result_Panel.setBounds(8,10,270,70);
		
		jmb = new JMenuBar();
		
		jm_Edit = new JMenu("편집(E)");
		jm_Help = new JMenu("정보(I)");
		
		jmi_Copy = new JMenuItem("복사");
		jmi_Paste = new JMenuItem("붙혀넣기");
		jmi_Info = new JMenuItem("학생 정보");
		
		jm_Edit.add(jmi_Copy);
		jm_Edit.add(jmi_Paste);
		jm_Help.add(jmi_Info);
		
		jmb.add(jm_Edit);
		jmb.add(jm_Help);
		
//		jm_Edit.setMnemonic('E');
		jm_Edit.setMnemonic('E');
		jm_Help.setMnemonic('I');
		
		jmi_Copy.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		jmi_Paste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
		jmi_Info.setAccelerator(KeyStroke.getKeyStroke('I', InputEvent.CTRL_MASK));
		/** 버튼 단축키 끝 */

		jmi_Copy.addActionListener(this);
		jmi_Paste.addActionListener(this);
		jmi_Info.addActionListener(this);
		/** 버튼 끝 */
		
		pad_Panel = new JPanel(new GridLayout(4,4,5,5));
		/** pad_Panel 을 그리드 레이아웃으로 지정**/
		pad_Panel.setBounds(8,90,270,235);
		JButton buttons[] = new JButton[btn_pad.length];
		
		for (int i = 0; i < btn_pad.length; i++) {
			buttons[i] = new JButton(btn_pad[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD,25));
			pad_Panel.add(buttons[i]);
			buttons[i].addActionListener(this);
			if(btn_pad[i] == "C") {
				buttons[i].setBackground(Color.RED);
				buttons[i].setForeground(Color.WHITE);
			} else if(i == 3 || i == 7 || i == 11 || i == 14 || i == 15) {
				buttons[i].setBackground(Color.GRAY);
				buttons[i].setForeground(Color.WHITE);
			} else {
				buttons[i].setBackground(Color.BLACK);
				buttons[i].setForeground(Color.WHITE);
			}
		}
		/** 패드 지정 **/
		
		
		add(result_Panel,BorderLayout.NORTH);
		/** 계산결과부분 보더레이아웃 위로 지정 **/
		add(pad_Panel,BorderLayout.CENTER);
		/** 패드 부분을 보더레이아웃 센터로 지정 **/
		
		setJMenuBar(jmb);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calc2("계산기", 300, 400);
	}
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();

		for (int i = 0; i < 10; i++) {
			if(input.equals(Integer.toString(i))) {
				int Select_Zero = Integer.parseInt(jlb_Result2.getText()+input);
				jlb_Result2.setText(Integer.toString(Select_Zero));
			}
		}
		
		if(input.equals("=")) {
			switch(func) {
				case "ADD":{
					int currVal = Integer.parseInt(jlb_Result2.getText());
					jlb_Result2.setText((firstNumber+currVal)+"");
					break;
				}
				case "SUB":{
					int currVal = Integer.parseInt(jlb_Result2.getText());
					jlb_Result2.setText((firstNumber-currVal)+"");
					break;
				}
				case "MUL":{
					int currVal = Integer.parseInt(jlb_Result2.getText());
					jlb_Result2.setText((firstNumber*currVal)+"");
					break;
				}
				case "DIV":{
					int currVal = Integer.parseInt(jlb_Result2.getText());
					jlb_Result2.setText((firstNumber/currVal)+"");
					break;
				}
			}
		} else if(input.equals("+")) {
			String curr = jlb_Result2.getText();
			firstNumber = Integer.parseInt(curr);
			jlb_Result2.setText("0");
			func = "ADD";
		} else if(input.equals("-")) {
			String curr = jlb_Result2.getText();
			firstNumber = Integer.parseInt(curr);
			jlb_Result2.setText("0");
			func = "SUB";
		} else if(input.equals("*")) {
			String curr = jlb_Result2.getText();
			firstNumber = Integer.parseInt(curr);
			jlb_Result2.setText("0");
			func = "MUL";
		} else if(input.equals("/")) {
			String curr = jlb_Result2.getText();
			firstNumber = Integer.parseInt(curr);
			jlb_Result2.setText("0");
			func = "DIV";
		} else if(input.equals("C")) {
			jlb_Result2.setText("0");
			firstNumber = 0;
			func ="ADD";
		} else if(input.equals("복사")) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			String copy = jlb_Result2.getText();
			String copyString = jlb_Result2.getText();
			StringSelection contents = new StringSelection(copyString);
			clip.setContents(contents, null);
		} else if(input.equals("붙혀넣기")) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clip.getContents(clip);
			try {
				String pasteString = (String)(contents.getTransferData(DataFlavor.stringFlavor));
				jlb_Result2.setText(pasteString);
			} catch (UnsupportedFlavorException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}  else if(input.equals("학생 정보")) {
			JOptionPane.showMessageDialog(null, "202045071_공연성_컴퓨터시스템학과_C반");
		}
	}
}
