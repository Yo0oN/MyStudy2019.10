package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;

public class JFrameEx06 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx06 frame = new JFrameEx06();
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
	public JFrameEx06() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 800, 600));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(12, 10, 97, 23);
		contentPane.add(btn1);
		// 동작(이벤트)를 주게하고싶다.
		// callback메소드. 행동을 적어주면, 시스템이 동작을 감지하고 출력함
		btn1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseReleased");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("MousePressed");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseExited");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseEntered");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("mouseClicked");
			}
		});
		
		JButton btn2 = new JButton("<html><font color='red'>Hello!</font><br/><font color='green'>Hello!</font></html>");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn2.setBackground(SystemColor.menu);
		btn2.setBounds(12, 43, 97, 39);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBackground(Color.WHITE);
		btn3.setIcon(new ImageIcon("C:\\Users\\kitcoop\\OneDrive\\Java\\eclipse\\eclipse-workspace\\SwingEx01\\src\\Naver.png"));
		btn3.setBounds(12, 92, 75, 72);
		contentPane.add(btn3);
	}

}
