package Score.pkg;

import java.awt.EventQueue;
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
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class table2 extends JFrame {

	private JPanel contentPane;
	private JTable tblschool;
	private JButton btn1;
	private JButton btn3;
	private JButton btnAdd;
	private JButton btnPredictor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel txtEdOpsName;
	private JTextField txtCounty;
	private JTextField txtDistrict;
	private JTextField txtSchool;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtDOCType;
	private JTextField txtSOC;
	private JTextField txtEON;
	private JLabel trashCan;
	private JButton btnDelete;
	private JButton btnUpdate;
	Connection conn = null; 
	private JLabel lblNewLabel_7;
	private JTextField txtSearch;
	private JButton bntSearch;
	private JLabel lblNewLabel_8;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table2 frame = new table2();
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
	public table2() {
		conn = DBManager.getConnection (); 
		
			GUI();
	}
	
	
		public void loadTable () { 
		
		Connection conn; 
		
		
		try { 
			
			conn = DBManager.getConnection(); 
			
			
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM schools "); 
			
			ResultSet rs = pstm.executeQuery () ;
			
			
			tblschool.setModel(DBManager.buildTableModel(rs)); 
			
			pstm.close(); 
			
		} catch (Exception e) {
			
			e.printStackTrace(); 
			
		}
		
		
		
	}
	

		public void  table2() { 
			
			table2 T2 = new table2 (); 
			T2.setVisible (true);
			this.setVisible(false); 
			
			
		}
		public void table1() {
			DB data = new DB(); 
			data.setVisible(true);
			this.setVisible(false);
		}
		
		public void table3() { 
			
			Table3 T3 = new Table3(); 
			T3.setVisible(true);
			this.setVisible(false); 
			
		}
		private void GUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1440, 846);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setBorder(new EmptyBorder(5,10, 10, 5)); 
			contentPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(57, 387, 1337, 425);
			contentPane.add(scrollPane);
			
			
			tblschool = new JTable() {
			
				public boolean isCellEditable(int row, int column) {
				return false; 
				
				}

			};
			
			tblschool.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(e.getClickCount()==2) {
						DefaultTableModel tblModel = (DefaultTableModel) tblschool.getModel(); 
						
						selectedRow(); 
						
						System.out.println("doubleclick ");
					//doubleClick () ; 
					}
				}
			});
			tblschool.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			scrollPane.setViewportView(tblschool);
			
	        loadTable(); 
	        
	        
	        JButton btn2 = new JButton("Schools");
	        btn2.setBorder(new LineBorder(Color.WHITE));
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					table2(); 
				}		
				
			});
			btn2.setBounds(174, 358, 117, 29);
			contentPane.add(btn2);
			
			btn1 = new JButton("FRPM");
			btn1.setBorder(new LineBorder(Color.WHITE));
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					table3();
				}
			});
			btn1.setBounds(57, 358, 117, 29);
			contentPane.add(btn1);
			
			btn3 = new JButton("SATs");
			btn3.setBorder(new LineBorder(Color.WHITE));
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					table1();
				}
			});
			btn3.setBounds(292, 358, 117, 29);
			contentPane.add(btn3);
			
			btnAdd = new JButton("+");
			btnAdd.setBorder(new LineBorder(Color.WHITE));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
				
					
				}
			});
			btnAdd.setBounds(869, 262, 57, 41);
			contentPane.add(btnAdd);
			
			btnPredictor = new JButton("Predictor");
			btnPredictor.setBorder(new LineBorder(Color.WHITE));
			btnPredictor.setBounds(938, 357, 117, 29);
			contentPane.add(btnPredictor);
			
			lblNewLabel = new JLabel("County:");
			lblNewLabel.setBounds(105, 150, 61, 16);
			contentPane.add(lblNewLabel);
			
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
			houseIcon.setBounds(869, 100, 57, 39);
			contentPane.add(houseIcon);
			
			lblNewLabel_1 = new JLabel("District :");
			lblNewLabel_1.setBounds(105, 185, 61, 16);
			contentPane.add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("School:");
			lblNewLabel_2.setBounds(106, 233, 61, 16);
			contentPane.add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel("City:");
			lblNewLabel_3.setBounds(108, 281, 61, 16);
			contentPane.add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("State:");
			lblNewLabel_4.setBounds(545, 150, 61, 16);
			contentPane.add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("DOCType:");
			lblNewLabel_5.setBounds(548, 190, 61, 16);
			contentPane.add(lblNewLabel_5);
			
			lblNewLabel_6 = new JLabel("SOC : ");
			lblNewLabel_6.setBounds(547, 237, 61, 16);
			contentPane.add(lblNewLabel_6);
			
			txtEdOpsName = new JLabel("EdOpsName : ");
			txtEdOpsName.setBounds(545, 281, 107, 16);
			contentPane.add(txtEdOpsName);
			
			txtCounty = new JTextField();
			txtCounty.setBounds(211, 142, 130, 26);
			contentPane.add(txtCounty);
			txtCounty.setColumns(10);
			
			txtDistrict = new JTextField();
			txtDistrict.setBounds(210, 179, 130, 26);
			contentPane.add(txtDistrict);
			txtDistrict.setColumns(10);
			
			txtSchool = new JTextField();
			txtSchool.setBounds(211, 227, 130, 26);
			contentPane.add(txtSchool);
			txtSchool.setColumns(10);
			
			txtCity = new JTextField();
			txtCity.setBounds(212, 276, 130, 26);
			contentPane.add(txtCity);
			txtCity.setColumns(10);
			
			txtState = new JTextField();
			txtState.setBounds(663, 142, 130, 26);
			contentPane.add(txtState);
			txtState.setColumns(10);
			
			txtDOCType = new JTextField();
			txtDOCType.setBounds(663, 180, 130, 26);
			contentPane.add(txtDOCType);
			txtDOCType.setColumns(10);
			
			txtSOC = new JTextField();
			txtSOC.setBounds(663, 233, 130, 26);
			contentPane.add(txtSOC);
			txtSOC.setColumns(10);
			
			txtEON = new JTextField();
			txtEON.setBounds(664, 282, 130, 26);
			contentPane.add(txtEON);
			txtEON.setColumns(10);
			
			btnDelete = new JButton("New button");
			btnDelete.setIcon(new ImageIcon("/Users/naran128386/Downloads/trash (1).png"));
			btnDelete.setBorder(new LineBorder(Color.WHITE));
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					delete();
				}
			});
			btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnDelete.setBounds(869, 201, 57, 41);
			btnDelete.setText("");
			contentPane.add(btnDelete);
			
		
			btnUpdate = new JButton();
			btnUpdate.setBorder(new LineBorder(Color.WHITE));
			btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnUpdate.setText("\u21BB");
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnUpdate.setBounds(869, 150, 57, 39);
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
						update();
						
					
					
				}
			});
			contentPane.add(btnUpdate);
			
			lblNewLabel_7 = new JLabel("SCHOOLS ");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 45));
			lblNewLabel_7.setBounds(614, 6, 254, 109);
			contentPane.add(lblNewLabel_7);
			
			txtSearch = new JTextField();
			txtSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					search(); 
					
				}
			});
			txtSearch.setBounds(614, 346, 179, 39);
			contentPane.add(txtSearch);
			txtSearch.setColumns(10);
			
			bntSearch = new JButton();
			bntSearch.setIcon(new ImageIcon("/Users/naran128386/Downloads/search-icon-2048x2048-zik280t3 (1).png"));
			bntSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
			bntSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bntSearch.setBounds(580, 346, 40, 39);
			contentPane.add(bntSearch);
			
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon("/Users/naran128386/Downloads/sat.png"));
			lblNewLabel_8.setBounds(938, 70, 474, 246);
			contentPane.add(lblNewLabel_8);
			
		}
		
	
		
		public void selectedRow() { 
			
			
	
				int row = tblschool.getSelectedRow();
				
				if (row > -1) { 
					String County = tblschool.getValueAt(row,0).toString(); 
					String District = tblschool.getValueAt(row,1).toString();
					String School = tblschool.getValueAt(row,2).toString() ;
					String City = tblschool.getValueAt(row,3).toString();
					String State = tblschool.getValueAt(row,4).toString(); 
					String DocType = tblschool.getValueAt(row,5).toString(); 
					String SOC = tblschool.getValueAt(row,6).toString(); 
					String EON =  tblschool.getValueAt(row,7).toString(); 
					
					txtCounty.setText(County) ;
					 
					txtDistrict.setText(District);
					txtSchool.setText(School);
					txtCity.setText(City);
					txtState.setText(State);
					txtDOCType.setText(DocType);
					txtSOC.setText(SOC);
					txtEON.setText(EON);
		
					
				}
			
				
				}	
		
		
	
		
			
			public void delete() { 
				
			String	sql = "DELETE FROM satscores WHERE dname ="; 
			
			DefaultTableModel tblModel = (DefaultTableModel)tblschool.getModel();
			if(tblschool.getSelectedRowCount()== 1) {
				tblModel.removeRow(tblschool.getSelectedRow()); 
			}
				else if(tblschool.getRowCount() == 0 ) {
					JOptionPane.showMessageDialog(this, "Table is empty");
					
					
				}else {
					JOptionPane.showMessageDialog(this, "Please select a single row!");
				
			}
					
			}
			
			public void update() {
				
				DefaultTableModel tblModel = (DefaultTableModel)tblschool.getModel(); 
				
				if(tblschool.getSelectedRowCount() ==1 ) {
			
	
					String County = txtCounty.getText(); 
					String District = txtDistrict.getText();
					String School = txtSchool.getText() ;
					String City = txtCity.getText();
					String State = txtState.getText(); 
					String DocType = txtDOCType.getText(); 
					String SOC = txtSOC.getText(); 
					String EON = txtEON.getText(); 
					
					
					tblschool.setValueAt(County, tblschool.getSelectedRow(), 0); 
					tblschool.setValueAt(District, tblschool.getSelectedRow(), 1); 
					tblschool.setValueAt(School, tblschool.getSelectedRow(), 2); 
					tblschool.setValueAt(City, tblschool.getSelectedRow(), 3); 
					tblschool.setValueAt(State, tblschool.getSelectedRow(), 4); 
					tblschool.setValueAt(DocType, tblschool.getSelectedRow(), 5); 
					tblschool.setValueAt(SOC, tblschool.getSelectedRow(), 6); 
					tblschool.setValueAt(EON, tblschool.getSelectedRow(), 7); 
					
					JOptionPane.showMessageDialog(this, "Update Succesfully"); 
					
				}else if(tblschool.getRowCount() == 0 ) {
						 
					
					JOptionPane.showMessageDialog(this, "Table is Empty"); 
					
			}	
					else {
					
					JOptionPane.showMessageDialog(this, "Please select single Row for Update"); 
					
				}
					
			}
			

			private void add() {
				 
		
				
				
				if(txtCounty.getText().equals ("") || txtDistrict.getText().equals("")|| txtSchool.getText().equals("")||
					txtCity.getText().equals("")|| txtState.getText().equals("")|| txtDOCType.getText().equals("")|| txtSOC.getText().equals("")||txtEON.getText().equals("") ) {
					
					JOptionPane.showMessageDialog(this, "Please Enter All Data"); 
					
				}else {
					String data [] = {txtCounty.getText(),txtDistrict.getText(), txtSchool.getText(), 
							txtCity.getText(), txtState.getText(), txtDOCType.getText(),txtSOC.getText(), txtEON.getText() }; 
					
					DefaultTableModel tblModel = (DefaultTableModel) tblschool.getModel(); 
					tblModel.addRow(data);
					
					
					
					JOptionPane.showMessageDialog(this, "Data added succesfully");
					
				}
				
			}
			
			private void search() { 
				
			
					try { 
						
						String searchTemp = txtSearch.getText()+ "%"; 
						conn = DBManager.getConnection(); 
						
						
						PreparedStatement pstm = conn.prepareStatement("SELECT * FROM schools WHERE School LIKE  '"+ searchTemp +"'" ); 
						
						ResultSet rs = pstm.executeQuery () ;
						
						
						ResultSetMetaData data = rs.getMetaData();
						int y = data.getColumnCount();
						
						DefaultTableModel tableRecords = (DefaultTableModel)tblschool.getModel(); 
						tblschool.setModel(DBManager.buildTableModel(rs)); 
						tableRecords.setRowCount(0); 
						
						
						while(rs.next()) {
							Vector columnData = new Vector(); 
							for(int x=1; x<=y ;  x++) {
								
								

								String County = txtCounty.getText(); 
								String District = txtDistrict.getText();
								String School = txtSchool.getText() ;
								String City = txtCity.getText();
								String State = txtState.getText(); 
								String DocType = txtDOCType.getText(); 
								String SOC = txtSOC.getText(); 
								String EON = txtEON.getText(); 
								
								
								columnData.add(rs.getShort("County "));
								columnData.add(rs.getShort("District"));
								columnData.add(rs.getShort("School"));
								columnData.add(rs.getShort("City"));
								columnData.add(rs.getShort("State"));
								columnData.add(rs.getShort("DocType"));
								columnData.add(rs.getShort("SOC"));
								columnData.add(rs.getShort("EON"));
						
							}
							 
						tableRecords.addRow(columnData); 
						}	
						
						
					} catch (Exception e) {
						
						e.printStackTrace(); 
					}
		}
			
		public void OptionWindow() { 
			
			OptionWindow OW = new OptionWindow ();
			OW.setVisible(true);
			this.setVisible(false);
			
		}
			}
		
		

