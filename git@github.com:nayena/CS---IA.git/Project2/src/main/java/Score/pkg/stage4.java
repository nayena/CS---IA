package Score.pkg;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class stage4 extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private String lastInsertedData;

	private JButton btnback;
	private JComboBox  cbmUni;
	private JComboBox<String> UAC;

	Connection conn= null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	private JButton btnload;
	private JTextArea txtresult;
	private JButton btnNewButton_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stage4 frame = new stage4();
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
	public stage4() {
		
		
		
		
	conn = SQLSignUp.COnnecrDB(); 
		
		GUI();
		
	}
	
	private void GUI() {
		
		


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 748, 670);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 139, 139));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);
txtresult = new JTextArea();
txtresult.setBounds(207, 112, 349, 264);
contentPane.add(txtresult);
JButton btnNewButton = new JButton("BACK");
btnNewButton.setBounds(130, 518, 117, 29);
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		back();
	}
});
contentPane.add(btnNewButton);
JButton btnDone = new JButton("DONE");
btnDone.setBounds(554, 518, 117, 29);
btnDone.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		done();
		
	}
});
contentPane.add(btnDone);
btnload = new JButton("load");
btnload.setBounds(325, 57, 117, 29);
btnload.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		   DataModel dataModel = DataModelSingleton.getInstance();
		   lastInsertedData = displayLastInsertedData(dataModel);
		   txtresult.setText(lastInsertedData); // Set text to JTextArea
		load();
		//add(); 
		
	}
});
contentPane.add(btnload);
JButton btnSend = new JButton("send");
btnSend.setBounds(492, 402, 117, 29);
btnSend.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		send();
	}
});
contentPane.add(btnSend);

UAC = new JComboBox<String>();
UAC.setBounds(194, 403, 258, 27);
data();
contentPane.setLayout(null);
contentPane.add(UAC);
btnNewButton_1 = new JButton("");
btnNewButton_1.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
btnNewButton_1.setBounds(628, 27, 80, 59);
contentPane.add(btnNewButton_1);




		
	}

	
	private  void data() {
		
		UAC.addItem("SELECT YOUR UAC");
		
		

		try {

			conn = DriverManager.getConnection("jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite");

			String query = ("SELECT * from UAC");
			System.out.println("Connected");

			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				UAC.addItem(rs.getString("NAME"));

			}
			pst.close();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	
}

private String selectData() {

	 String selectedUAC = UAC.getSelectedItem().toString(); // Get selected UAC
	    String email = null;

	    try {
	        conn = DriverManager.getConnection("jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite");
	        String query = "SELECT Email from UAC WHERE NAME = ?";
	        PreparedStatement pst = conn.prepareStatement(query);
	        pst.setString(1, selectedUAC); // Set the selected UAC name
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            email = rs.getString("Email");
	        }

	        rs.close();
	        pst.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return email;
	}

	

private void send() {
	
	 String to = selectData(); // Get the email of the selected UAC
	    if (to == null) {
	        System.out.println("No UAC selected or email not found.");
	        return;
	    }
	


    // Sender's email ID needs to be mentioned
    String from = "uniapp04@gmail.com";

    // Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // Get the Session object.// and pass username and password
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("uniapp04@gmail.com", "srmd cddp ftfh bvms");

        }

    });

    // Used to debug SMTP issues
    session.setDebug(true);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: header field
        message.setSubject("This is the University App Results");
       
     
        // Now set the actual message with the last row data
        message.setText("Here is the information you requested:\n\n" + lastInsertedData);
      
        

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }

}
		  
	
private void done() {
	
	OptionWindow OW = new OptionWindow();
	
	OW.setVisible(true);
	this.setVisible(false);
	
}

private void back() { 
	
	
	stage3 s3 = new stage3(); 
	s3.setVisible(true);
	this.setVisible(false);
	
}

