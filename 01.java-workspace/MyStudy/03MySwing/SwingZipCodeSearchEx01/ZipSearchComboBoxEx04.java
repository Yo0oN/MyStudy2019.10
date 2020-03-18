package SwingZipCodeSearchEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZipSearchComboBoxEx04 extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchComboBoxEx04 frame = new ZipSearchComboBoxEx04();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZipSearchComboBoxEx04() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 9, 424, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("동이름 입력 : ");
		lblNewLabel.setBounds(6, 21, 76, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 18, 195, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("찾기");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 입력한 동 받아오기
				String strDong = textField.getText();
				
				// 콤보박스에 넘겨주기
				comboBox.setModel(new ZipSearchComboBoxModel(strDong));
				
			}
		});
		btn.setBounds(315, 17, 97, 23);
		panel.add(btn);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(6, 72, 424, 23);
		contentPane.add(comboBox);
	}

}
