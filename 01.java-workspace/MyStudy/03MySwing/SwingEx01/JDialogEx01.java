package SwingEx01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class JDialogEx01 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogEx01 frame = new JDialogEx01();
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
	public JDialogEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JFrame의 정보를 JDialog로 줄 때 => JFrame->초기화->JDialog
				// JDialog의 정보를 JFrame으로 줄 때 => 리턴(처리 결과) JDialog->처리결과->JFrame
				// -> setter/getter 메소드를 이용하여 초기화와 처리결과를 줌
				
				JDialogEx01_1 dialog = new JDialogEx01_1();
				// JFrame의 정보를 JDialog로 줄 때 
				dialog.setData("초기화 데이터");
				
				// X버튼을 눌렀을 때 자동적으로 꺼지는 기능
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				System.out.println("1");
				// Modal기능(dialog가 켜있는동안은 Frame을 선택할 수 없음.)
				dialog.setModal(true);
				System.out.println("2");
				// dialog 창 실제로 보이게하기
				dialog.setVisible(true);
				System.out.println("3");
				// JDialog의 정보를 JFrame으로 줄 때
				System.out.println(dialog.getData());
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 색선택을 하게 해주는 Dialog
				// JColorChooser.showDialog(JDialogEx01.this, "팔레트", Color.RED);
				// showDialog의 리턴값은 Color객체이다. 선택한 색을 보고싶다면 Color에 넣어서 빼주자.
				Color color = JColorChooser.showDialog(JDialogEx01.this, "팔레트", Color.RED);
				// System.out.println(color);
				if (color == null) {
					System.out.println("취소나 X 선택");
				} else {
					System.out.println(color.getRed());
					System.out.println(color.getGreen());
					System.out.println(color.getBlue());
				}
			}
		});
		btnNewButton_1.setBounds(12, 45, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("전경색");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(JDialogEx01.this, "전경색", Color.RED);
				if (color == null) {
					System.out.println("취소나 X 선택");
				} else {
					lbl.setForeground(color);
				}
				
			}
		});
		btnNewButton_2.setBounds(12, 78, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("배경색");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(JDialogEx01.this, "배경색", Color.RED);
				if (color == null) {
					System.out.println("취소나 X 선택");
				} else {
					lbl.setBackground(color);
				}
				
			}
		});
		btnNewButton_3.setBounds(121, 78, 97, 23);
		contentPane.add(btnNewButton_3);
		
		lbl = new JLabel("색상바꾸기");
		lbl.setOpaque(true);
		lbl.setBounds(230, 66, 181, 46);
		contentPane.add(lbl);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 외부의 파일 읽어오기(실제로 읽어오는것은 I/O를 이용하고 파일의 경로를 받아오는것이다.)
				// 파일 경로찾기 1.열기옵션 2.저장옵션
				// 1.열기옵션 - 기본적으로 윈도우에서는 찾기창이 열리는곳은 document 내문서부분이다.
				// 만약 바꾸고싶다면 경로를 따로 적어주자.
				JFileChooser fileChooser = new JFileChooser("c:\\java");
				int result = fileChooser.showOpenDialog(JDialogEx01.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("정상");
					// 제대로 경로가 선택되었을 때의 파일 경로를 받아오자.
					// getSelectedFile은 결과를 File객체로 반환하고, getAbsolutePath는 경로를 String으로 반환한다.
					System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("취소");
				} else {
					System.out.println("에러");
				}
			}
		});
		btnNewButton_4.setBounds(12, 130, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 2.저장옵션
				JFileChooser fileChooser = new JFileChooser("c:\\java");
				int result = fileChooser.showSaveDialog(JDialogEx01.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("정상");
					System.out.println(
							fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnNewButton_5.setBounds(121, 130, 97, 23);
		contentPane.add(btnNewButton_5);
	}
}
