package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSpinnerEx01 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner;
	private JSpinner spinner2;
	private JSpinner spinner_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSpinnerEx01 frame = new JSpinnerEx01();
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
	public JSpinnerEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] items = {"사과", "멜론", "딸기", "키위"};
		SpinnerListModel spinnerListModel = new SpinnerListModel(items);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println((String)spinner.getValue());
			}
		});
		spinner.setModel(spinnerListModel);
		
		spinner.setToolTipText("");
		spinner.setBounds(12, 30, 348, 32);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// spinner의 getValue메소드는 Object로 반환해서 형변환해주기.
				// System.out.println((String)spinner.getValue());
				System.out.println(spinner2.getValue());
			}
		});
		btnNewButton.setBounds(453, 34, 97, 23);
		contentPane.add(btnNewButton);
		
		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(50, 0, 100, 10));
		spinner2.setBounds(12, 72, 348, 32);
		contentPane.add(spinner2);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1575558000000L), new Date(1575558000000L), new Date(1796482800000L), Calendar.MONTH));
		spinner_1.setBounds(12, 113, 348, 44);
		contentPane.add(spinner_1);
	}
}
