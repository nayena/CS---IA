package Score.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Timer; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 


public class WelcomePage extends JFrame {

	private JPanel contentPane;
	private WelcomePage welcomeFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome to your DATABASE");
		welcome.setBounds(29, 445, 816, 174);
		welcome.setFont(new Font("Arial", Font.PLAIN, 60));
		welcome.setForeground(new Color(255, 255, 255));
		contentPane.add(welcome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/naran128386/Downloads/CompSci/uni.jpeg"));
		lblNewLabel.setBounds(-29, 0, 951, 625);
		contentPane.add(lblNewLabel);
		 
	    
		Timer timer = new Timer(4000, new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				WelcomePage.this.setVisible(false); 
				

				logIn();
			
				
			}
		});
		timer.setRepeats(false); 
		timer.start(); 
	}
	
	
	
	public void logIn () {
		LogIn frame2 = new LogIn (); 
		frame2.setVisible(true);
		frame2.setResizable(false); 
		this.setVisible(false);

	}
}













