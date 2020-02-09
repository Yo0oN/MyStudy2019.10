package SwingMainDialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SubDialogEx01 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private MainFrame mainFrame;
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			SubDialogEx01 dialog = new SubDialogEx01();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public SubDialogEx01() {
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
	
	public SubDialogEx01(MainFrame mainFrame) {
		this();
		this.mainFrame = mainFrame;
		this.mainFrame.setData("데이터");
	}

}
