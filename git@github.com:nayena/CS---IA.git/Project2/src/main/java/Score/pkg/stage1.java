package Score.pkg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.* ;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class stage1 extends JFrame {
	
	

    private JButton uploadButton;
    
    Connection conn=null;
    ResultSet rs= null;
    PreparedStatement pst = null;

	private JButton btnNext;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private stage1 frame;

			public void run() {
				try {
					frame = new stage1();
					frame.setLocationRelativeTo(null); // This centers the frame
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    
    public stage1() {
    	getContentPane().setBackground(new Color(0, 139, 139));
    	
		conn = SQLSignUp.COnnecrDB(); 

        initializeUI();
        
    }

    private void initializeUI() {

	       setTitle("Document Uploader");
	        setSize(400, 367);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);

	        uploadButton = new JButton("");
	        uploadButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	        uploadButton.setBounds(113, 135, 157, 67);
	        uploadButton.setIcon(new ImageIcon("/Users/naran128386/Downloads/uploadIcon...png"));
	        uploadButton.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	            	 // Instantiate a file chooser
	                JFileChooser fileChooser = new JFileChooser();
	                // Show the open dialog and get the return value
	                int returnValue = fileChooser.showOpenDialog(null);
	                // Check if a file was selected
	                if (returnValue == JFileChooser.APPROVE_OPTION) {
	                    // Get the selected file
	                    File selectedFile = fileChooser.getSelectedFile();
	                    // Upload the selected file
	                    uploadFile(selectedFile);
	                    
	                    // Print the path of the selected file to the console
	                    System.out.println(selectedFile);        
	                  	                    
	                    
	                }
	            }
	        });
	        getContentPane().setLayout(null);
	        getContentPane().add(uploadButton);
	        
	        btnNext = new JButton("NEXT");
	        btnNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnNext.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		
	        		stage3();   
	        		
	        		
	      
	       
	        	}
	        });
	        btnNext.setBounds(252, 252, 93, 29);
	        getContentPane().add(btnNext);
	        
	        JLabel lblNewLabel = new JLabel("Insert your ATLS");
	        lblNewLabel.setBounds(131, 92, 136, 16);
	        getContentPane().add(lblNewLabel);
	        
	        JButton btnBack = new JButton("BACK");
	        btnBack.addActionListener(new ActionListener() {
	        	
	        	
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		back();
	        	}
	        });
	        btnBack.setBounds(77, 252, 93, 29);
	        getContentPane().add(btnBack);
	        
	        JButton btnNewButton = new JButton("");
	        btnNewButton.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
	        btnNewButton.setBounds(301, 6, 93, 59);
	        getContentPane().add(btnNewButton);
	    }

	/*    private void uploadFile(File file) {
	        // Implement your logic to upload the file here
	        // For the sake of simplicity, this is a placeholder method
	        System.out.println("Uploading file: " + file.getName());
	    }  */          
	    private void stage3() {
	    	
	    	stage2 S3 = new stage2 (); 
	    	S3.setVisible(true); 
	    	this.setVisible(false); 
	    	
	    }
	    
	    
	    private void uploadFile(File file) {
	        try  {
	        	
	        	
	            DataModel dataModel = DataModelSingleton.getInstance();
	            
	        	String fileName = file.getName();

	        	  FileInputStream inputStream = new FileInputStream(file);
	         /*  String query = "INSERT into Doc_upload(Name, Doc ) VALUES (?, ?)" ; 
	            
 				pst.setBinaryStream( inputStream, (int) file.length());
 				
	            pst=conn.prepareStatement(query);
	            
	            pst.setString(1, fileName);
	           
	            pst.executeUpdate();
	  	     
			    pst.close(); */
			     
			    
			    dataModel.setAtls(fileName);
			    
			    dataModel.setBinaryStream( inputStream, (int) file.length());
	            System.out.println("Document uploaded successfully.");
	            
	            
	        } catch ( Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private void back() {
	    	
	    	stage0 S0 = new stage0();
	    	S0.setVisible(true); 
	    	this.setVisible(false); 
	    	
	    }

	   
	    
	    
	  }
	