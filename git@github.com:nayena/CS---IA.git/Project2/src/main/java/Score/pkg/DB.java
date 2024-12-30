package Score.pkg;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

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

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DB extends JFrame {

	private JPanel contentPane;
	private JTable scoretbl;

	
	Connection conn = null; 
	PreparedStatement pst = null; 

	
	public static String selectedID ; 
	public static String ID;
	 
	private JButton btndelete; 
	private JTextField txtCDS;
	private JTextField txtdname;
	private JTextField txtcname;
	private JTextField txtsname;
	private JTextField txttt;
	private JTextField txtread;
	private JTextField txtMath;
	private JTextField txtwrite;
	private JButton btnUpdate;
	private JTextField txtSearch;
	private JButton btnSearch;
	
	ResultSet resultSet;
	Statement statement; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB frame = new DB();
					frame.setVisible(true);
					frame.setResizable(true); 
			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DB() {
		
		conn = DBManager.getConnection(); 
		
		GUI(); 
		loadTable(); 
	
			
	}
		
		
		
	
		public void GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 873);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5,10, 10, 5));
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 346, 1224, 433);
		contentPane.add(scrollPane);
		
		scoretbl = new JTable() {
			
			public boolean isCellEditable(int row, int column) {
			return false; 
			
			};	
		};
		
		
		scoretbl.addMouseListener(new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent e) {
				
				
			
			if(e.getClickCount() == 2) {
				
				DefaultTableModel tblModel = (DefaultTableModel)scoretbl.getModel();		
				
				 
				SelectedRow();
				
				System.out.println("double click");
				
			}
			}
			});
		scoretbl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(scoretbl);
		
		JButton btnSAT = new JButton("SATs ");
		btnSAT.setBorder(new LineBorder(Color.WHITE));
		btnSAT.setBounds(101, 321, 126, 29);
		
		btnSAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSAT);
		
		JButton btnSchool = new JButton("Schools");
		btnSchool.setBounds(224, 321, 105, 29);
		btnSchool.setBorder(new LineBorder(Color.WHITE));
		btnSchool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				table2(); 
				
				
			}		
			
		});
		contentPane.add(btnSchool);
		
		JButton btnFRPM = new JButton("FRPM");
		btnFRPM.setBounds(329, 321, 105, 27);
		btnFRPM.setBorder(new LineBorder(Color.WHITE));
		btnFRPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				table3(); 
			}
		});
		btnFRPM.setBackground(UIManager.getColor("Button.select"));
		contentPane.add(btnFRPM);
		
		btndelete = new JButton();
		btndelete.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btndelete.setText("\uD83D\uDDD1");
		btndelete.setBounds(824, 204, 52, 39);
		btndelete.setBorder(new LineBorder(Color.WHITE));
		btndelete.setBackground(new Color(0, 139, 139));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete (); 
				
			}
		});
		contentPane.add(btndelete);
		
		btnUpdate = new JButton();
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnUpdate.setBorder(new LineBorder(Color.WHITE));
		btnUpdate.setText("\u21BB");
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(824, 161, 52, 39);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
					update();
					
				
				
			}
		});
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_3 = new JButton("?\n");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_3.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_3.setBounds(824, 246, 52, 36);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			UniA();
			}
		});
		contentPane.add(btnNewButton_3);
		
		scrollPane.setViewportView(scoretbl);
		
		JLabel lblCDS = new JLabel("CDS");
		lblCDS.setBounds(113, 129, 61, 16);
		lblCDS.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCDS);
		
		JLabel lblDname = new JLabel("D Name: ");
		lblDname.setBounds(113, 157, 61, 16);
		lblDname.setForeground(new Color(255, 255, 255));
		contentPane.add(lblDname);
		
		JLabel lblcname = new JLabel("City Name:");
		lblcname.setBounds(113, 199, 78, 16);
		lblcname.setForeground(new Color(255, 255, 255));
		contentPane.add(lblcname);
		
		JLabel lblcityname = new JLabel("School Name");
		lblcityname.setBounds(113, 240, 105, 16);
		lblcityname.setForeground(new Color(255, 255, 255));
		contentPane.add(lblcityname);
		
		txtCDS = new JTextField();
		txtCDS.setBounds(211, 119, 130, 26);
		contentPane.add(txtCDS);
		txtCDS.setColumns(10);
		
		txtdname = new JTextField();
		txtdname.setBounds(211, 152, 130, 26);
		contentPane.add(txtdname);
		txtdname.setColumns(10);
		
		txtcname = new JTextField();
		txtcname.setBounds(211, 200, 130, 26);
		contentPane.add(txtcname);
		txtcname.setColumns(10);
		
		txtsname = new JTextField();
		txtsname.setBounds(214, 235, 130, 26);
		contentPane.add(txtsname);
		txtsname.setColumns(10);
		
		JLabel lbl = new JLabel("# Test Taken: ");
		lbl.setBounds(507, 124, 105, 16);
		lbl.setForeground(new Color(255, 255, 255));
		contentPane.add(lbl);
		
		JLabel lblread = new JLabel("Score Read");
		lblread.setBounds(507, 157, 130, 16);
		lblread.setForeground(new Color(255, 255, 255));
		contentPane.add(lblread);
		
		JLabel lblMath = new JLabel("Score Math");
		lblMath.setBounds(507, 199, 105, 16);
		lblMath.setForeground(new Color(255, 255, 255));
		contentPane.add(lblMath);
		
		JLabel lblwriting = new JLabel("Score Wirtting");
		lblwriting.setBounds(505, 238, 92, 16);
		lblwriting.setForeground(new Color(255, 255, 255));
		contentPane.add(lblwriting);
		
		txttt = new JTextField();
		txttt.setBounds(606, 119, 130, 26);
		contentPane.add(txttt);
		txttt.setColumns(10);
		
		txtread = new JTextField();
		txtread.setBounds(606, 152, 130, 26);
		contentPane.add(txtread);
		txtread.setColumns(10);
		
		txtMath = new JTextField();
		txtMath.setBounds(606, 194, 130, 26);
		contentPane.add(txtMath);
		txtMath.setColumns(10);
		
		txtwrite = new JTextField();
		txtwrite.setBounds(606, 233, 130, 26);
		contentPane.add(txtwrite);
		txtwrite.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SATs Scores in the USA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblNewLabel.setBounds(429, 17, 683, 61);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				search(); 
				
			}
		});
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadTable();
		
			}
		});
		txtSearch.setBounds(563, 293, 199, 36);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		btnSearch = new JButton("\uD83D\uDD0D");
		
		btnSearch.setBounds(536, 296, 33, 29);
		btnSearch.setBorder(new LineBorder(Color.WHITE));
		contentPane.add(btnSearch);
		
		JLabel houseIcon = new JLabel("");
		houseIcon.setIcon(new ImageIcon("/Users/naran128386/Downloads/CompSci/home (3) (1).png"));
		houseIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				OptionWindow(); 
			}
		});
		houseIcon.setBorder(new LineBorder(Color.WHITE));
		houseIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		houseIcon.setBounds(824, 119, 52, 39);
		contentPane.add(houseIcon);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Editor(); 
				
			}
		});
		btnNewButton.setBounds(824, 294, 52, 29);
		contentPane.add(btnNewButton);
		
		JButton btnChart = new JButton("Chart");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnChart.setBounds(1087, 298, 117, 29);
		contentPane.add(btnChart);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/naran128386/Downloads/CompSci/sat (1) (1).png"));
		lblNewLabel_1.setBounds(1063, 93, 179, 189);
		contentPane.add(lblNewLabel_1);
		
		
		loadTable();
        
	}


	public void loadTable() { 
		
			 	
		
		try { 
			
			
			conn = DBManager.getConnection(); 
			
			
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM satscores "); 
			
			ResultSet rs = pstm.executeQuery () ;
			
			
		
			
		
			
			ResultSetMetaData data = rs.getMetaData();
			int y = data.getColumnCount();
			
			DefaultTableModel tableRecords = (DefaultTableModel)scoretbl.getModel(); 
			scoretbl.setModel(DBManager.buildTableModel(rs)); 
			tableRecords.setRowCount(0); 
			
			
			while(rs.next()) {
				Vector columnData = new Vector(); 
				for(int x=1; x<=y ;  x++) {
					
					columnData.add(rs.getShort("CDS"));
					columnData.add(rs.getShort("sname"));
					columnData.add(rs.getShort("cname"));
					columnData.add(rs.getShort("dname"));
					columnData.add(rs.getShort("numTstTaken"));
			
					columnData.add(rs.getShort("avgScrRead"));
				
					columnData.add(rs.getShort("avgScrMath"));
					columnData.add(rs.getShort("avgScrWrite"));
					
				}
			tableRecords.addRow(columnData); 
			}	
			
			
		} catch (Exception e) {
			
			e.printStackTrace(); 
		}}
			
	

	
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
	
	
					
		
	private void SelectedRow () {
		
		int row = scoretbl.getSelectedRow();
		if (row > -1) { 
			String CDS = scoretbl.getValueAt(row,0).toString(); 
			String sname = scoretbl.getValueAt(row,1).toString();
			String dname = scoretbl.getValueAt(row,2).toString() ;
			String cname = scoretbl.getValueAt(row,3).toString();
			String numTstTaken = scoretbl.getValueAt(row,4).toString(); 
			String avgScrRead = scoretbl.getValueAt(row,5).toString(); 
			String avgScrMath = scoretbl.getValueAt(row,6).toString(); 
			String avgScrWrite =  scoretbl.getValueAt(row,7).toString(); 
			
			txtCDS.setText(CDS);
			 
			txtdname.setText(sname);
			txtcname.setText(dname);
			txtsname.setText(cname);
			txttt.setText(numTstTaken);
			txtread.setText(avgScrRead);
			txtMath.setText(avgScrMath);
			txtwrite.setText(avgScrWrite);

			
			
		}
	
		
		}	
	
	 public void UniA() {
	//	UniA SE = new UniA(); 
	//	SE.setVisible(true);
	//	this.setVisible(false);
	
	 }
	public void setVisible(boolean visible) {	
	super.setVisible( visible);
	if(visible == true);
	loadTable() ; 
	
	
}
	
	public void delete() { 
		
	String	sql = "DELETE FROM satscores WHERE dname ="; 
	
	DefaultTableModel tblModel = (DefaultTableModel)scoretbl.getModel();
	if(scoretbl.getSelectedRowCount()== 1) {
		tblModel.removeRow(scoretbl.getSelectedRow()); 
	}
		else if(scoretbl.getRowCount() == 0 ) {
			JOptionPane.showMessageDialog(this, "Table is empty");
			
			
		}else {
			JOptionPane.showMessageDialog(this, "Please select a single row!");
		
	}
			
	}
	public void save() { 
		
		
				
		}
	
	public void update() {
		
		DefaultTableModel tblModel = (DefaultTableModel)scoretbl.getModel(); 
		if(scoretbl.getSelectedRowCount() ==1 ) {
			
			
			String CDS = txtCDS.getText();
			String sname = txtsname.getText(); 
			String dname = txtdname.getText(); 
			String cname =	txtcname.getText(); 
			String numTstTaken = txttt.getText(); 
			String avgScrRead = txtread.getText(); 
			String avgScrMath = txtMath.getText();
			String avgScrWrite =  txtwrite.getText();
			
			
			scoretbl.setValueAt(CDS, scoretbl.getSelectedRow(), 0); 
			scoretbl.setValueAt(sname, scoretbl.getSelectedRow(), 1); 
			scoretbl.setValueAt(dname, scoretbl.getSelectedRow(), 2); 
			scoretbl.setValueAt(sname, scoretbl.getSelectedRow(), 3); 
			scoretbl.setValueAt(numTstTaken, scoretbl.getSelectedRow(), 4); 
			scoretbl.setValueAt(avgScrRead, scoretbl.getSelectedRow(), 5); 
			scoretbl.setValueAt(avgScrMath, scoretbl.getSelectedRow(), 6); 
			scoretbl.setValueAt(avgScrWrite, scoretbl.getSelectedRow(), 7); 
			
			JOptionPane.showMessageDialog(this, "Update Succesfully"); 
			
		}else if(scoretbl.getRowCount() == 0 ) {
				 
			
			JOptionPane.showMessageDialog(this, "Table is Empty"); 
			
	}	
			else {
			
			JOptionPane.showMessageDialog(this, "Please select single Row for Update"); 
			
		}
			
	}
	
	private void add() {
		 
		if(txtCDS.getText().equals ("") || txtsname.getText().equals("")|| txtdname.getText().equals("")||
			txtcname.getText().equals("")|| txttt.getText().equals("")|| txtread.getText().equals("")|| txtMath.getText().equals("")||txtwrite.getText().equals("") ) {
			
			JOptionPane.showMessageDialog(this, "Please Enter All Data"); 
			
		}else {
			String data [] = {txtCDS.getText(),txtsname.getText(), txtdname.getText(), 
					txtdname.getText(), txtcname.getText(), txttt.getText(),txtread.getText(), txtMath.getText(), txtwrite.getText() }; 
			
			DefaultTableModel tblModel = (DefaultTableModel) scoretbl.getModel(); 
	
			
			JOptionPane.showMessageDialog(this, "Data added succesfully");}
			
		}
			
		
	
		private void search() { 
		
			
		
			try { 
				
				String searchTemp = txtSearch.getText()+ "%"; 
				conn = DBManager.getConnection(); 
				
				
				PreparedStatement pstm = conn.prepareStatement("SELECT * FROM satscores WHERE cname LIKE  '"+ searchTemp +"'" ); 
				
				ResultSet rs = pstm.executeQuery () ;
				
				
				ResultSetMetaData data = rs.getMetaData();
				int y = data.getColumnCount();
				
				DefaultTableModel tableRecords = (DefaultTableModel)scoretbl.getModel(); 
				scoretbl.setModel(DBManager.buildTableModel(rs)); 
				tableRecords.setRowCount(0); 
			
				
				while(rs.next()) {
					Vector columnData = new Vector(); 
					for(int x=1; x<=y ;  x++) {
						
						columnData.add(rs.getShort("CDS"));
						columnData.add(rs.getShort("sname"));
						columnData.add(rs.getShort("cname"));
						columnData.add(rs.getShort("dname"));
						columnData.add(rs.getShort("numTstTaken"));
						columnData.add(rs.getShort("avgScrRead"));
						columnData.add(rs.getShort("avgScrRead"));
						columnData.add(rs.getShort("avgScrMath"));
						columnData.add(rs.getShort("avgScrMath"));
						columnData.add(rs.getShort("avgScrWrite"));
						
					}
					 
				tableRecords.addRow(columnData); 
				}	
				
				
			} catch (Exception e) {
				
				e.printStackTrace(); 
			}
}
		
		
		
		
		public void OptionWindow() {
			
			OptionWindow OW = new OptionWindow(); 
			OW.setVisible(true); 
			this.setVisible(false);
		}
		
		public void Editor() { 
			Editor ED = new Editor();
			ED.setVisible(true);
			this.setVisible(false);
		}
		
}


