package SwingZipCodeSearchEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ZipSearchEx02 extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchEx02 frame = new ZipSearchEx02();
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
	public ZipSearchEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(6, 9, 451, 66);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("동이름 입력 : ");
		lblNewLabel.setBounds(12, 25, 76, 15);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(94, 22, 224, 21);
		panel.add(textField);
		textField.setColumns(10);

		btn = new JButton("찾기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strDong = textField.getText();
				if (strDong.length() < 2) {
					JOptionPane.showMessageDialog(ZipSearchEx02.this, "2자 이상 입력하셔야 합니다.");
				} else {
					// JOptionPane.showMessageDialog(ZipSearchEx02.this, "정상");

					textArea.setText("");

					String url = "jdbc:mysql://127.0.0.1:3306/employees";
					String user = "root";
					String password = "123456";

					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {
						Class.forName("org.mariadb.jdbc.Driver");

						conn = DriverManager.getConnection(url, user, password);

						String sql = "select * from zipcode where dong like ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, "%" + strDong + "%");

						rs = pstmt.executeQuery();
						while (rs.next()) {
							String zipcode = rs.getString("zipcode");
							String sido = rs.getString("sido");
							String gugun= rs.getString("gugun");
							String dong= rs.getString("dong");
							String ri= rs.getString("ri");
							String bunji= rs.getString("bunji");
							
							String address = String.format("[%s] %s %s %s %s %s%n",
									zipcode, sido, gugun, dong, ri, bunji);
							
							textArea.append(address);
						}
					} catch (ClassNotFoundException e1) {
						System.out.println(e1.getMessage());
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					} finally {
						if (rs != null) { try { rs.close(); } catch (SQLException e1) { System.out.println(e1.getMessage()); } }
						if (pstmt != null) { try { pstmt.close(); } catch (SQLException e1) { System.out.println(e1.getMessage()); } }
						if (conn != null) { try { pstmt.close(); } catch (SQLException e1) { System.out.println(e1.getMessage()); } }
					}
				}
			}
		});
		btn.setBounds(333, 21, 97, 23);
		panel.add(btn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 85, 430, 388);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
