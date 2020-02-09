package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JScrollPane;

public class MySwingZipCode extends JFrame {

	// 동을 입력시 아래에 우편번호를 띄워주는 프로그램을 만들어라(DB와 연결)
		

	private JPanel contentPane;
	private JTextArea zipcodeResult;
	public JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwingZipCode frame = new MySwingZipCode();
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
	public MySwingZipCode() {
		setTitle("우편번호 검색기");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(12, 36, 311, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		
		
		JButton btn = new JButton("New button");
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				zipcodeResult.setText("");
				
				// textArea에서 글을 입력하면 DB에서 값을 받아와 textField에 출력하라
				String url = "jdbc:mysql://127.0.0.1:3306/employees";
				String user = "root";
				String password = "123456";

				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					// DBMS 접속함
					Class.forName("org.mariadb.jdbc.Driver");
					// 커넥션OK
					conn = DriverManager.getConnection(url, user, password);
					// Statement 생성완료
					stmt = conn.createStatement();
					// 동입력받아 쿼리에 넣기
					String sql = String.format("select zipcode, sido, gugun, dong, ri from zipcode where dong like '%%%s%%'",
							textField.getText());
					// DBMS에 명령하기
					rs = stmt.executeQuery(sql);
					// 읽어오기
					if (!rs.next()) {
						JOptionPane.showMessageDialog(MySwingZipCode.this, "제대로 된 동을 입력하세요!", "Error", JOptionPane.WARNING_MESSAGE);
					}
					while (rs.next()) {
						String hey = String.format("[%s] %3s %4s %5s %10s%n", rs.getString("zipcode"), rs.getString("sido"),
								rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
						zipcodeResult.append(hey);
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("[예외1] : " + e1.getMessage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("[예외2] : " + e1.getMessage());
				} finally {
					if (stmt != null) { try { stmt.close(); } catch (SQLException e1) { } }
					if (conn != null) { try { conn.close(); } catch (SQLException e1) { } }
					if (rs != null) { try { rs.close(); } catch (SQLException e1) { } }
				}
			}
		});
		
		btn.setBounds(335, 35, 97, 23);
		contentPane.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 420, 386);
		contentPane.add(scrollPane);

		zipcodeResult = new JTextArea();
		scrollPane.setViewportView(zipcodeResult);
		zipcodeResult.setEditable(false);

		JLabel label = new JLabel("동을 입력하세요.");
		label.setBounds(12, 10, 170, 15);
		contentPane.add(label);
	}

}
