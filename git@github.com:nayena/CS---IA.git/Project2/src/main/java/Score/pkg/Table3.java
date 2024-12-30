package Score.pkg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Table3 extends JFrame {

	private JPanel contentPane;
	private JTable tblfrpm;
	private JTextField txtSearch;
	
	Connection conn = null; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table3 frame = new Table3();
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
	public Table3() {
	
			GUI();
	}
	
	
	
	

		public void  table2() { 
			
			table2 T2 = new table2 (); 
			T2.setVisible (true);
			this.setVisible(false); 
			
			
		}
		
		
		public void table3() { 
			
			Table3 T3 = new Table3(); 
			T3.setVisible(true);
			this.setVisible(false); 
			
		}
		private void GUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1440, 817);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 139, 139));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setBorder(new EmptyBorder(5,10, 10, 5));
			contentPane.setLayout(null);
			
			
			JLabel houseIcon = new JLabel("");
			houseIcon.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
			houseIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					OptionWindow(); 
				}
			});
			houseIcon.setBorder(new LineBorder(Color.WHITE));
			houseIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			houseIcon.setBounds(854, 72, 52, 50);
			contentPane.add(houseIcon);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(55, 285, 1349, 498);
			contentPane.add(scrollPane);
			
			
			tblfrpm = new JTable() {
			
				public boolean isCellEditable(int row, int column) {
				return false; 
				
				}

			};
			
			tblfrpm.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(e.getClickCount()==2) {
						
					//doubleClick () ; 
					}
				}
			});
			tblfrpm.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			scrollPane.setViewportView(tblfrpm);
			
	        loadTable(); 
	        
	        
	        JButton btn1School = new JButton("Schools");
	        btn1School.setBounds(55, 258, 117, 29);
	        btn1School.setBorder(new LineBorder(Color.WHITE));
			btn1School.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					table2(); 
				}		
				
			});
			contentPane.add(btn1School);
			
			JButton FRPM = new JButton("FRPM");
			FRPM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
			FRPM.setBounds(174, 258, 117, 29);
			FRPM.setBorder(new LineBorder(Color.WHITE));
			contentPane.add(FRPM);
			
			JButton btn3DB = new JButton("SATs");
			btn3DB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					DB(); 
				}
			});
			btn3DB.setBounds(290, 258, 117, 29);
			btn3DB.setBorder(new LineBorder(Color.WHITE));
			contentPane.add(btn3DB);
			
			txtSearch = new JTextField();
			txtSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					search(); 
					
				}
			});
			txtSearch.setBounds(441, 144, 175, 40);
			contentPane.add(txtSearch);
			txtSearch.setColumns(10);
			
			JButton tnlupa = new JButton();
			tnlupa.setIcon(new ImageIcon("/Users/naran128386/Downloads/search-icon-2048x2048-zik280t3 (1).png"));
			tnlupa.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
			tnlupa.setBounds(405, 144, 43, 40);
			contentPane.add(tnlupa);
			
			JButton btnDelete = new JButton();
			btnDelete.setIcon(new ImageIcon("/Users/naran128386/Downloads/trash (1).png"));
			btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			btnDelete.setBorder(new LineBorder(Color.WHITE));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					delete();
				}
			});
			btnDelete.setBounds(854, 134, 54, 50);
			contentPane.add(btnDelete);
			
			JLabel lblFRPM = new JLabel("FRPM");
			lblFRPM.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
			lblFRPM.setBounds(401, 43, 166, 63);
			contentPane.add(lblFRPM);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/naran128386/Downloads/sat (1) (1).png"));
			lblNewLabel.setBounds(1085, 43, 175, 188);
			contentPane.add(lblNewLabel);
			
		}
		public void search () { 
			
			try {
			
			String searchTemp = txtSearch.getText()+ "%"; 
			conn = DBManager.getConnection(); 
			
			
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM frpm WHERE SchoolCode LIKE  '"+ searchTemp +"'" ); 
			
			ResultSet rs = pstm.executeQuery () ;
			
			
			ResultSetMetaData data = rs.getMetaData();
			int y = data.getColumnCount();
			
			DefaultTableModel tableRecords = (DefaultTableModel)tblfrpm.getModel(); 
			tblfrpm.setModel(DBManager.buildTableModel(rs)); 
			tableRecords.setRowCount(0); 
			
			
			
			while(rs.next()) {
				Vector columnData = new Vector(); 
				for(int x=1; x<=y ;  x++) {
					
					columnData.add(rs.getShort("SchoolCode"));
					columnData.add(rs.getShort("CountyName"));
					columnData.add(rs.getShort("DistrictName"));
					columnData.add(rs.getShort("SchoolName"));
					columnData.add(rs.getShort("SchoolType"));
					columnData.add(rs.getShort("EductionalOptionType"));
					columnData.add(rs.getShort("LowGrade"));
					columnData.add(rs.getShort("HighGrade"));
					columnData.add(rs.getShort("Percent(%)EligibleFree(K-12)"));
					columnData.add(rs.getShort("Enrollment(Ages 5 -17)"));
					columnData.add(rs.getShort("Percent(%)EligibleFree(Ages 5-17)"));
					columnData.add(rs.getShort("FRPM Count(Ages 5-17)"));
					columnData.add(rs.getShort("Percent(%)EligibleFRPM(5-17)"));
					
				
					
				}
			tableRecords.addRow(columnData); 
			}	
			
			
		} catch (Exception e) {
			
			e.printStackTrace(); 
		}
			}
			
			
	
		
		private void loadTable() { 
			
			
			
			try { 
				
				
				conn = DBManager.getConnection(); 
				
				
				PreparedStatement pstm = conn.prepareStatement("SELECT * FROM frpm LIMIT 500"); 
				
				ResultSet rs = pstm.executeQuery () ;
		
				
				ResultSetMetaData data = rs.getMetaData();
				int y = data.getColumnCount();
				
				DefaultTableModel tableRecords = (DefaultTableModel)tblfrpm.getModel(); 
				tblfrpm.setModel(DBManager.buildTableModel(rs)); 
				tableRecords.setRowCount(0); 
				
				
				while(rs.next()) {
					Vector columnData = new Vector(); 
					for(int x=1; x<=y ;  x++) {
						
						columnData.add(rs.getShort("SchoolCode"));
						columnData.add(rs.getShort("CountyName"));
						columnData.add(rs.getShort("DistrictName"));
						columnData.add(rs.getShort("SchoolName"));
						columnData.add(rs.getShort("SchoolType"));
						columnData.add(rs.getShort("EductionalOptionType"));
						columnData.add(rs.getShort("LowGrade"));
						columnData.add(rs.getShort("HighGrade"));
						columnData.add(rs.getShort("Percent(%)EligibleFree(K-12)"));
						columnData.add(rs.getShort("Enrollment(Ages 5 -17)"));
						columnData.add(rs.getShort("Percent(%)EligibleFree(Ages 5-17)"));
						columnData.add(rs.getShort("FRPM Count(Ages 5-17)"));
						columnData.add(rs.getShort("Percent(%)EligibleFRPM(5-17)"));
						
					
						
					}
				tableRecords.addRow(columnData); 
				}	
				
				
			} catch (Exception e) {
				
				e.printStackTrace(); 
			}}
				
				
	
		public void delete() { 
			
			String	sql = "DELETE FROM frpm WHERE dname ="; 
			
			DefaultTableModel tblModel = (DefaultTableModel)tblfrpm.getModel();
			if(tblfrpm.getSelectedRowCount()== 1) {
				tblModel.removeRow(tblfrpm.getSelectedRow()); 
			}
				else if(tblfrpm.getRowCount() == 0 ) {
					JOptionPane.showMessageDialog(this, "Table is empty");
					
					
				}else {
					JOptionPane.showMessageDialog(this, "Please select a single row!");
	
			
			}
					
			}
		
		public void DB() {
			DB DA = new DB(); 
			DA.setVisible(true);
		this.setVisible(false);
		}
		
		
	
	 public void OptionWindow () { 
		 
		 OptionWindow OW = new OptionWindow () ; 
		 OW.setVisible(true);
		 this.setVisible(false);
		
	 }
		
	

}