private void load() {
	  // Retrieve the singleton instance of DataModel
    DataModel dataModel1 = DataModelSingleton.getInstance();
    
    // Try block to handle any SQL exceptions
    try {
        // SQL query to insert data into the CALC table
        String query = "insert into CALCU(UNI, NAME, CRESIDENCE, CORIGIN, SUBJ, SCORE, ATLS, ACCOMP, ESSAY, ECOMMENT) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
       
        // Prepare the SQL statement for execution
        pst = conn.prepareStatement(query);
        
        // Set the parameters for the SQL statement using the data from the DataModel instance
        pst.setString(1, dataModel1.getUni());
        pst.setString(2, dataModel1.getName());
        pst.setString(3, dataModel1.getResidence());
        pst.setString(4, dataModel1.getOrigin());
        pst.setString(5, dataModel1.getSubjects());
        pst.setString(6, dataModel1.getScores());
        pst.setString(7, dataModel1.getAtls());
        pst.setString(8, dataModel1.getAccomp());
        pst.setString(9, dataModel1.getEssay());
        pst.setString(10, dataModel1.getComment());
        
        // Execute the SQL statement to insert data
        pst.execute();
       
        	
        ResultSet generatedKeys = pst.getGeneratedKeys();
        if (generatedKeys.next()) {
            long lastInsertedId = generatedKeys.getLong(1); // This is the generated key (id)
            // If you need to use the id elsewhere in your code, you can pass it to other methods
            useGeneratedId(lastInsertedId);
        }
        // Close the prepared statement to release database resources
        pst.close();
        
        
        
    } catch (Exception e) { // Catch block to handle exceptions
        
        // Print the stack trace for debugging purposes
        e.printStackTrace();
        
        // Show a dialog with the error message
        JOptionPane.showMessageDialog(null, e);
        // Print the error message to the console
        System.out.println(e);
    }
    // Disable the 'next' button after adding data
    btnload.setEnabled(false);

    // Dispose of the current frame, effectively closing the window
 //   dispose();
    
   
}

	private String displayLastInsertedData(DataModel dataModel) {
		
		
		load(); 
		
		StringBuilder  sb = new StringBuilder();
	    sb.append("University: ").append(dataModel.getUni()).append("\n");
	    sb.append("Name: ").append(dataModel.getName()).append("\n");
	    sb.append("Residence: ").append(dataModel.getResidence()).append("\n");
	    sb.append("Origin: ").append(dataModel.getOrigin()).append("\n");
	    sb.append("Subjects: ").append(dataModel.getSubjects()).append("\n");
	    sb.append("Score: ").append(dataModel.getScores()).append("\n");
	    sb.append("ATLS: ").append(dataModel.getAtls()).append("\n");
	    sb.append("Accomplishments: ").append(dataModel.getAccomp()).append("\n");
	    sb.append("Essay: ").append(dataModel.getEssay()).append("\n");
	    sb.append("Comments: ").append(dataModel.getComment()).append("\n");
	
	    // Assuming txtresult is a class member and already initialized
	 
	    
	    

	    return sb.toString(); // Return the string
	}
	

private void  useGeneratedId(long lastInsertedId) {
	    // You can use the id here as needed
		 try {
		        // Prepare a new query to select the last inserted row
		        String query = "SELECT * FROM CALC WHERE id = ?";
		        pst = conn.prepareStatement(query);
		        pst.setLong(1, lastInsertedId); // Use the last inserted ID to select the row
		        ResultSet rs = pst.executeQuery();

		        // Check if we got a result
		        if (rs.next()) {
		            // Assuming you have a method to format the ResultSet data as a String
		            String rowData = formatRowData(rs);
		            txtresult.setText(rowData); // Display the formatted data in the JTextArea
		        }

		        rs.close(); // Close the ResultSet
		        pst.close(); // Close the PreparedStatement

		    } catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error while retrieving the last inserted row: " + e.getMessage());
		    }
		}
private String formatRowData(ResultSet rs) throws SQLException {
    // Create a StringBuilder to build your string
    StringBuilder sb = new StringBuilder();
    // Append each column's data to the StringBuilder
    sb.append("University: ").append(rs.getString("UNI")).append("\n");
    sb.append("Name: ").append(rs.getString("NAME")).append("\n");
    // ... append other fields from the ResultSet ...
    // Return the string representation of the row
    return sb.toString();
} 
	}	
	
	
