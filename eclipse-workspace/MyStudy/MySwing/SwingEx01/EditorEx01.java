package SwingEx01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ScrollPaneConstants;

public class EditorEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorEx01 frame = new EditorEx01();
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
	public EditorEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("자바 파일 열기");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 누르면 파일을 열게해준다.
				JFileChooser fileChooser = new JFileChooser("C:\\java\\TestFile");
				int result = fileChooser.showOpenDialog(EditorEx01.this);
				
				if (result ==JFileChooser.APPROVE_OPTION) {
					// 경로 파일의 경로를 담을 변수
					String filePath = "";
					
					filePath = fileChooser.getSelectedFile().getAbsolutePath();
					BufferedReader br = null;

					try {
						// 파일 내용 담을 변수
						String fileRead = "";

						// 파일을 외부에서 읽어온다.
						br = new BufferedReader(new FileReader(filePath));

						while ((fileRead = br.readLine()) != null) {
							// 받아온 파일 내용을 아래 텍스트아리아에 열어준다.
							textArea.append(fileRead + "\r\n");
						}
						
					} catch (FileNotFoundException e1) {
						System.out.println("[error1] : " + e1.getMessage());
					} catch (IOException e1) {
						System.out.println("[error2] : " + e1.getMessage());
					} finally {
						if (br != null) {try {br.close();} catch (IOException e1) {}}
					}
					
				}
				System.out.println("읽기 완료");
			}
		});
		btn1.setBounds(12, 10, 123, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("자바 파일 저장");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//버튼을 누르면 파일을 저장한다.
				
				// textArea의 내용을 받아올 변수.
				String fileWrite = textArea.getText();
				
				JFileChooser fileChooser = new JFileChooser("C:\\java\\TestFile");
				int result = fileChooser.showSaveDialog(EditorEx01.this);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					// 파일을 저장할 곳의 경로 + 파일 이름
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();

					BufferedWriter bw = null;
					
					try {
						bw = new BufferedWriter(new FileWriter(filePath));
						// textArea의 내용을 파일에 적어준다.
						bw.write(fileWrite);
					} catch (IOException e1) {
						System.out.println("[error 3] : " + e1.getMessage());
					} finally {
						if (bw != null) {try {bw.close();} catch (IOException e1) {}}
					}
				}
				System.out.println("저장 완료");
			}
		});
		btn2.setBounds(166, 10, 123, 23);
		contentPane.add(btn2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 43, 461, 485);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
