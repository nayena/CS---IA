package Score.pkg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RecoverMail extends JFrame {

	private JPanel contentPane;

	private JTextField txtresult;
	private JTextField txtmail;

	

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
					RecoverMail frame = new RecoverMail();
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
	public RecoverMail() {
		con = SQLSignUp.COnnecrDB(); 
        initComponents();   
        
		
	}
		
		
		
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		contentPane.setLayout(null);
		
		txtresult = new JTextField();
	
		JScrollPane scrollPaneComment11 = new JScrollPane(txtresult);
		scrollPaneComment11.setBounds(83, 144, 292, 89);
		contentPane.add(scrollPaneComment11);
		
		txtmail = new JTextField();
	
		JScrollPane scrollPaneComment1 = new JScrollPane(txtmail);
		scrollPaneComment1.setBounds(115, 47, 219, 26);
		contentPane.add(scrollPaneComment1);

		
		JLabel lblNewLabel = new JLabel("INSERT YOUR EMAIL");
		lblNewLabel.setBounds(165, 19, 138, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Show(); 
			}
		});
		btnNewButton.setBounds(165, 95, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				back(); 
			}
		});
		btnBack.setBounds(6, 6, 44, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 155, -7, 67);
		contentPane.add(scrollPane);
	}
	  
	
	  private void back( ) { 
		  LogIn LI = new LogIn();
		  LI.setVisible(true);
		  this.setVisible(false);
		  
		  
	  }
	  private void Show() {
		  

		  String email = txtmail.getText().trim();

	        try {
	            // Prepare the SQL query
	            String sql = "SELECT Name, Pasword1 FROM Personal_Info WHERE Email=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, email);

	            // Execute the query
	            ResultSet resultSet = statement.executeQuery();

	            // Check if a result is returned
	            if (resultSet.next()) {
	                String name = resultSet.getString("Name");
	                String password = resultSet.getString("Pasword1");

	                txtresult.setText(
	                	"Hello Again!" 
	                	+ "\n"
	                	+ "\n"
	                	+ "\n"
	                	+ "\n"
	                	+  "\n"
	 	                + "Here is your user information "                                                                                                                                                                                                                                            
	                  + "Name: " + name + "\nPassword: " + password);
	            } else {
	                txtresult.setText("No matching email found.");
	            }

	            statement.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
				 
	  }
	  }
	

