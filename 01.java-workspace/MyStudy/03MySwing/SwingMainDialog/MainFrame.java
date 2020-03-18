package SwingMainDialog;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
	
	private String data;
	private JPanel contentPane;

	
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				try {
//					SubDialogEx01 dialog = new SubDialogEx01();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(12, 43, 97, 23);
		contentPane.add(btnNewButton_1);
		
		
		//
		//SubDialogEx01 dialog = new SubDialogEx01();
		SubDialogEx01 dialog = new SubDialogEx01(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		
		dialog.setVisible(true);
		System.out.println("MainFrame : " + this);
//		this.setData("MainFrame 데이터1");
		
//		dialog.setMainFrame(this);
		
//		System.out.println("MainFrame : " + dialog.getMainFrame());
//		System.out.println(dialog.getMainFrame().getData());
		System.out.println(getData());
		
		setVisible(true);
	}
}
