package Score.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class UniOp extends JFrame {

	private JPanel contentPane;

	private JComboBox<String> cbmUni;


	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UniOp frame = new UniOp();
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
	
		
	public UniOp() {
		
		conn = DBManager.getConnection();

		GUI();

	}
	

	public void GUI() {
			
	
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		cbmUni = new JComboBox<String>();
		cbmUni.setBounds(97, 112, 258, 27);
		data();
		contentPane.setLayout(null);
		contentPane.add(cbmUni);
		
		JLabel lblNewLabel = new JLabel("Choose a university");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(159, 76, 139, 16);
		contentPane.add(lblNewLabel);
		
		btnNext = new JButton("NEXT");
		btnNext.setBounds(178, 178, 105, 29);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				collectData(); 
				
				nextpage();
				
			}
			
			
			
		});
		contentPane.add(btnNext);
	
		
	}

	public void data() {

		cbmUni.addItem(" - - SELECT UNIVERSITY - - ");
		
		try {

			conn = DriverManager.getConnection("jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite");

			String query = ("SELECT * from STATS");
			System.out.println("Connected");

			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				cbmUni.addItem(rs.getString("UNI"));

			}
			pst.close();
		

		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	
	private void nextpage() {
		
		stage0 S1 = new stage0(); 
		S1.setVisible(true);
		this.setVisible(false);
		
	}
	
	private void collectData() {
		
		 DataModel dataModel = DataModelSingleton.getInstance();
		 
		  dataModel.setUni((String)cbmUni.getSelectedItem()); 
		  
			JOptionPane.showMessageDialog(null, "OK");
		  
	}
	
	
/*public void DataInserter() {
		
	
//Connection conn,  DataModel dataModel) throws SQLException
	
	 DataModel dataModel1 = DataModelSingleton.getInstance();
						
try {
String query = "insert into CALC(UNI) VALUES(?)" ; 

			pst= conn.prepareStatement(query); 	 
			
			
					pst.setString(1, dataModel1.getUni());
					
												
					pst.execute();
						
					
					//	pst.close();
						
						
					
					
}catch (Exception ex) {
	
}
									
								JOptionPane.showMessageDialog(null, "OK");  */
							
							
				

   //  dispose(); 
		
}



	
	
	

