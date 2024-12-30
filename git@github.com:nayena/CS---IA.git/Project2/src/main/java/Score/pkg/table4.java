package Score.pkg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import java.awt.SystemColor;

public class table4 extends JFrame {

	private JPanel pnlimg;
	private  JTable tbluni;
	
	
	private table4 parent; 
	
	
	private JTextField txtlocation;
	private JTextField txtaccept;
	private JTextField txtsatop;
	private JTextField txtavgsat;
	private JTextField txtminsat;
	private JTextField txtavggpa;
	private JTextField txturl;
	
	
	
//	private JPanel contentPane;

	
	Connection conn; 
	private JTextField txtAVG;
	private JLabel imageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table4 frame = new table4();
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
	public table4() {

		conn = SQLSignUp.COnnecrDB(); 
		GUI();
}


	public void loadTable () { 
	

	
	
	try { 
		
		conn = SQLSignUp.COnnecrDB(); 
		
		
		PreparedStatement pstm = conn.prepareStatement("SELECT * FROM STATS "); 
		
		ResultSet rs = pstm.executeQuery () ;
		
		
		tbluni.setModel(DBManager.buildTableModel(rs)); 
		
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
	
	
	public void table3() { 
		
		Table3 T3 = new Table3(); 
		T3.setVisible(true);
		this.setVisible(false); 
		
	}
	private void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 646);
		pnlimg = new JPanel();
		pnlimg.setBackground(new Color(0, 139, 139));
		pnlimg.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
		houseIcon.setBounds(346, 3, 49, 42);
		pnlimg.add(houseIcon);

		setContentPane(pnlimg);
		pnlimg.setBorder(new EmptyBorder(5,10, 10, 5)); 
		pnlimg.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 290, 863, 257);
		pnlimg.add(scrollPane);
		
		
		tbluni = new JTable() {
		
			public boolean isCellEditable(int row, int column) {
					
			return false; 
			
			}

		};
		
