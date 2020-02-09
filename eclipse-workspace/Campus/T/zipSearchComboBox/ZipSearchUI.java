package zipSearchComboBox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ZipSearchUI extends JFrame {
	private JPanel contentPane;
	private JComboBox combo1;
	private JComboBox combo2;
	private JComboBox combo3;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					ZipSearchUI frame = new ZipSearchUI();
					frame.setVisible( true );
				} catch( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}
	/**
	 * Create the frame.
	 */
	public ZipSearchUI() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 459, 564 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
        
		contentPane.setLayout( null );
          
		JPanel panel = new JPanel();
		panel.setBorder( new TitledBorder( UIManager.getBorder( "TitledBorder.border" ), "\uB3D9\uC774\uB984 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color( 0, 0, 0 ) ) );
		panel.setBounds( 6, 15, 427, 55 );
		contentPane.add( panel );
		panel.setLayout( null );
          
		combo1 = new JComboBox();
		combo1.addItemListener( new ItemListener() {
			public void itemStateChanged( ItemEvent e ) {
				if( e.getStateChange() == ItemEvent.SELECTED ) {
					if( combo1.getSelectedIndex() != 0) {
						combo2.setModel( new GugunComboBoxModel( (String)combo1.getSelectedItem() ) );
						combo2.setSelectedIndex( 0 );
					}
				}
			}
		} );
		combo1.setBounds( 12, 20, 129, 21 );
		panel.add( combo1 );
          
		combo2 = new JComboBox();
		combo2.addItemListener( new ItemListener() {
			public void itemStateChanged( ItemEvent e ) {
				if( e.getStateChange() == ItemEvent.SELECTED ) {
				}
			}
		} );
		combo2.setBounds( 151, 20, 129, 21 );
		panel.add( combo2 );
          
		combo3 = new JComboBox();
		combo3.addItemListener( new ItemListener() {
			public void itemStateChanged( ItemEvent e ) {
				if( e.getStateChange() == ItemEvent.SELECTED ) {
				}
			}
		} );
		combo3.setBounds( 290, 20, 129, 21 );
		panel.add( combo3 );
          
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 6, 82, 427, 434 );
		contentPane.add( scrollPane );
          
		textArea = new JTextArea();
		textArea.setEditable( false );
		scrollPane.setViewportView( textArea );
		
		combo1.setModel( new SidoComboBoxModel() );
		combo1.setSelectedIndex( 0 );
	}
}
