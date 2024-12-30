package Score.pkg;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;

public class DBAPP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBAPP frame = new DBAPP();
					frame.setResizable(false); 
					frame.setLocationRelativeTo(null);
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
	public DBAPP( ) {

		
		InitCompounds() ; 
		
		
	
	}
	
	
	private void  logIn() { 
		OptionWindow LI = new OptionWindow ();
		LI.setVisible(true);
		this.setVisible(false); 
		
		
	}

	public void	InitCompounds () { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setVisible(true); 
		
	
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.highlight"));
		panel.setBounds(25, 25, 593, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("A database containing geospatial information, as well as SAT");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(102, 96, 385, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" average scores and Free-or-Reduced-Price Meal eligibility data\n");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(95, 114, 480, 37);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("California School SAT Performance and Poverty Data");
		lblNewLabel.setBounds(67, 23, 480, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(213, 176, 161, 50);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn(); 
				
		
			
			
				}
		});
	}
	
}
