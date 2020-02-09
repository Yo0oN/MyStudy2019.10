import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChagePasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField nowPasswordField;
	private JPasswordField changePasswordField;
	private JPasswordField passwordCheckField;
	private ChagePasswordDialogDAO cpdDAO;
	private int m_num;
	private String m_id;
	
	public int getM_num() {
		return m_num;
	}

	public String getM_ID() {
		return m_id;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	public void setM_ID(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * Create the dialog.
	 */
	public ChagePasswordDialog() {
		this.m_num = m_num;
		this.m_id = m_id;
		setTitle("비밀번호 변경");
		setResizable(false);
		setBounds(100, 100, 320, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		nowPasswordField = new JPasswordField();
		nowPasswordField.setBounds(112, 10, 155, 21);
		contentPanel.add(nowPasswordField);

		JLabel nowPasswordLabel = new JLabel("현재 비밀번호");
		nowPasswordLabel.setBounds(12, 13, 88, 15);
		contentPanel.add(nowPasswordLabel);

		changePasswordField = new JPasswordField();
		changePasswordField.setBounds(112, 35, 155, 21);
		contentPanel.add(changePasswordField);

		JLabel changePasswordFieldLabel = new JLabel("변경 비밀번호");
		changePasswordFieldLabel.setBounds(12, 38, 88, 15);
		contentPanel.add(changePasswordFieldLabel);

		passwordCheckField = new JPasswordField();
		passwordCheckField.setBounds(112, 60, 155, 21);
		contentPanel.add(passwordCheckField);

		JLabel passwordCheckLabel = new JLabel("비밀번호 확인");
		passwordCheckLabel.setBounds(12, 63, 88, 15);
		contentPanel.add(passwordCheckLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 마우스 클릭시 만약 현재 비번이 다를경우알림창, 변경비번과 체크비번이 달라도 알림창
						cpdDAO = new ChagePasswordDialogDAO();
						
						if (cpdDAO.CheckPassword(m_num, nowPasswordField.getText())) {
							if (changePasswordField.getText().equals(passwordCheckField.getText())) {
								cpdDAO = new ChagePasswordDialogDAO();
								
								cpdDAO.ChagePassword(m_num, changePasswordField.getText());
								ChagePasswordDialog.this.dispose();
								JOptionPane.showMessageDialog(ChagePasswordDialog.this, "비밀번호 변경 완료!");
							} else {
								JOptionPane.showMessageDialog(ChagePasswordDialog.this, "변경 비밀번호를 다시 확인해주세요");
							}
						} else {
							// 비밀번호 확인 알림창 띄우기
							JOptionPane.showMessageDialog(ChagePasswordDialog.this, "현재 비밀번호가 틀렸습니다.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ChagePasswordDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
