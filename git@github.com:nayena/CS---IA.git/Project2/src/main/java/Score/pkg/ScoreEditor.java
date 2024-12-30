	package Score.pkg;
	
	import java.awt.EventQueue;
	
	import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartPanel;
	import org.jfree.chart.JFreeChart;
	import org.jfree.chart.plot.PlotOrientation;
	import org.jfree.chart.plot.XYPlot;
	import org.jfree.chart.renderer.xy.XYItemRenderer;
	import org.jfree.chart.renderer.xy.XYShapeRenderer;
	import org.jfree.data.xy.XYSeries;
	import org.jfree.data.xy.XYSeriesCollection;
	import java.awt.Shape;
	import java.awt.geom.Ellipse2D;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.LineBorder;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JButton;
	import javax.swing.JSpinner;
	import java.awt.Font;
	import java.awt.GridLayout;
	
	import javax.swing.JTextArea;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartPanel;
	import org.jfree.chart.JFreeChart;
	import org.jfree.chart.plot.CategoryPlot;
	import org.jfree.chart.plot.PlotOrientation;
	import org.jfree.chart.renderer.category.BarRenderer;
	import org.jfree.data.category.DefaultCategoryDataset;
	import org.jfree.data.jdbc.JDBCCategoryDataset;
	import org.jfree.data.xy.XYDataset;
	
	import javax.swing.SwingConstants;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import javax.swing.JComboBox;
	import javax.swing.JTextField;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
	
	
	
	public class ScoreEditor extends JFrame {
	
		private JPanel contentPane;
	
		private table4 parent ;
	
	
	
		private JPanel panelChart;
	
		private JLabel houseIcon;
	
	
		private JButton btnCalculate;
		
		
		Connection conn=null ; 
	
	
		  Connection con= null;
		    ResultSet rs = null;
		    PreparedStatement pst = null;
		    private JComboBox cbmUni;
		    private JTextField resultLabel;
		    private JLabel lblIbScore;
		    private JTextField txtInput;
		    private JLabel errorLabel;
		    private JButton btnNewButton;
	
			private int minIBScore;
	
			private int userIBScore;
	
			
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ScoreEditor frame = new ScoreEditor();
							frame.setResizable(false);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		
		
		public ScoreEditor() {
			
			con = SQLSignUp.COnnecrDB(); 
		InitComponents(); 
			
		
			
		}
		
			
		public void InitComponents() { 
			
			
			 setTitle("University Admission Likelihood Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 790, 526);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			btnCalculate = new JButton("Calculate");
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			calculate(); 
					 calculateLikelihood();	
					 displayChart(minIBScore, userIBScore)  ;
					
				}
			});
			btnCalculate.setBounds(405, 306, 175, 48);
			contentPane.add(btnCalculate);
			
			JLabel lblNewLabel_3 = new JLabel("Compare Scores");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 40));
			lblNewLabel_3.setBounds(228, 26, 478, 40);
			contentPane.add(lblNewLabel_3);
			
			JButton btnNewButton_1 = new JButton("View DataBase");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					table4();
				}
			});
			btnNewButton_1.setBounds(405, 357, 175, 48);
			contentPane.add(btnNewButton_1);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 139, 139));
			panel.setBounds(89, 75, 617, 351);
			contentPane.add(panel);
			panel.setLayout(null);
			
			panelChart = new JPanel();
			panelChart.setBackground(SystemColor.window);
			panelChart.setBounds(301, 28, 226, 192);
			panel.add(panelChart);
			panelChart.setLayout(null);
			
			cbmUni = new JComboBox();
			
			cbmUni.setBounds(49, 95, 169, 27);
			data();
			panel.add(cbmUni);
			
			JLabel lblChooseUni = new JLabel("Choose UNI");
			lblChooseUni.setForeground(Color.WHITE);
			lblChooseUni.setBounds(94, 56, 102, 16);
			panel.add(lblChooseUni);
			
			resultLabel = new JTextField();
			resultLabel.setBounds(46, 252, 206, 75);
			panel.add(resultLabel);
			resultLabel.setColumns(10);
			
			lblIbScore = new JLabel("IB Score over 42");
			lblIbScore.setForeground(Color.WHITE);
			lblIbScore.setBounds(78, 160, 102, 16);
			panel.add(lblIbScore);
			
			txtInput = new JTextField();
			txtInput.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					 char c = e.getKeyChar();
		                if (!Character.isDigit(c)) {
		                    e.consume(); // Ignore non-digit input
		                    errorLabel.setVisible(true); // Show the error message
		                } else {
		                    errorLabel.setVisible(false); // Hide the error message
		                }
		            
				}
			});
			txtInput.setColumns(10);
			txtInput.setBounds(66, 201, 130, 26);
			panel.add(txtInput);
			
			errorLabel = new JLabel("Just numbers under 42");
			errorLabel.setForeground(Color.RED);
			errorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			errorLabel.setBounds(66, 215, 169, 47);
			panel.add(errorLabel);
			
			
			
			houseIcon = new JLabel("");
			houseIcon.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
			houseIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				OW(); 
					
				}
			});
			houseIcon.setBorder(new LineBorder(Color.GRAY)); 
			
			houseIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			houseIcon.setBounds(705, 4, 53, 48);
			contentPane.add(houseIcon);
			
			
		
		     
		}
		      
		private void calculateLikelihood() {
		    String selectedUniversity = (String) cbmUni.getSelectedItem();
		    try {
		        userIBScore = Integer.parseInt(txtInput.getText());
		    } catch (NumberFormatException e) {
		        resultLabel.setText("Invalid IB score. Please enter a valid number.");
		        return;
		    }

		    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite")) {
		        PreparedStatement stmt = conn.prepareStatement("SELECT  AVG_GPA FROM STATS WHERE UNI = ?");
		        stmt.setString(1, selectedUniversity);
		        ResultSet resultSet = stmt.executeQuery();

		        if (resultSet.next()) {
		            
		            minIBScore = resultSet.getInt("AVG_GPA"); // This should be MIN_IB

		            // Now display the chart with the correct scores
		            displayChart(minIBScore, userIBScore);

		            // Rest of your calculation logic...
		        } else {
		            resultLabel.setText("University not found in the database.");
		        }
		    } catch (Exception e) {
		        resultLabel.setText("Error calculating likelihood: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

		private void displayChart(int minScore, int userScore) {
		    XYSeriesCollection dataset = new XYSeriesCollection();
		    XYSeries minScoreSeries = new XYSeries("Minimum Required Score");
		    minScoreSeries.add(1, minScore);
		    dataset.addSeries(minScoreSeries);

		    XYSeries userScoreSeries = new XYSeries("Your Score");
		    userScoreSeries.add(2, userScore);
		    dataset.addSeries(userScoreSeries);

		    JFreeChart chart = ChartFactory.createScatterPlot(
		        "IB Score Comparison",
		        "Category",
		        "Score",
		        dataset,
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false);

		    XYPlot plot = chart.getXYPlot();
		    XYItemRenderer renderer = plot.getRenderer();
		    renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
		    renderer.setSeriesPaint(0, Color.RED);
		    renderer.setSeriesShape(1, new Ellipse2D.Double(-3, -3, 6, 6));
		    renderer.setSeriesPaint(1, Color.GREEN);

		    ChartPanel chartPanel = new ChartPanel(chart);
		    chartPanel.setPreferredSize(new Dimension(panelChart.getWidth(), panelChart.getHeight()));

		    panelChart.setLayout(new BorderLayout()); // Set BorderLayout for panelChart
		    panelChart.removeAll();
		    panelChart.add(chartPanel, BorderLayout.CENTER);
		    panelChart.validate();
		    panelChart.repaint();
		}
	
		// Calculate likelihood based on IB score
		private double calculateLikelihood(int userIBScore, double acceptanceRate) {
		
		    if (userIBScore >= 40) {
		        return 100.0;
		    } else if (userIBScore >= 38) {
		        return 80.0;
		    } else if (userIBScore >= 35) {
		        return 60.0;
		    } else if (userIBScore >= 30) {
		        return 40.0;
		    } else if (userIBScore >= 28) {
		        return 20.0;
		    } else {
		        return 10.0;
		    }
		}
		    	
		
		public void  table4() {
			table4 t4 = new table4 (); 
			t4.setVisible(true); 
			this.setVisible(false);
		}
		
		
	
		public void data() {
	
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
			}
	
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public void OW () {
			OptionWindow OW = new OptionWindow (); 
			OW.setVisible(true);
			this.setVisible(false); 
		}
		
		
		private void calculate() {
		    // Retrieve the selected university from a combo box model
		    String selectedUniversity = (String) cbmUni.getSelectedItem();

		    int userIBScore;
		    try {
		        // Parse the user's IB score from the text input field
		        userIBScore = Integer.parseInt(txtInput.getText());
		    } catch (NumberFormatException e) {
		        // If parsing fails, display an error message and exit the method
		        resultLabel.setText("Invalid IB score. Please enter a valid number.");
		        return;
		    }

		    // Attempt to establish a connection to the SQLite database
		    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite")) {
		        // Prepare a SQL statement to query the database
		        PreparedStatement stmt = conn.prepareStatement("SELECT ACCEP_RATE, AVG_GPA FROM STATS WHERE UNI = ?");
		        stmt.setString(1, selectedUniversity); // Set the query parameter to the selected university
		        ResultSet resultSet = stmt.executeQuery(); // Execute the query

		        // Check if the query returned any results
		        if (resultSet.next()) {
		            // Retrieve acceptance rate and average GPA from the result set
		            double acceptanceRate = resultSet.getDouble("ACCEP_RATE");
		            minIBScore = resultSet.getInt("AVG_GPA");

		            // Compare the user's score to the minimum IB score and provide appropriate feedback
		            if (userIBScore > minIBScore) {
		                // Specific message for a score of 42
		                if (userIBScore == 42) {
		                    resultLabel.setText("It's an amazing score, you can apply! The chances are really high. Let me assist you.");
		                } else {
		                    resultLabel.setText("Your score is good for this university. Let me assist you.");
		                }
		            } else if (userIBScore == minIBScore) {
		                // Message for an average score
		                resultLabel.setText("It is an average score, you can try and see.");
		            } else {
		                // Message for a score below the average
		                resultLabel.setText("Maybe you should consider applying to other universities.");
		            }
		        } else {
		            // Message if the university is not found in the database
		            resultLabel.setText("University not found in the database.");
		        }
		    } catch (Exception e) {
		        // Catch any other exceptions and print the stack trace for debugging
		        e.printStackTrace();
		        // Display an error message with the exception's message
		        resultLabel.setText("Error calculating likelihood: " + e.getMessage());
		    }
		}
		}
