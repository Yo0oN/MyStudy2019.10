import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JoinDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField idTextField;
	private JPasswordField passwordTextField;
	private JPasswordField passwordCheckTextField;
	private JTextField yTextField;
	private JTextField mTextField;
	private JTextField dTextField;
	private JComboBox sexComboBox;
	private int result;
	private JoinDialogDAO jdDAO;
	private CheckSameIDDialogDAO checkDAO;

	/**
	 * Create the dialog.
	 */
	public JoinDialog() {
		setTitle("회원가입");
		setResizable(false);
		setBounds(100, 100, 456, 326);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel nameLabel = new JLabel("이름");
			nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			nameLabel.setBounds(12, 24, 88, 15);
			contentPanel.add(nameLabel);
		}
		{
			nameTextField = new JTextField();
			nameTextField.setBounds(114, 21, 193, 21);
			contentPanel.add(nameTextField);
			nameTextField.setColumns(10);
		}
		{
			JLabel idLabel = new JLabel("아이디");
			idLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			idLabel.setBounds(12, 63, 88, 15);
			contentPanel.add(idLabel);
		}
		{
			idTextField = new JTextField();
			idTextField.setBounds(114, 60, 193, 21);
			contentPanel.add(idTextField);
			idTextField.setColumns(10);
		}
		{
			JLabel passwordLabel = new JLabel("비밀번호");
			passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			passwordLabel.setBounds(12, 102, 88, 15);
			contentPanel.add(passwordLabel);
		}

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(114, 99, 193, 21);
		contentPanel.add(passwordTextField);

		JLabel passwordCheckLabel = new JLabel("비밀번호 확인");
		passwordCheckLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordCheckLabel.setBounds(12, 141, 88, 15);
		contentPanel.add(passwordCheckLabel);

		passwordCheckTextField = new JPasswordField();
		passwordCheckTextField.setBounds(114, 138, 193, 21);
		contentPanel.add(passwordCheckTextField);
		{
			JLabel birthdayLabel = new JLabel("생일");
			birthdayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			birthdayLabel.setBounds(12, 180, 88, 15);
			contentPanel.add(birthdayLabel);
		}
		{
			yTextField = new JTextField();
			yTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					// 년에 입력되는 글자 4자까지로 제한
					JTextField src = (JTextField) e.getSource();
					if (src.getText().length() >= 4) {
						e.consume();
					}
				}
			});
			yTextField.setBounds(114, 177, 39, 21);
			contentPanel.add(yTextField);
			yTextField.setColumns(10);
		}
		{
			JLabel yLabel = new JLabel("년");
			yLabel.setBounds(158, 180, 21, 15);
			contentPanel.add(yLabel);
		}
		{
			mTextField = new JTextField();
			mTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					// 월에 입력되는 글자 2자로 제한
					JTextField src = (JTextField) e.getSource();
					if (src.getText().length() >= 2) {
						e.consume();
					}
				}
			});
			mTextField.setColumns(10);
			mTextField.setBounds(184, 177, 39, 21);
			contentPanel.add(mTextField);
		}
		{
			JLabel mLabel = new JLabel("월");
			mLabel.setBounds(228, 180, 21, 15);
			contentPanel.add(mLabel);
		}
		{
			dTextField = new JTextField();
			dTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					// 일에 입력되는 부분 2자로 제한
					JTextField src = (JTextField) e.getSource();
					if (src.getText().length() >= 2) {
						e.consume();
					}
				}
			});
			dTextField.setColumns(10);
			dTextField.setBounds(250, 177, 39, 21);
			contentPanel.add(dTextField);
		}
		{
			JLabel dLabel = new JLabel("일");
			dLabel.setBounds(296, 180, 21, 15);
			contentPanel.add(dLabel);
		}
		{
			JLabel sexL = new JLabel("성별");
			sexL.setHorizontalAlignment(SwingConstants.TRAILING);
			sexL.setBounds(12, 219, 88, 15);
			contentPanel.add(sexL);
		}
		{
			sexComboBox = new JComboBox();
			sexComboBox.setModel(new DefaultComboBoxModel(new String[] { "남자", "여자" }));
			sexComboBox.setBounds(114, 215, 65, 23);
			contentPanel.add(sexComboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// OK버튼 눌렀을 때
						try {
							String date = String.format("%s-%s-%s", yTextField.getText(), mTextField.getText(),
									dTextField.getText());

							String sex;
							if (sexComboBox.getSelectedIndex() == 0) {
								sex = "남자";
							} else {
								sex = "여자";
							}

							jdDAO = new JoinDialogDAO();
							checkDAO = new CheckSameIDDialogDAO();

							if (checkDAO.checkID(idTextField.getText())) {
								
								JOptionPane.showMessageDialog(JoinDialog.this, "중복된 아이디가 있습니다.", "error",
										JOptionPane.ERROR_MESSAGE);
								
							} else if (passwordTextField.getText().length() == 0 || yTextField.getText().length() == 0
									|| mTextField.getText().length() == 0 || dTextField.getText().length() == 0) {
								
								JOptionPane.showMessageDialog(JoinDialog.this, "빈칸을 모두 채워주세요!", "error",
										JOptionPane.ERROR_MESSAGE);
								
							} else if (passwordTextField.getText().equals(passwordCheckTextField.getText())) {
								
								result = jdDAO.createUser(idTextField.getText(), passwordTextField.getText(),
										nameTextField.getText(), date, sex);

								if (result == 1) {
									JOptionPane.showMessageDialog(JoinDialog.this, "가입 완료");
									JoinDialog.this.dispose();
								} else {
									JOptionPane.showMessageDialog(JoinDialog.this, "가입 실패");
								}
							} else {
								JOptionPane.showMessageDialog(JoinDialog.this, "비밀번호를 다시 확인해주세요!", "error",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(JoinDialog.this, "날짜를 확인하세요!", "error",
									JOptionPane.ERROR_MESSAGE);
							
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
						// cancel 누르면 아무일없이 창만 닫힘
						JoinDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
