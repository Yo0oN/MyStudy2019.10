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

public class GetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField getMoney;
	private JTextField smallwhere;
	private JComboBox bigwhere;
	private JButton okButton;
	private JTextField yTextField;
	private JTextField mTextField;
	private JTextField dTextField;
	private GetDialogDAO getDAO;
	private Date d = new Date();
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

	public GetDialog() {
		setResizable(false);
		setTitle("수입");
		setBounds(100, 100, 300, 222);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel getLabel = new JLabel("수입 : ");
			getLabel.setBounds(49, 43, 47, 15);
			contentPanel.add(getLabel);
		}
		{
			getMoney = new JTextField();
			getMoney.setText("");
			getMoney.setBounds(97, 39, 116, 23);
			contentPanel.add(getMoney);
			getMoney.setColumns(10);
		}
		{
			JLabel bigLabel = new JLabel("대분류 : ");
			bigLabel.setBounds(39, 80, 57, 15);
			contentPanel.add(bigLabel);
		}
		{
			JLabel smallLabel = new JLabel("소분류 :");
			smallLabel.setBounds(39, 117, 57, 15);
			contentPanel.add(smallLabel);
		}
		{
			smallwhere = new JTextField();
			smallwhere.setText("");
			smallwhere.setBounds(97, 113, 116, 23);
			contentPanel.add(smallwhere);
			smallwhere.setColumns(10);
		}

		bigwhere = new JComboBox();
		bigwhere.setModel(new DefaultComboBoxModel(new String[] { "월급", "용돈", "기타" }));
		bigwhere.setBounds(97, 76, 116, 23);
		contentPanel.add(bigwhere);
		{
			JLabel dateLabel = new JLabel("날짜 :  ");
			dateLabel.setBounds(49, 10, 47, 15);
			contentPanel.add(dateLabel);
		}
		{
			yTextField = new JTextField();
			yTextField.setText(d.getYear() + 1900 + "");
			yTextField.setColumns(10);
			yTextField.setBounds(97, 6, 35, 23);
			contentPanel.add(yTextField);
		}
		{
			JLabel yLabel = new JLabel("년");
			yLabel.setBounds(134, 10, 20, 15);
			contentPanel.add(yLabel);
		}
		{
			mTextField = new JTextField();
			mTextField.setText(d.getMonth() + 1 + "");
			mTextField.setColumns(10);
			mTextField.setBounds(150, 6, 29, 23);
			contentPanel.add(mTextField);
		}
		{
			JLabel mLabel = new JLabel("월");
			mLabel.setBounds(182, 10, 20, 15);
			contentPanel.add(mLabel);
		}
		{
			dTextField = new JTextField();
			dTextField.setText(d.getDate() + "");
			dTextField.setColumns(10);
			dTextField.setBounds(201, 6, 29, 23);
			contentPanel.add(dTextField);
		}
		{
			JLabel dLabel = new JLabel("일");
			dLabel.setBounds(235, 10, 20, 15);
			contentPanel.add(dLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 날짜
						try {
							String date = String.format("%s-%s-%s", yTextField.getText(), mTextField.getText(),
									dTextField.getText());

							if (yTextField.getText().length() == 0 || mTextField.getText().length() == 0
									|| dTextField.getText().length() == 0 || getMoney.getText().length() == 0) {
								JOptionPane.showMessageDialog(GetDialog.this, "빈칸을 모두 채워주세요!", "error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								getDAO = new GetDialogDAO();

								int result = getDAO.setGetDialog(m_num, date, bigwhere.getSelectedItem().toString(),
										smallwhere.getText(), getMoney.getText());

								if (result > 0) {
									JOptionPane.showMessageDialog(GetDialog.this, "입력되었습니다.", "",
											JOptionPane.PLAIN_MESSAGE);

									GetDialog.this.dispose();
								} else {
									JOptionPane.showMessageDialog(GetDialog.this, "다시 확인해주세요!", "error",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						} catch (NumberFormatException e3) {
							JOptionPane.showMessageDialog(GetDialog.this, "다시 확인해주세요!", "error",
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
						// cancel 버튼은 그냥 창이 닫힌다.
						GetDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
