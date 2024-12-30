package Score.pkg;


import java.io.File; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class LogIn extends JFrame {

	private JPanel contentPane;
	
	private DB parent; 
	private JPasswordField txtpassword;

	private JButton signUp;

	private JButton logIn;

	private JLabel userName;

	private JLabel password;

	private JPanel panel;
	;
	int line;
	int iv;

	private JTextPane txtUsername;
	private JLabel lblMessage;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	
	
	  Connection con= null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
	
		con = SQLSignUp.COnnecrDB(); 
        initComponents();   
        
		
	}
		
		public void initComponents() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have and account yet? ");
		lblNewLabel_3.setBounds(543, 192, 249, 22);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 452, 476);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setBounds(115, 335, 208, 16);
		panel.add(lblMessage);
		
		JLabel lblNewLabel = new JLabel("Welcome to TestTracker App");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(39, 66, 407, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 35));
		
		logIn = new JButton("Log in");
		logIn.setBorder(new LineBorder(Color.WHITE));
		logIn.setBounds(166, 395, 117, 29);
		panel.add(logIn);
		logIn.setBackground(new Color(255, 255, 255));
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(113, 272, 208, 31);
		panel.add(txtpassword);
		
		password = new JLabel("Insert your password: ");
		password.setBounds(115, 244, 181, 16);
		panel.add(password);
		
		txtUsername = new JTextPane();
		txtUsername.setBounds(115, 196, 202, 22);
		panel.add(txtUsername);
		
		userName = new JLabel("Insert your username: ");
		userName.setBounds(115, 158, 170, 16);
		panel.add(userName);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/naran128386/Downloads/pro (1).png"));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(322, 191, 28, 37);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/naran128386/Downloads/pass (1).png"));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			
			
		
			public void mouseClicked(MouseEvent e) {
				
				
				showPass(txtpassword); 
			}
		});
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblNewLabel_5.setBounds(322, 269, 29, 36);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Forgot Password? ");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			
		RE(); 
				
			}
		});
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setBounds(30, 343, 170, 29);
		panel.add(lblNewLabel_6);
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn(); 
				
				
			}
		});
		
		signUp = new JButton("Sign up");
		signUp.setBorder(new LineBorder(Color.BLACK));
		signUp.setBounds(600, 280, 117, 29);
		contentPane.add(signUp);
		
		lblNewLabel_2 = new JLabel("Sign up for free!");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(590, 208, 202, 60);
		contentPane.add(lblNewLabel_2);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		
		
		
	}

	public void  setVisible (boolean visible) { 
		if (visible  ==  true) { 
		}
		super.setVisible(visible); 
		
	}
	


	
	public void  signUp() {
		
		signUp SU = new signUp(); 
		
		SU.setVisible(true); 
		this.setVisible(false); 
			
	}
	
	   

	private void logIn() {
	    String username = txtUsername.getText();
	    String pass = new String(txtpassword.getPassword()); // Use getPassword() for char[]

	    try {
	        String query = "SELECT Name, Pasword1 FROM Personal_Info WHERE Name = ?";
	        pst = con.prepareStatement(query);
	        pst.setString(1, username);
	        rs = pst.executeQuery();

	        if (rs.next()) {
	            String storedPassword = rs.getString("Pasword1");
	            if (pass.equals(storedPassword)) {
	                DDAA();
	            } else {
	                JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Username not found.");
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pst != null) pst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

 private void DDAA () {
	 DBAPP s = new DBAPP(); 
     s.setVisible(true); 
     this.setVisible(false);
 }
 
 private void RE() {
		
	 
	 RecoverMail RF = new RecoverMail (); 
		RF.setVisible(true);
		this.setVisible(false);
		

 }
private void showPass(JPasswordField txtpassword) {
	
    char echoChar = txtpassword.getEchoChar();
   
    if (echoChar == '\0') {
    	
    	txtpassword.setEchoChar('*');
    } else {
    	
    	txtpassword.setEchoChar('\0'); 
    }
}
	
	
	
}

