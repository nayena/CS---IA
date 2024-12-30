package Score.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.*;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;

public class Editor extends JFrame {

	
	protected static final String[] row = null;
	protected static final String model = null;
	private static final Statement DatabaseManager = null;

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JTextField txtSchool;
	private JTextField txtDistrict;
	private JTextField txtCity;
	

	private JSpinner spnMathematics;
	private JSpinner spnRead;
	private JSpinner spnCDS;
	private JSpinner spntt;
	
	private JSpinner spnWrite; 
	private DB parent; 
	
	String sname;
	private JButton btnAdd; 
	

	public Editor() {
		
		conn = DBManager.getConnection();
		
		GUI();
		
		
	}
	public Editor(DB parent , int CDS, String sname,String dname, String cname, int numTstTaken, int avgScrRead, int avgScrMath, int avgScrWrite) {
		// TODO Auto-generated constructor stub
	
		
		spntt.setValue(numTstTaken);
		spnRead.setValue(avgScrRead);
		spnMathematics.setValue(avgScrMath);
		spnWrite.setValue(avgScrWrite);
		spnCDS.setValue(CDS); 
		
	
		this.sname = sname; 
	}
	/**
	 * Create the frame.
	 */
	
	public void GUI() {	
			setBackground(new Color(255, 255, 255));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 585, 646);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(192, 192, 192));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("CDS:");
			lblNewLabel.setBounds(74, 94, 93, 16);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			contentPane.add(lblNewLabel);
			
			JLabel lblSchool = new JLabel("School Name: ");
			lblSchool.setBounds(74, 182, 105, 16);
			lblSchool.setForeground(new Color(255, 255, 255));
			contentPane.add(lblSchool);
			
			JLabel lblDistrict = new JLabel("District Name");
			lblDistrict.setBounds(74, 264, 102, 16);
			lblDistrict.setForeground(new Color(255, 255, 255));
			contentPane.add(lblDistrict);
			
			JLabel lblCity = new JLabel("City Name:");
			lblCity.setBounds(74, 352, 93, 16);
			lblCity.setForeground(new Color(255, 255, 255));
			contentPane.add(lblCity);
			
			JLabel lblNumber = new JLabel("Number of Test Taken");
			lblNumber.setBounds(368, 94, 185, 16);
			lblNumber.setForeground(new Color(255, 255, 255));
			contentPane.add(lblNumber);
			
			JLabel lblsr = new JLabel("Score Reading:");
			lblsr.setBounds(368, 182, 93, 16);
			lblsr.setForeground(new Color(255, 255, 255));
			contentPane.add(lblsr);
			
			JLabel lblsw = new JLabel("Score Writing");
			lblsw.setBounds(368, 264, 138, 16);
			lblsw.setForeground(new Color(255, 255, 255));
			contentPane.add(lblsw);
			
			JLabel lblsm = new JLabel("Score Mathematics");
			lblsm.setBounds(368, 352, 126, 16);
			lblsm.setForeground(new Color(255, 255, 255));
			contentPane.add(lblsm);
			
			spnMathematics = new JSpinner();
			spnMathematics.setBounds(368, 382, 96, 26);
			contentPane.add(spnMathematics);
			
			spnRead = new JSpinner();
			spnRead.setBounds(368, 226, 93, 26);
			contentPane.add(spnRead);
			
			spntt = new JSpinner();
			spntt.setBounds(368, 122, 93, 26);
			contentPane.add(spntt);
			
			spnCDS = new JSpinner();
			spnCDS.setBounds(67, 122, 77, 26);
			contentPane.add(spnCDS);
			
			txtSchool = new JTextField();
			txtSchool.setBounds(67, 226, 130, 26);
			contentPane.add(txtSchool);
			txtSchool.setColumns(10);
			
			txtDistrict = new JTextField();
			txtDistrict.setBounds(67, 302, 130, 26);
			contentPane.add(txtDistrict);
			txtDistrict.setColumns(10);
			
			txtCity = new JTextField();
			txtCity.setBounds(67, 394, 130, 26);
			contentPane.add(txtCity);
			txtCity.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Add Data");
			lblNewLabel_8.setBounds(197, 20, 234, 47);
			lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
			contentPane.add(lblNewLabel_8);
			
			JPanel panel = new JPanel();
			panel.setBounds(52, 79, 486, 379);
			panel.setBackground(new Color(0, 139, 139));
			contentPane.add(panel);
			panel.setLayout(null);
			
			spnWrite = new JSpinner();
			spnWrite.setBounds(316, 226, 85, 26);
			panel.add(spnWrite);
			
			btnAdd = new JButton("Add");
			btnAdd.setBounds(330, 561, 117, 29);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					add(); 
					 
					 
					
		}
			});
			contentPane.add(btnAdd);
			
			JButton btnCancel = new JButton("Close");
			btnCancel.setBounds(115, 561, 117, 29);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				cancel(); 
				
				}
			});
			contentPane.add(btnCancel);
		}
	
		private void cancel () { 
		DB data = new DB (); 
			data.setVisible(true);
			this.setVisible(false); 
					
		
		}

	
	private void add () {
		
			
			try { 
							
	
	String query = "insert into satscores values(?, ?, ?, ?, ?, ?, ?, ?)" ; 

					ps= conn.prepareStatement(query); 	 
						
							String value1 = txtSchool.getText();
							String value2 = txtDistrict.getText(); 
							String value3 = txtCity.getText(); 
						
							int value4 = (Integer)spnMathematics.getValue(); 
							int value5 = (Integer)spnRead.getValue();
					
							int value6 = (Integer)spnWrite.getValue(); 
							int value7 = (Integer)spntt.getValue();
							int value8 = (Integer)spnCDS.getValue();
							
							
							ps.setString(1,value1);
							ps.setString(2,value2);
							ps.setString(3,value3);
							ps.setInt(4,value4);
							ps.setInt(5,value5);
							ps.setInt(6,value6);
							ps.setInt(7,value7);
							ps.setInt(8,value8);
							
							ps.execute();
							
							ps.close();
							
							
							
							
			
				
				
				 if(value4 == 0) {
					JOptionPane.showMessageDialog(null, "Please fill all the spaces");
				}
				else if (value5 == 0) { 
					
					JOptionPane.showMessageDialog(null, "Please fill all the spaces");
				}
				else if (value6 == 0) { 
					
					JOptionPane.showMessageDialog(null, "Please fill all the spaces");
				}
				
				else if (value7 == 0) { 
					
					JOptionPane.showMessageDialog(null, "Please fill all the spaces");
				}
					
				else if (value8 == 0) { 
					
					JOptionPane.showMessageDialog(null, "Please fill all the spaces");
				}
				
				
				else {
							
						JOptionPane.showMessageDialog(null, "Saved");
				}	
					}catch(Exception  e) {
						
					e.printStackTrace();
				
					 JOptionPane.showMessageDialog(null, e);
					  System.out.println(e);
					}
			btnAdd.setEnabled(false);			
			
			DB DT = new DB(); 
			DT.setVisible(true);
			dispose();
				
				
			}
		


		}
	


	
	
