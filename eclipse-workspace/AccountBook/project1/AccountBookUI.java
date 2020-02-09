import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class AccountBookUI extends JFrame {
	private JTextField leftmoneyTextField;
	private JTextField usemoneyTextField;
	private JTextField myID;
	private JTextField myjoindate;
	private JTextField yTextField;
	private JTextField mTextField;
	private JTextField dTextField;
	private JTextField outIDT;
	private JTextField getmoneyTextField;
	private JTextField useYTextField;
	private JTextField useMTextField;
	private JCheckBox useMoneyCheck;
	private JCheckBox getMoneyCheck;
	private JPasswordField outpasswordT;
	private JTable table;
	private JTable useStatsTable;
	private JTable getStatsTable;

	private UseDialog useDialog;
	private GetDialog getDialog;
	private MainDAO mainDAO = new MainDAO();
	private Date ndate = new Date();
	private String m_ID;
	private int m_num;

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public void setM_ID(String m_ID) {
		this.m_ID = m_ID;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 창은 보이지 않고 메인창을 먼저 실행
					AccountBookUI frame = new AccountBookUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void Login() {
		// 메인창이 실행되면 로그인창이 실행되면서 보임
		LogInDialog loginDialog = new LogInDialog(this);
		loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		loginDialog.setModal(true);
		loginDialog.setVisible(true);

		// x버튼누르면 전부 종료
		if (m_ID == null) {
			this.dispose();
		} else {
			setVisible(true);
		}
//		setVisible(true);
	}

	public AccountBookUI() {
		this.Login();
		
		setTitle("가계부");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 424);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 14, 885, 331);
		contentPane.add(tabbedPane);

		JPanel main = new JPanel();
		tabbedPane.addTab("main", null, main, null);
		main.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 10, 250, 282);
		main.add(panel_1);
		panel_1.setLayout(null);

		JLabel getmoneyLabel = new JLabel("수입 : ");
		getmoneyLabel.setBounds(22, 26, 45, 15);
		panel_1.add(getmoneyLabel);

		getmoneyTextField = new JTextField();
		getmoneyTextField.setText(mainDAO.GetMoney(m_num));
		getmoneyTextField.setEditable(false);
		getmoneyTextField.setColumns(10);
		getmoneyTextField.setBounds(68, 23, 142, 21);
		panel_1.add(getmoneyTextField);

		JLabel usemoneyLabel = new JLabel("지출 : ");
		usemoneyLabel.setBounds(22, 54, 45, 15);
		panel_1.add(usemoneyLabel);

		usemoneyTextField = new JTextField();
		usemoneyTextField.setEditable(false);
		usemoneyTextField.setBounds(68, 51, 142, 21);
		panel_1.add(usemoneyTextField);
		usemoneyTextField.setText(mainDAO.UseMoney(m_num));
		usemoneyTextField.setColumns(10);

		JLabel leftmoneyLabel = new JLabel("잔액 : ");
		leftmoneyLabel.setBounds(22, 82, 45, 15);
		panel_1.add(leftmoneyLabel);

		leftmoneyTextField = new JTextField();
		leftmoneyTextField.setEditable(false);
		leftmoneyTextField.setBounds(68, 79, 142, 21);
		panel_1.add(leftmoneyTextField);
		leftmoneyTextField.setText(mainDAO.LeftMoney(m_num));
		leftmoneyTextField.setColumns(10);

		JButton usemoneyButton = new JButton("지출");
		usemoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useDialog = new UseDialog();
				useDialog.setM_num(m_num);

				useDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				useDialog.setModal(true);
				useDialog.setVisible(true);

				leftmoneyTextField.setText(mainDAO.LeftMoney(m_num));
				usemoneyTextField.setText(mainDAO.UseMoney(m_num));

				String date = String.format("%s-%s-%%", ndate.getYear() + 1900, ndate.getMonth() + 1);
				table.setModel(new AccountBookAllTableModel(m_num, date));
			}
		});
		usemoneyButton.setBounds(34, 121, 82, 21);
		panel_1.add(usemoneyButton);

		JButton getmoneyButton = new JButton("수입");
		getmoneyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDialog = new GetDialog();
				getDialog.setM_num(m_num);

				getDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				getDialog.setModal(true);
				getDialog.setVisible(true);

				leftmoneyTextField.setText(mainDAO.LeftMoney(m_num));
				getmoneyTextField.setText(mainDAO.GetMoney(m_num));

				String date = String.format("%s-%s-%%", ndate.getYear() + 1900, ndate.getMonth() + 1);
				table.setModel(new AccountBookAllTableModel(m_num, date));
			}
		});
		getmoneyButton.setBounds(128, 121, 82, 21);
		panel_1.add(getmoneyButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 39, 603, 249);
		main.add(scrollPane);

		table = new JTable();
		String date = String.format("%s-%s-%%", ndate.getYear() + 1900, ndate.getMonth() + 1);
		table.setModel(new AccountBookAllTableModel(m_num, date));

		scrollPane.setViewportView(table);

		yTextField = new JTextField();
		yTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		String textFieldY = ndate.getYear() + 1900 + "";
		yTextField.setText(textFieldY);
		yTextField.setBounds(267, 12, 52, 21);
		main.add(yTextField);
		yTextField.setColumns(10);

		JLabel getYLabel = new JLabel("년");
		getYLabel.setBounds(325, 15, 19, 15);
		main.add(getYLabel);

		mTextField = new JTextField();
		String textFieldMonth = ndate.getMonth() + 1 + "";
		mTextField.setText(textFieldMonth);
		mTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		mTextField.setColumns(10);
		mTextField.setBounds(356, 12, 52, 21);
		main.add(mTextField);

		JLabel getMLabel = new JLabel("월");
		getMLabel.setBounds(413, 15, 19, 15);
		main.add(getMLabel);

		dTextField = new JTextField();
		String textFieldDate = ndate.getDate() + "";
		dTextField.setText(textFieldDate);
		dTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		dTextField.setColumns(10);
		dTextField.setBounds(438, 12, 52, 21);
		main.add(dTextField);

		JLabel getDLabel = new JLabel("일");
		getDLabel.setBounds(494, 15, 19, 15);
		main.add(getDLabel);

		useMoneyCheck = new JCheckBox("지출");
		useMoneyCheck.setBounds(517, 11, 65, 23);
		main.add(useMoneyCheck);

		getMoneyCheck = new JCheckBox("수입");
		getMoneyCheck.setBounds(586, 10, 65, 23);
		main.add(getMoneyCheck);

		JButton serchButton = new JButton("검색");
		serchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String date = yTextField.getText() + "-" + mTextField.getText() + "-" + dTextField.getText() + "%";

				if (yTextField.getText().length() == 0 || mTextField.getText().length() == 0) {
					// 빈칸있으면 경고창
					JOptionPane.showMessageDialog(AccountBookUI.this, "날짜를 확인하세요!", "error", JOptionPane.ERROR_MESSAGE);
				} else if (useMoneyCheck.isSelected() == false && getMoneyCheck.isSelected() == false) {
					// 지출 수입체크도 선택되어야함.
					JOptionPane.showMessageDialog(AccountBookUI.this, "지출, 수입을 선택하세요!", "error", JOptionPane.ERROR_MESSAGE);
				} else {
					// 조건이 제대로 다 맞으면 검색시작
					if (useMoneyCheck.isSelected() == true && getMoneyCheck.isSelected() == false) {
						// 지출만선택
						table.setModel(new AccountBookUseTableModel(m_num, date));
					} else if (useMoneyCheck.isSelected() == false && getMoneyCheck.isSelected() == true) {
						// 수입만 선택
						table.setModel(new AccountBookGetTableModel(m_num, date));
					} else {
						// 둘다 선택
						table.setModel(new AccountBookAllTableModel(m_num, date));
					}
				}
			}
		});

		serchButton.setBounds(659, 10, 82, 23);
		main.add(serchButton);

		JButton button_2 = new JButton("초기화");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String date = String.format("%s-%s-%%", ndate.getYear() + 1900, ndate.getMonth() + 1);

				yTextField.setText(ndate.getYear() + 1900 + "");
				mTextField.setText(ndate.getMonth() + 1 + "");
				dTextField.setText("");
				table.setModel(new AccountBookAllTableModel(m_num, date));
			}
		});
		button_2.setBounds(757, 10, 82, 23);
		main.add(button_2);

		JPanel stats = new JPanel();
		tabbedPane.addTab("통계", null, stats, null);
		stats.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 41, 846, 251);
		stats.add(panel);
		panel.setLayout(null);

		JLabel useStatsLabel = new JLabel("지출");
		useStatsLabel.setBounds(6, 17, 36, 15);
		panel.add(useStatsLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 37, 411, 204);
		panel.add(scrollPane_1);

		useStatsTable = new JTable();
		useStatsTable.setShowGrid(false);
		String dateT = String.format("%s-%s-%%", ndate.getYear() + 1900, ndate.getMonth() + 1);
		useStatsTable.setModel(new StatsUseTableModel(m_num, dateT));
		scrollPane_1.setViewportView(useStatsTable);

		JLabel getStatsLabel = new JLabel("수입");
		getStatsLabel.setBounds(429, 17, 36, 15);
		panel.add(getStatsLabel);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(429, 37, 411, 204);
		panel.add(scrollPane_2);

		getStatsTable = new JTable();
		getStatsTable.setShowGrid(false);
		getStatsTable.setModel(new StatsGetTableModel(m_num, date));
		scrollPane_2.setViewportView(getStatsTable);

		useYTextField = new JTextField();
		useYTextField.setBounds(12, 10, 36, 21);
		stats.add(useYTextField);
		useYTextField.setColumns(10);

		useMTextField = new JTextField();
		useMTextField.setBounds(73, 10, 36, 21);
		stats.add(useMTextField);
		useMTextField.setColumns(10);

		JLabel useYLabel = new JLabel("년");
		useYLabel.setBounds(52, 13, 21, 15);
		stats.add(useYLabel);

		JLabel useMLabel = new JLabel("월");
		useMLabel.setBounds(113, 13, 21, 15);
		stats.add(useMLabel);

		JButton searchStatsButton = new JButton("검색");
		searchStatsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 클릭하면 해당 월의 통계를 알려준다.
					String date = String.format("%s-%s-%%", useYTextField.getText(), useMTextField.getText());
					if (useYTextField.getText().length() == 0 || useMTextField.getText().length() == 0) {
						JOptionPane.showMessageDialog(AccountBookUI.this, "다시 확인하세요!", "error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						getStatsTable.setModel(new StatsGetTableModel(m_num, date));
						useStatsTable.setModel(new StatsUseTableModel(m_num, date));
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(AccountBookUI.this, "다시 확인하세요!", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchStatsButton.setBounds(136, 9, 68, 23);
		stats.add(searchStatsButton);

		JTabbedPane mypage = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("mypage", null, mypage, null);

		JPanel user = new JPanel();
		mypage.addTab("계정 관리", null, user, null);
		user.setLayout(null);

		JLabel myIDLabel = new JLabel("아이디");
		myIDLabel.setBounds(12, 10, 57, 15);
		user.add(myIDLabel);

		myID = new JTextField();
		myID.setHorizontalAlignment(SwingConstants.LEFT);
		myID.setEditable(false);
		myID.setText(m_ID);
		myID.setBounds(77, 7, 260, 21);
		user.add(myID);
		myID.setColumns(10);

		JLabel myjoindateLabel = new JLabel("가입일");
		myjoindateLabel.setBounds(12, 38, 57, 15);
		user.add(myjoindateLabel);

		myjoindate = new JTextField();
		myjoindate.setText(mainDAO.getMyData(m_num));
		myjoindate.setHorizontalAlignment(SwingConstants.LEFT);
		myjoindate.setEditable(false);
		myjoindate.setColumns(10);
		myjoindate.setBounds(77, 35, 260, 21);
		user.add(myjoindate);

		JButton changepassword = new JButton("비밀번호 변경");
		changepassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼 누르면 비밀번호 바꿔주는 창 생성
				ChagePasswordDialog cpd = new ChagePasswordDialog();
				cpd.setM_ID(m_ID);
				cpd.setM_num(m_num);

				cpd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				cpd.setModal(true);
				cpd.setVisible(true);

			}
		});

		changepassword.setBounds(207, 66, 129, 23);
		user.add(changepassword);

		JPanel out = new JPanel();
		mypage.addTab("회원 탈퇴", null, out, null);
		out.setLayout(null);

		JButton btnNewButton = new JButton("탈퇴");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 아이디와 비번이 맞으면 탈퇴
				OutDAO outDAO = new OutDAO();
				if (m_ID.equals(outIDT.getText()) && outDAO.checkPassword(m_num).equals(outpasswordT.getText())) {
					int result = JOptionPane.showConfirmDialog(AccountBookUI.this, "탈퇴하시겠습니까?", "",
							JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						outDAO = new OutDAO();
						outDAO.deleteData(m_num);
						dispose();
						new AccountBookUI();
					}
				} else {
					// 아니면 알림창
					JOptionPane.showMessageDialog(AccountBookUI.this, "아이디와 비밀번호가 틀립니다.");
				}
			}
		});
		btnNewButton.setBounds(255, 69, 84, 23);
		out.add(btnNewButton);

		JLabel outIDL = new JLabel("아이디");
		outIDL.setBounds(14, 13, 57, 15);
		out.add(outIDL);

		outIDT = new JTextField();
		outIDT.setHorizontalAlignment(SwingConstants.LEFT);
		outIDT.setColumns(10);
		outIDT.setBounds(79, 10, 260, 21);
		out.add(outIDT);

		JLabel outPasswordL = new JLabel("비밀번호");
		outPasswordL.setBounds(14, 41, 57, 15);
		out.add(outPasswordL);

		outpasswordT = new JPasswordField();
		outpasswordT.setBounds(79, 41, 260, 21);
		out.add(outpasswordT);

		JButton btnNewButton_1 = new JButton("로그아웃");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭하면 로그아웃
				dispose();
				AccountBookUI frame = new AccountBookUI();
			}
		});
		btnNewButton_1.setBounds(807, 346, 90, 23);
		contentPane.add(btnNewButton_1);

		JLabel welcome = new JLabel("환영합니다! " + m_ID + "님!");
		welcome.setBounds(597, 14, 185, 15);
		contentPane.add(welcome);

	}
}
