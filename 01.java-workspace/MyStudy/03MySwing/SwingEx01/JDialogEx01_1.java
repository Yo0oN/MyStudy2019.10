package SwingEx01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogEx01_1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	

	/**
	 * Launch the application.
	 */
//	아래의 main은 테스트용이다.
//	실제로는 Frame쪽에서 무언가 행동을 해야만 Dialog가 뜨기 때문에 아래의 main은 주석처리해놓자.
//	public static void main(String[] args) {
//		try {
//			JDialogEx01_1 dialog = new JDialogEx01_1();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	/**
	 * Create the dialog.
	 */
	public JDialogEx01_1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 창 닫기 기능
						// Dialog는 Frame의 내부클래스이기 때문에 호출해주어야함?
						JDialogEx01_1.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
