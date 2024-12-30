package Score.pkg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class signUp extends JFrame {



		private JPanel contentPane;
		private JTextField txtUsername;
		private JTextField txtLastName;
		private JTextField txtmail;
		private JPasswordField password1;
		private JPasswordField password2;
		private JLabel lblPassword;
		private JLabel lblUWC;
		private JLabel lblLastName;
		private JLabel lblUsername;
		private JLabel lblPasswordConfirmation;
		private JButton btnRegister;
		private JLabel lblValidation;
		
		private String name;
		private String lastName;
		private String uwcMail;
		
		
		private File f;
		int line;
		private JLabel lblMin;
		
		
		
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement pst = null;
	    private EmailValidator emailValidator = new EmailValidator();

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						signUp frame = new signUp();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
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
		public signUp() {

			
			con = SQLSignUp.COnnecrDB(); 
			
			
			GUI();
		
		}
		   public void GUI() {
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setBounds(100, 100, 423, 639);
		        contentPane = new JPanel();
		        contentPane.setBackground(new Color(0, 139, 139));
		        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        setContentPane(contentPane);
		        contentPane.setLayout(null);

		        JPanel panel = new JPanel();
		        panel.setBackground(Color.WHITE);
		        panel.setBounds(26, 25, 367, 558);
		        contentPane.add(panel);
		        panel.setLayout(null);

		        JLabel lblNewLabel = new JLabel("Sign Up to DATABASE");
		        lblNewLabel.setBounds(31, 38, 310, 30);
		        panel.add(lblNewLabel);
		        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 29));

		        txtmail = new JTextField();
		        txtmail.setBackground(new Color(240, 255, 255));
		        txtmail.setBounds(31, 206, 248, 26);
		        panel.add(txtmail);
		        txtmail.setColumns(10);

		        txtUsername = new JTextField();
		        txtUsername.setBackground(new Color(240, 255, 255));
		        txtUsername.setBounds(28, 136, 130, 26);
		        panel.add(txtUsername);
		        txtUsername.setColumns(10);

		        txtLastName = new JTextField();
		        txtLastName.setBackground(new Color(240, 255, 255));
		        txtLastName.setBounds(186, 136, 130, 26);
		        panel.add(txtLastName);
		        txtLastName.setColumns(10);

		        JLabel lblUsername = new JLabel("Username");
		        lblUsername.setFont(new Font("Arial", Font.PLAIN, 13));
		        lblUsername.setBounds(28, 107, 85, 16);
		        panel.add(lblUsername);

		        JLabel lblLastName = new JLabel("Last Name");
		        lblLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		        lblLastName.setBounds(186, 108, 91, 16);
		        panel.add(lblLastName);

		        JLabel lblUWC = new JLabel("E-mail Address: ");
		        lblUWC.setFont(new Font("Arial", Font.PLAIN, 13));
		        lblUWC.setBounds(28, 180, 96, 16);
		        panel.add(lblUWC);

		        JLabel lblPassword = new JLabel("Create new password: ");
		        lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		        lblPassword.setBounds(31, 257, 234, 16);
		        panel.add(lblPassword);

		        password1 = new JPasswordField();
		        password1.setBackground(new Color(240, 255, 255));
		        password1.setBounds(31, 285, 188, 26);
		        panel.add(password1);

		        JLabel lblPasswordConfirmation = new JLabel("Confirm password: ");
		        lblPasswordConfirmation.setFont(new Font("Arial", Font.PLAIN, 13));
		        lblPasswordConfirmation.setBounds(31, 355, 138, 16);
		        panel.add(lblPasswordConfirmation);

		        password2 = new JPasswordField();
		        password2.setBackground(new Color(240, 255, 255));
		        password2.setBounds(31, 383, 188, 26);
		        panel.add(password2);

		        JButton btnRegister = new JButton("Register ");
		        btnRegister.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        	
		        		
		        		collectInfo(); 
		        		error();
	            		
	            	
	            
		        	}
		        });
		        btnRegister.setBounds(31, 442, 109, 43);
		        panel.add(btnRegister);
		        btnRegister.setBackground(new Color(51, 51, 255));
		      
		        btnRegister.setForeground(Color.BLUE);
		        
		        JButton btnCancel_1 = new JButton("Cancel");
		        btnCancel_1.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		
		        		cancel(); 
		        	}
		        });
		        btnCancel_1.setForeground(Color.BLUE);
		        btnCancel_1.setBackground(new Color(51, 51, 255));
		        btnCancel_1.setBounds(207, 442, 109, 43);
		        panel.add(btnCancel_1);

		        JButton btnCancel = new JButton("Back");
		        btnCancel.addActionListener(e -> cancel());
		        btnCancel.setBackground(Color.LIGHT_GRAY);
		        btnCancel.setForeground(new Color(51, 51, 255));
		        btnCancel.setBounds(210, 442, 109, 43);
		       
		   }
		
		public void cancel () {
			LogIn LI = new LogIn(); 
			LI.setVisible(true); 
			this.setVisible(false); 
		}

		
	   
		
		public void  emailValidator () { 
			
		emailValidator = new EmailValidator();
		   if(!emailValidator.validate(txtmail.getText().trim())) {
			   
			   lblValidation.setForeground(new Color(255, 0, 0)); 
		       lblValidation.setText("Invalid E-mail adress");
		    
		}
		    
		   else { 
			   lblValidation.setForeground(new Color(0, 255, 0)); 
			   lblValidation.setText( "Valid E-mail adress ");
			   
		   }
		   
		 
		
		        
		   }


		
		
				
				
			
		
				public void  logIn () {
					 
					LogIn LI = new  LogIn () ; 
					LI.setVisible (true); 
					this.setVisible(false);
					
				}
				
				  private void collectInfo() {
						
					  DataModel dataModel = DataModelSingleton.getInstance();
					
					  dataModel.setName1(txtUsername.getText());
					  dataModel.setLastName(txtLastName.getText());
					  dataModel.setPassword(new String(password1.getPassword()));
					  dataModel.setPassword1(new String(password2.getPassword()));
					  dataModel.setEmail(txtmail.getText()); 
				  }
				
		private void Register() {
			
			collectInfo(); 
			
			 DataModel dataModel = DataModelSingleton.getInstance();
				
			
			 try {
				 Connection con = SQLSignUp.COnnecrDB();
					 String query ="INSERT INTO Personal_Info (Name, Last_Name, Pasword1, Password2,  email) values (?,?, ?, ?, ?)";

			        pst = con.prepareStatement(query);
			       pst.setString(1, dataModel.getName1());
			       pst.setString(2, dataModel.getLastName());
			       pst.setString(3, dataModel.getPassword());
			       pst.setString(4, dataModel.getPassword1());
			       pst.setString(5, dataModel.getEmail());
		            // Secure way to get password from JPasswordField
		          //  pst.setString(3, new String(password1.getPassword()));
		        
		            pst.execute();
		            
		            pst.close(); 

		            JOptionPane.showMessageDialog(null, "Registration successful!");
		            
		            
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Registration failed: " + e.getMessage());
		        }
		    }
		
		private void error() {
			   // Check for empty fields
	        if (txtUsername.getText().isEmpty() || txtLastName.getText().isEmpty() ||
	                new String(password1.getPassword()).isEmpty() ||
	                new String(password2.getPassword()).isEmpty() ||
	                txtmail.getText().isEmpty()) {

	            JOptionPane.showMessageDialog(null, "Please fill all the fields.");
	            return;
	        }

	        // Validate email
	        if (!emailValidator.validate(txtmail.getText().trim())) {
	            JOptionPane.showMessageDialog(null, "Invalid Email Address.");
	            return;
	        }

	        // Validate passwords
	        if (!new String(password1.getPassword()).equals(new String(password2.getPassword()))) {
	            JOptionPane.showMessageDialog(null, "Passwords do not match.");
	            return;
	        }

	        // Additional password criteria (optional)
	        if (new String(password1.getPassword()).length() < 6) {
	            JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long.");
	            return;
	        } else {
	        	cancel(); 
	        }
	    }
		}	
