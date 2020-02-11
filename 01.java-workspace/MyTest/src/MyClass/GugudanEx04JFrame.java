package MyClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class GugudanEx04JFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JSpinner startSpinner;
	private JSpinner endSpinner;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanEx04JFrame frame = new GugudanEx04JFrame();
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
	public GugudanEx04JFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(17, 16, 521, 92);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("시작단");
		lblNewLabel.setBounds(28, 26, 57, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("끝단");
		lblNewLabel_1.setBounds(28, 51, 57, 15);
		panel.add(lblNewLabel_1);

		startSpinner = new JSpinner();
		startSpinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		startSpinner.setBounds(97, 23, 175, 22);
		panel.add(startSpinner);

		endSpinner = new JSpinner();
		endSpinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		endSpinner.setBounds(97, 48, 175, 22);
		panel.add(endSpinner);

		JButton btnNewButton = new JButton("구구단");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// 구구단 버튼을 누르면 스피너에서 값을 가져온다.
					int start = Integer.parseInt(startSpinner.getValue().toString());
					int end = Integer.parseInt(endSpinner.getValue().toString());
					// 가져온 값을 계산하여 배열에 넣어 가져온 후 표에 넣는다.
					table.setModel(new GugudanEx04Model(start, end));
				} catch (ArrayIndexOutOfBoundsException e1) {
					// 범위입력이 잘못되었을경우 창을 띄워준다.
					JOptionPane.showMessageDialog(GugudanEx04JFrame.this,
							"시작단의 수가 끝단의 수보다 크면 안됩니다!");
				} catch (NegativeArraySizeException e1) {
					JOptionPane.showMessageDialog(GugudanEx04JFrame.this,
							"시작단의 수가 끝단의 수보다 크면 안됩니다!");
				}

			}
		});
		btnNewButton.setBounds(290, 22, 97, 44);
		panel.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 120, 521, 348);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uB2E8", "x1000", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"
			}
		));
		scrollPane.setViewportView(table);
	}
}
