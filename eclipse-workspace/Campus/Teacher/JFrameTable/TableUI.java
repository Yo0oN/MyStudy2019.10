package JFrameTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableUI frame = new TableUI();
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
	public TableUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("EMP");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new CustomTableModel("emp"));
			}
		});
		btn1.setBounds(12, 10, 313, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("우편번호");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new CustomTableModel("zipcode"));
			}
		});
		btn2.setBounds(379, 10, 313, 23);
		contentPane.add(btn2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 52, 680, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
	}
}
