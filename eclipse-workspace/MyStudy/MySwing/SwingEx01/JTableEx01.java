package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableEx01 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableEx01 frame = new JTableEx01();
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
	public JTableEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 31, 459, 93);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("click");
//				System.out.println(table.getSelectedColumn());
//				System.out.println(table.getSelectedRow());
				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				
			}
		});
		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"1", "2", "3", "4", "5"},
//				{"6", "7", "8", "9", "10"},
//				{"11", "12", "13", "14", "15"},
//				{"16", "17", "18", "19", "20"},
//			},
//			new String[] {
//				"\uCEEC\uB7FC1", "\uCEEC\uB7FC2", "\uCEEC\uB7FC3", "\uCEEC\uB7FC4", "\uCEEC\uB7FC5"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table.setModel(new CustomTableModel());
	}
}
