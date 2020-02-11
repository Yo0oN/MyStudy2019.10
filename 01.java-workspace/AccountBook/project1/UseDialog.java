import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField useMoney;
	private JTextField smallwhere;
	private JComboBox bigwhere;
	private JComboBox cash_card;
	private JButton okButton;
	private Date d = new Date();
	private JLabel dateLabel;
	private JTextField yTextField;
	private JTextField mTextField;
	private JTextField dTextField;
	private JLabel yLabel;
	private JLabel mLabel;
	private JLabel dLabel;
	private UseDialogDAO udDAO;
	private AccountBookUI mainFrame;
	private int m_num;

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	/**
	 * Create the dialog.
	 */

	public UseDialog() {
		setResizable(false);
		setTitle("지출");
		setBounds(100, 100, 300, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel useLabel = new JLabel("지출 금액 : ");
			useLabel.setBounds(27, 49, 73, 15);
			contentPanel.add(useLabel);
		}
		{
			useMoney = new JTextField();
			useMoney.setBounds(101, 45, 116, 23);
			contentPanel.add(useMoney);
			useMoney.setColumns(10);
		}
		{
			JLabel bigLabel = new JLabel("대분류 : ");
			bigLabel.setBounds(43, 86, 57, 15);
			contentPanel.add(bigLabel);
		}
		{
			JLabel smallLabel = new JLabel("소분류 :");
			smallLabel.setBounds(43, 123, 57, 15);
			contentPanel.add(smallLabel);
		}
		{
			smallwhere = new JTextField();
			smallwhere.setBounds(101, 119, 116, 23);
			contentPanel.add(smallwhere);
			smallwhere.setColumns(10);
		}

		bigwhere = new JComboBox();
		bigwhere.setModel(
				new DefaultComboBoxModel(new String[] { "식비", "주거비", "의복비", "미용비", "문화비", "교통비", "의료비", "공과금", "기타" }));
		bigwhere.setBounds(101, 82, 116, 23);
		contentPanel.add(bigwhere);

		cash_card = new JComboBox();
		cash_card.setModel(new DefaultComboBoxModel(new String[] { "카드", "현금" }));
		cash_card.setBounds(101, 156, 116, 23);
		contentPanel.add(cash_card);
		{
			dateLabel = new JLabel("날짜 : ");
			dateLabel.setBounds(54, 16, 46, 15);
			contentPanel.add(dateLabel);
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
			yTextField.setText(d.getYear() + 1900 + "");
			yTextField.setColumns(10);
			yTextField.setBounds(101, 12, 35, 23);
			contentPanel.add(yTextField);
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
			mTextField.setText(d.getMonth() + 1 + "");
			mTextField.setColumns(10);
			mTextField.setBounds(154, 12, 29, 23);
			contentPanel.add(mTextField);
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
			dTextField.setText(d.getDate() + "");
			dTextField.setColumns(10);
			dTextField.setBounds(205, 12, 29, 23);
			contentPanel.add(dTextField);
		}

		{
			yLabel = new JLabel("년");
			yLabel.setBounds(138, 16, 20, 15);
			contentPanel.add(yLabel);
		}
		{
			mLabel = new JLabel("월");
			mLabel.setBounds(186, 16, 20, 15);
			contentPanel.add(mLabel);
		}
		{
			dLabel = new JLabel("일");
			dLabel.setBounds(239, 16, 20, 15);
			contentPanel.add(dLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							String date = String.format("%s-%s-%s", yTextField.getText(), mTextField.getText(),
									dTextField.getText());

							if (yTextField.getText().length() == 0 || mTextField.getText().length() == 0
									|| dTextField.getText().length() == 0 || useMoney.getText().length() == 0) {
								JOptionPane.showMessageDialog(UseDialog.this, "빈칸을 모두 채워주세요!", "error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								udDAO = new UseDialogDAO();

								int result = udDAO.setUseDialog(m_num, date, bigwhere.getSelectedItem().toString(),
										smallwhere.getText(), useMoney.getText(),
										cash_card.getSelectedItem().toString());

								if (result > 0) {
									JOptionPane.showMessageDialog(UseDialog.this, "입력되었습니다.", "",
											JOptionPane.PLAIN_MESSAGE);

									UseDialog.this.dispose();
								} else {
									JOptionPane.showMessageDialog(UseDialog.this, "다시 확인해주세요!", "error",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						} catch (NumberFormatException e3) {
							JOptionPane.showMessageDialog(UseDialog.this, "다시 확인해주세요!", "error",
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
						// 취소 버튼을 누르면 DB와 상관없이 창이 닫힌다.
						UseDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