		tbluni.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				   if (e.getClickCount() == 2) {
			      
						DefaultTableModel tblModel = (DefaultTableModel)tbluni.getModel();		
						
						 
						SelectedRow();
						
						System.out.println("double click");
			        }
			}
		});
		tbluni.setColumnSelectionAllowed(true);
		tbluni.setCellSelectionEnabled(true);
		tbluni.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(tbluni);
		
        loadTable(); 
        
        
        JButton btnNewButton_1 = new JButton("Schools");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				table2(); 
			}		
			
		});
		btnNewButton_1.setBounds(6, 240, 117, 29);
		pnlimg.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("View Chart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				draw(); 
			}
		});
		btnNewButton.setBounds(118, 263, 117, 29);
		pnlimg.add(btnNewButton);
		
		 
		
		txtlocation = new JTextField();
		txtlocation.setBounds(27, 54, 130, 26);
		pnlimg.add(txtlocation);
		txtlocation.setColumns(10);
		
		txtaccept = new JTextField();
		txtaccept.setColumns(10);
		txtaccept.setBounds(27, 116, 130, 26);
		pnlimg.add(txtaccept);
		
		txtsatop = new JTextField();
		txtsatop.setColumns(10);
		txtsatop.setBounds(27, 182, 130, 26);
		pnlimg.add(txtsatop);
		
		txtavgsat = new JTextField();
		txtavgsat.setColumns(10);
		txtavgsat.setBounds(209, 182, 130, 26);
		pnlimg.add(txtavgsat);
		
		txtminsat = new JTextField();
		txtminsat.setColumns(10);
		txtminsat.setBounds(209, 118, 130, 26);
		pnlimg.add(txtminsat);
		
		txtavggpa = new JTextField();
		txtavggpa.setColumns(10);
		txtavggpa.setBounds(209, 54, 130, 26);
		pnlimg.add(txtavggpa);
		
		txturl = new JTextField();
		txturl.setColumns(10);
		txturl.setBounds(108, 215, 117, 26);
		pnlimg.add(txturl);
	
		JLabel lbllocation = new JLabel("UNIVERSITY");
		lbllocation.setBounds(27, 26, 111, 16);
		pnlimg.add(lbllocation);
		
		JLabel lblAcceptanceRate = new JLabel("LOCATION");
		lblAcceptanceRate.setBounds(27, 90, 173, 16);
		pnlimg.add(lblAcceptanceRate);
		
		JLabel lblSatOp = new JLabel("SAT Op");
		lblSatOp.setBounds(222, 154, 173, 16);
		pnlimg.add(lblSatOp);
		
		JLabel lblAvgGpa = new JLabel("AVG GPA");
		lblAvgGpa.setBounds(209, 92, 173, 16);
		pnlimg.add(lblAvgGpa);
		
		JLabel lblMinSat = new JLabel("min SAT");
		lblMinSat.setBounds(27, 220, 173, 16);
		pnlimg.add(lblMinSat);
		
		JLabel lblAvgSat = new JLabel("AVG SAT");
		lblAvgSat.setBounds(209, 26, 173, 16);
		pnlimg.add(lblAvgSat);
		
		JLabel lblImg = new JLabel("IMG URL");
		lblImg.setBounds(290, 245, 61, 16);
		pnlimg.add(lblImg);
		

		JButton btnload = new JButton("load");
		btnNewButton.setBounds(108, 240, 117, 29);
		pnlimg.add(btnNewButton); 
		
		txtAVG = new JTextField();
		txtAVG.setColumns(10);
		txtAVG.setBounds(374, 240, 316, 26);
		pnlimg.add(txtAVG);
		
		JButton btnNewButton_2 = new JButton("LOAD/SAVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				load(); 
			}
		});
		btnNewButton_2.setBounds(722, 240, 117, 29);
		pnlimg.add(btnNewButton_2);
		
		imageLabel = new JLabel("");
		imageLabel.setBackground(SystemColor.window);
		imageLabel.setBounds(477, 26, 302, 182);
		pnlimg.add(imageLabel);
		
	}
	
	public void  OptionWindow() {
		OptionWindow OW = new OptionWindow (); 
		OW.setVisible(true);
		this.setVisible(false); 
	}
	
	private void draw() {
	    
	    // Try-catch block to handle any exceptions that may occur during the database operation and chart creation
	    try {
	        // SQL query to select specific columns from the STATS table
	        String query = "SELECT UNI, AVG_GPA, MIN_SAT, AVG_SAT FROM STATS ";
	        
	        // Creating a dataset by executing the SQL query and establishing a database connection
	        JDBCCategoryDataset dataset = new JDBCCategoryDataset(SQLSignUp.COnnecrDB(), query);
	        
	        // Using JFreeChart library to create a line chart with the dataset obtained from the SQL query
	        JFreeChart chart = ChartFactory.createLineChart("UNI STATS", "AVG_GPA", "AVG_SAT", dataset, PlotOrientation.VERTICAL, false, true, true);
	        
	        // Variables for customizing the chart appearance
	        BarRenderer renderer = null;
	        CategoryPlot plot = null;
	        renderer = new BarRenderer();
	        
	        // Creating a frame to display the chart, setting its title to "query chart"
	        ChartFrame frame = new ChartFrame("query chart", chart);
	        
	        // Making the frame visible and setting its size
	        frame.setVisible(true);
	        frame.setSize(400, 650);
	    
	    } catch (Exception e) { // Catching any exceptions that occur during the drawing process
	        
	        // Displaying an error message dialog with the exception details
	        JOptionPane.showMessageDialog(null, e);
	    }
	}
	
	private void SelectedRow() {
		
		int row = tbluni.getSelectedRow();
		if (row > -1) { 
		
			String location = tbluni.getValueAt(row,0).toString(); 
			String accepRate = tbluni.getValueAt(row,1).toString();
			String SATop = tbluni.getValueAt(row,2).toString() ;
			String AVG_GPA = tbluni.getValueAt(row,3).toString();
			String min_SAT = tbluni.getValueAt(row,4).toString(); 
			String AVG_SAT = tbluni.getValueAt(row,5).toString();
			String AVG = tbluni.getValueAt(row,6).toString(); 
			String IMG = tbluni.getValueAt(row,7).toString(); 
			
			
			txtlocation.setText(location) ;
			txtaccept.setText(accepRate) ;
			txtsatop.setText(SATop) ;
			txtavgsat.setText(AVG_GPA) ;
			txtminsat.setText(min_SAT) ;
			txtavggpa.setText(AVG_SAT) ;
			
			txturl.setText(AVG) ;
			
		    txtAVG.setText(IMG);
			
		}
	
	
	}
	private void load() {
		   String imageUrl = txtAVG.getText(); // Get URL from the JTextField
		    try {
		        // Load the image from the URL
		        ImageIcon image = new ImageIcon(new URL(imageUrl));

		        // Debug: Print out image dimensions
		        System.out.println("Image Icon Width: " + image.getIconWidth());
		        System.out.println("Image Icon Height: " + image.getIconHeight());

		        // Check if the image was loaded successfully
		        if (image.getIconWidth() == -1) {
		            JOptionPane.showMessageDialog(this, "Failed to load image.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Display the image in a JLabel
		        imageLabel.setIcon(image);
		        imageLabel.repaint();
		    } catch (MalformedURLException ex) {
		        JOptionPane.showMessageDialog(this, "Invalid URL: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        ex.printStackTrace();
		    } catch (IOException ex) {
		        JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        ex.printStackTrace();
		    }
	}
	
	
	
	}	
	
		
		
	
	
	
	

	


