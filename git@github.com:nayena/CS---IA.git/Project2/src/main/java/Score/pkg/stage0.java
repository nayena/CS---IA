package Score.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.html.parser.Entity;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;

import java.util.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon; 

public class stage0 extends JFrame {

	private JPanel contentPane;
	private JTextField txtSbj2;
	private JTextField txtSbj3;
	
	  Connection conn= null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
		private String names;
		private JTextField txtScr;
		private JTextField txtSbj1;
		private JTextArea txtName;
		private JComboBox countryOfOrigin;
		private JComboBox countryOfResidence;
		private JButton btnNext;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private stage0 frame;

			public void run() {
				try {
					frame = new stage0();
					frame.setLocationRelativeTo(null); // This centers the frame
			
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
	
	public stage0 () {
		
		conn = SQLSignUp.COnnecrDB(); 
		GUI();
	}
	
	 private class NumericDocumentFilter extends DocumentFilter {
	        @Override
	        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	        	// Check if the input string is valid
	            if (isInputValid(string, fb)) {
	            	 // If valid, insert the string into the document at the specified offset
	                super.insertString(fb, offset, string, attr);
	            }
	        }

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	        	 // Check if the replacement text is valid
	            if (isInputValid(text, fb)) {
	            	 // If valid, replace the text in the document at the specified offset and length
	                super.replace(fb, offset, length, text, attrs);
	                // If not valid, the replacement is ignored
	            }
	        }

	        private boolean isInputValid(String text, FilterBypass fb) throws BadLocationException {
	            try {
	            	 // Combine the existing text in the document with the new text
	                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	                // Attempt to parse the combined text as an integer 
	                int number = Integer.parseInt(newText);
	                // Check if the parsed number is less than or equal to 45
	                return number <= 45;
	                // If parsing fails, the input is invalid  
	            } catch (NumberFormatException e) {
	                return false;
	            }
	        }
	    }
	
