package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;

public class JTextAreaEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextAreaEx01 frame = new JTextAreaEx01();
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
	public JTextAreaEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 600, 480));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 36, 269, 150);
		contentPane.add(scrollPane);
		
		JTextArea txtrHelloHelloHello = new JTextArea();
		scrollPane.setViewportView(txtrHelloHelloHello);
		txtrHelloHelloHello.setEditable(false);
		txtrHelloHelloHello.setText("Hello\r\nHello\r\nHello\r\nHello\r\nHello\r\n");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("안녕");
		textField.setBounds(12, 10, 147, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtrHelloHelloHello.append(textField.getText() + "\n");
			}
		});
		btn.setBounds(184, 9, 97, 23);
		contentPane.add(btn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(46, 208, 7, 21);
		contentPane.add(passwordField);
	}
}
