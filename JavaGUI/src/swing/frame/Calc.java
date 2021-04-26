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
import javax.swing.KeyStroke;

public class Calc extends JFrame implements ActionListener {
	
	private final String btn_pad[] = 
		   {"7", "8", "9", "+",
			"4", "5", "6", "-",
			"1", "2", "3", "*",
			"C", "0", "=", "/"};
	
	JMenu jm_Edit, jm_Help; // edit help �޴�
	JMenuItem jmi_Copy, jmi_Paste, jmi_Help, jmi_Info; // JMenu Item
	JMenuBar jmb;
	JPanel pad_Panel; // �е� �г�
	JPanel result_Panel; // ������ �Էºκ� �г�
	
	JLabel jlb_Result1, jlb_Result2;
	Clipboard clip;
	
	private String func = "ADD";
	private int firstNumber;
	
	public Calc(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout(2,2));  // ��ü���̾ƿ��� �������̾ƿ����� ����
		setResizable(false);
		
		result_Panel = new JPanel(new BorderLayout()); // �гκκ��� �������̾ƿ����� ����
		jlb_Result1 = new JLabel("",JLabel.RIGHT);
		jlb_Result2 = new JLabel("0",JLabel.RIGHT);	
		
		result_Panel.add(jlb_Result1,BorderLayout.NORTH);
		result_Panel.add(jlb_Result2,BorderLayout.SOUTH);
		
		jmb = new JMenuBar();
		
		jm_Edit = new JMenu("����(E)");
		jm_Help = new JMenu("����(I)");
		
		jmi_Copy = new JMenuItem("����");
		jmi_Paste = new JMenuItem("�����ֱ�");
		jmi_Info = new JMenuItem("�л� ����");
		
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
		/** ��ư ����Ű �� */

		jmi_Copy.addActionListener(this);
		jmi_Paste.addActionListener(this);
		jmi_Info.addActionListener(this);
		/** ��ư �� */
		
		pad_Panel = new JPanel(new GridLayout(4,4,5,5));  
		/** pad_Panel �� �׸��� ���̾ƿ����� ����**/
		
		
		JButton buttons[] = new JButton[btn_pad.length];
		
		for (int i = 0; i < btn_pad.length; i++) {
			buttons[i] = new JButton(btn_pad[i]);
			buttons[i].setFont(new Font("Tahoma", Font.BOLD,25));
			pad_Panel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		/** �е� ���� **/
		
		
		add(result_Panel,BorderLayout.NORTH);
		/** ������κ� �������̾ƿ� ���� ���� **/
		add(pad_Panel,BorderLayout.CENTER);
		/** �е� �κ��� �������̾ƿ� ���ͷ� ���� **/
		
		setJMenuBar(jmb);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calc("����", 270, 400);
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
		} else if(input.equals("����")) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			String copy = jlb_Result2.getText();
			String copyString = jlb_Result2.getText();
			StringSelection contents = new StringSelection(copyString);
			clip.setContents(contents, null);
		} else if(input.equals("�����ֱ�")) {
			clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clip.getContents(clip);
			try {
				String pasteString = (String)(contents.getTransferData(DataFlavor.stringFlavor));
				jlb_Result2.setText(pasteString);
			} catch (UnsupportedFlavorException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}  else if(input.equals("�л� ����")) {
			JOptionPane.showMessageDialog(null, "202045071_������_��ǻ�ͽý����а�_C��");
		}
	}
}
