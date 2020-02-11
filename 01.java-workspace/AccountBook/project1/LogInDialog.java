import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JPasswordField passwordTextField;
	private AccountBookUI mainFrame;
	private LogInDialogDAO liDAO;
	private String m_ID;
	private int m_num;
	
	/**
	 * Create the dialog.
	 */
	public LogInDialog() {
		setTitle("로그인");
		setResizable(false);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		idTextField = new JTextField();
		idTextField.setBounds(87, 34, 189, 21);
		contentPanel.add(idTextField);
		idTextField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(87, 65, 189, 21);
		contentPanel.add(passwordTextField);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(12, 37, 57, 15);
		contentPanel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 68, 57, 15);
		contentPanel.add(lblPassword);

		JButton loginButton = new JButton("LogIn");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				liDAO = new LogInDialogDAO();

				boolean result = liDAO.login(idTextField.getText(), passwordTextField.getText());

				if (result) {
					
					m_ID = idTextField.getText();
					m_num = liDAO.M_num(idTextField.getText());

					mainFrame.setM_num(m_num);
					mainFrame.setM_ID(m_ID);
					
					LogInDialog.this.dispose();
				} else {
					JOptionPane.showMessageDialog(LogInDialog.this, "아이디 또는 비밀번호가 맞지 않습니다.");
				}
			}
		});
		loginButton.setBounds(298, 33, 97, 53);
		contentPanel.add(loginButton);

		JButton joinButton = new JButton("회원가입");
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JoinDialog joinDialog = new JoinDialog();
				
				joinDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				joinDialog.setModal(true);
				joinDialog.setVisible(true);
			}
		});
		joinButton.setBounds(298, 108, 97, 23);
		contentPanel.add(joinButton);
	}

	public LogInDialog(AccountBookUI mainFrame) {
		this();
		this.mainFrame = mainFrame;
	}
}
