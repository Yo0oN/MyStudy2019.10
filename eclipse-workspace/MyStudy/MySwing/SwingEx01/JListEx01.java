package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JListEx01 extends JFrame {

	private JPanel contentPane;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListEx01 frame = new JListEx01();
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
	public JListEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 10, 399, 272);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(list);
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"사과", "딸기", "수박", "키위", "사과", "딸기", "수박", "키위", "사과", "딸기", "수박", "키위", "사과", "딸기", "수박", "키위", "사과", "딸기", "수박", "키위"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		list.setModel(new CustomJListModelEx01());
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 목록에서 몇번째인지 알려줌(시작은 0번)
				System.out.println(list.getSelectedIndex());
				// 선택한 값을 알려줌.
				System.out.println((String)list.getSelectedValue());
			}
		});
		btnNewButton.setBounds(364, 368, 97, 23);
		contentPane.add(btnNewButton);
	}
}
