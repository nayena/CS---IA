package Score.pkg;

import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class stage2 extends JFrame {

	
	Connection conn=null;
    ResultSet rs= null;
    PreparedStatement pst = null;


	private JPanel contentPane;

	Statement statement; 
	private JTextArea ta1;
	private JTextArea ta2;
	private JTextArea ta3;
	private JButton btnNext;

	/**
	 * 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stage2 frame = new stage2();
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
	public stage2() {
		
		conn = SQLSignUp.COnnecrDB(); 

		GUI(); 
	}
	
		
		private void  GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stage 2: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("LiSong Pro", Font.PLAIN, 25));
		lblNewLabel.setBounds(88, 6, 142, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Accomplisments");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("LiSong Pro", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(198, 78, 244, 49);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(29, 161, 524, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ta1 = new JTextArea();
		ta1.setName("");
		ta1.setBounds(27, 64, 277, 41);
		panel.add(ta1);
		
		JLabel lblNewLabel_2 = new JLabel("Accomplishments");
		lblNewLabel_2.setBounds(27, 22, 146, 16);
		panel.add(lblNewLabel_2);
		
		ta2 = new JTextArea();
		ta2.setName("");
		ta2.setBounds(27, 175, 277, 41);
		panel.add(ta2);
		
		ta3 = new JTextArea();
		ta3.setName("");
		ta3.setBounds(27, 307, 277, 41);
		panel.add(ta3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Accomplishments");
		lblNewLabel_2_1.setBounds(27, 146, 146, 16);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Accomplishments");
		lblNewLabel_2_2.setBounds(27, 279, 146, 16);
		panel.add(lblNewLabel_2_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OptionWindow();
			}
		});
		btnNewButton.setBounds(225, 279, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon("/Users/naran128386/Downloads/home.png"));
		btnHome.setSelectedIcon(new ImageIcon("/Users/naran128386/Downloads/home.jpg"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OptionWindow(); 
			}
		});
		btnHome.setBounds(16, 20, 48, 49);
		contentPane.add(btnHome);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(334, 603, 93, 29);
		contentPane.add(btnNext);
		btnNext.setBorder(new LineBorder(Color.WHITE));
		
		JLabel lblNewLabel_3 = new JLabel("Name the 3 accomplishments you are most proud of: ");
		lblNewLabel_3.setBounds(29, 133, 524, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				back(); 
			}
		});
		btnBack.setBorder(new LineBorder(Color.WHITE));
		btnBack.setBounds(145, 604, 93, 29);
		contentPane.add(btnBack);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				collectInfo(); 
				
				next();
				
				
			
				try {
					String activity = ta1.getText();
					String score=ChatGPT.answerMe(activity);
					System.out.println(activity);
					System.out.println(score);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
	}





public void OptionWindow() {
	OptionWindow OW = new OptionWindow();
	OW.setVisible(true);
	this.setVisible(false);
}

private void back() {
	
	
	stage1 OW = new stage1();
	OW.setVisible(true);
	this.setVisible(false); 
	
}

private void next() {
	stage3 OW = new stage3();

	OW.setVisible(true);
	this.setVisible(false);
}


private void collectInfo() {
	
	  DataModel dataModel = DataModelSingleton.getInstance();
	
	  dataModel.setAccomp(ta1.getText());
	  dataModel.setAccomp(ta2.getText());  
	  dataModel.setAccomp(ta3.getText());  
	  
	  
}


}

	