	public  void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 734);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Information");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(192, 38, 225, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblCountryOfOrigin = new JLabel("Country of Origin: ");
		lblCountryOfOrigin.setBounds(77, 152, 149, 52);
		contentPane.add(lblCountryOfOrigin);
		
		countryOfOrigin = new JComboBox(getAllCountries());
		countryOfOrigin.setBounds(79, 210, 156, 37);
		contentPane.add(countryOfOrigin);
		
		JLabel lblCountryOfResidence = new JLabel("Country of Residence: ");
		lblCountryOfResidence.setBounds(339, 152, 250, 52);
		contentPane.add(lblCountryOfResidence);
		
		countryOfResidence = new JComboBox(getAllCountries());
		countryOfResidence.setBounds(339, 210, 156, 37);
		contentPane.add(countryOfResidence);
		
		JLabel lblAcademicInformation = new JLabel("Academic Information");
		lblAcademicInformation.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAcademicInformation.setBounds(192, 248, 238, 52);
		contentPane.add(lblAcademicInformation);
		
		JLabel lblGeneralGpaOver = new JLabel("General IB score over the last 2 years");
		lblGeneralGpaOver.setBounds(30, 289, 250, 52);
		contentPane.add(lblGeneralGpaOver);
		
		JLabel lblIbSubjects = new JLabel("Introduce your  HLs");
		lblIbSubjects.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblIbSubjects.setBounds(30, 361, 193, 52);
		contentPane.add(lblIbSubjects);
		
		JLabel lblSubject = new JLabel("Subject 1");
		lblSubject.setBackground(new Color(85, 107, 47));
		lblSubject.setBounds(77, 416, 127, 37);
		contentPane.add(lblSubject);
		
		JLabel lblSubject_5 = new JLabel("Subject 2");
		lblSubject_5.setBackground(new Color(144, 238, 144));
		lblSubject_5.setBounds(77, 456, 127, 37);
		contentPane.add(lblSubject_5);
		
		JLabel lblSubject_1 = new JLabel("Subject 3");
		lblSubject_1.setBounds(77, 492, 127, 37);
		contentPane.add(lblSubject_1);
		
		txtSbj1 = new JTextField();
		txtSbj1.setBounds(201, 416, 204, 37);
		contentPane.add(txtSbj1);
		txtSbj1.setColumns(10);
		
		txtSbj2 = new JTextField();
		txtSbj2.setColumns(10);
		txtSbj2.setBounds(201, 456, 204, 37);
		contentPane.add(txtSbj2);
		
		txtSbj3 = new JTextField();
		txtSbj3.setColumns(10);
		txtSbj3.setBounds(201, 492, 204, 37);
		contentPane.add(txtSbj3);
		
		JLabel lblScore = new JLabel("Score out of 42");
		lblScore.setBounds(259, 560, 108, 16);
		contentPane.add(lblScore);
		
		btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				collectData(); 
				
				
				Stage1(); 
				
			
			}
		});
		
		btnNext.setBounds(408, 643, 117, 37);
		contentPane.add(btnNext);
		
		JButton houseIcon = new JButton("");
		houseIcon.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
		houseIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		houseIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				house(); 
			
			}
		});
		houseIcon.setBounds(6, 18, 61, 52);
		contentPane.add(houseIcon);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				back();
			}
		});
		btnBack.setBounds(109, 643, 117, 37);
		contentPane.add(btnBack);
		
		txtScr = new JTextField();
		  ((AbstractDocument) txtScr.getDocument()).setDocumentFilter(new NumericDocumentFilter());
		txtScr.setColumns(10);
		txtScr.setBounds(259, 588, 99, 37);
		contentPane.add(txtScr);
		
		txtName = new JTextArea();
		txtName.setBounds(304, 103, 99, 24);
		contentPane.add(txtName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(223, 85, 69, 52);
		contentPane.add(lblName);
	}
	
	
	
	 public String[] getAllCountries() {
		    String[] countries = new String[Locale.getISOCountries().length];
		    String[] countryCodes = Locale.getISOCountries();
		    for (int i = 0; i < countryCodes.length; i++) {
		        Locale obj = new Locale("", countryCodes[i]);
		        countries[i] = obj.getDisplayCountry();
		    }
		    return countries;
		 }
	 
	 public String [] level() {
		 
	   String[] level = {"HL", "SL" } ;
	return level; 
	  
	    }
	 
	 
	 public String [] score() {
		 
		   String[] level = {"1", "2", "3", "4" , "5" , "6" , "7" } ;
		return level; 
		  
		    }
	 
	 
	 private void house() {
		 OptionWindow OW = new OptionWindow();
		 OW.setVisible(true);
		 this.setVisible(false);
		 
	 }
	 
	private void  Stage1() {
		
			stage1 S1 = new stage1() ; 
			S1.setVisible(true);
			this.setVisible(false);
			
		
	}
	
	private void back() { 
		UniOp UO = new UniOp();
		UO.setVisible(true);
		this.setVisible(false);
		
	}
	
	private void collectData() {
	    
	    // Obtain the single instance of DataModel from the DataModelSingleton class
	    DataModel dataModel = DataModelSingleton.getInstance();
	    
	    // Set the 'name' field in the data model to the text from the 'txtName' text field
	    dataModel.setName(txtName.getText());
	    
	    // Set the 'residence' field in the data model to the selected item from the 'countryOfResidence' combo box
	    dataModel.setResidence((String)countryOfResidence.getSelectedItem());
	    
	    // Set the 'origin' field in the data model to the selected item from the 'countryOfOrigin' combo box
	    dataModel.setOrigin((String)countryOfOrigin.getSelectedItem());
	    
	    // Set the 'subjects' field in the data model to the text from the 'txtSbj1' text field
	    dataModel.setSubjects(txtSbj1.getText());
	    
	    // Set the 'scores' field in the data model to the text from the 'txtScr' text field
	    dataModel.setScores(txtScr.getText());
	    
	    // Display a message dialog to inform the user that the data has been saved
	    JOptionPane.showMessageDialog(null, "Saved");
	}
	

	
	}

	
		
			

    

	

