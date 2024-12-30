package Score.pkg;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class OptionWindow extends JFrame {

	private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton btnUniPre;
		private JButton btnSearch;
		private JButton btnViewT;
		private JButton btnNewButton_1;
		private JButton roundedButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					OptionWindow frame = new OptionWindow();
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
	public OptionWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout ());
		
		
		setForeground(new Color(85, 107, 47));
		setBounds(100, 100, 445, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(27, 27, 389, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnViewT = new JButton("View Tables");
		btnViewT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DB(); 
			}
		});
		btnViewT.setForeground(new Color(255, 255, 255));
		btnViewT.setBounds(40, 210, 306, 61);
		btnViewT.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.add(btnViewT);
		
		btnSearch = new JButton("Predictor");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UniA(); 
				
			}
			
			
		});
		btnSearch.setBounds(40, 303, 305, 61);
		btnSearch.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.add(btnSearch);
		
		btnUniPre = new JButton("Calculation");
		btnUniPre.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
		ScoEdi();
		
		}
		});
		btnUniPre.setForeground(new Color(255, 255, 255));
		btnUniPre.setBounds(40, 389, 306, 61);
		btnUniPre.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.add(btnUniPre);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logIn (); 
			}
		});
		btnNewButton.setBounds(259, 6, 117, 42);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Stats");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table4 () ;
			}
		});
		btnNewButton_1.setBounds(40, 478, 306, 61);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.add(btnUniPre);
		
		
		JLabel lblUniIcon = new JLabel();
	      lblUniIcon.setIcon(new ImageIcon("/Users/naran128386/Downloads/unicon..png"));
		lblUniIcon.setBounds(126, 59, 143, 139);
		panel.add(lblUniIcon);
        panel.setVisible(true);
    };
	
	
	public void DB() {
	DB db = new DB();
	db.setVisible(true); 
	this.setVisible(false);
		
	}
	
	public void UniA() {
		UniOp UA = new UniOp();
		UA.setVisible(true); 
		this.setVisible(false); 			
	}
	
	public void logIn () {
		
		LogIn LI = new LogIn () ; 
		LI.setVisible(true);
		this.setVisible(false);
	}
	
	public void  ScoEdi() {
		
		
		ScoreEditor SE = new ScoreEditor () ; 
		SE.setVisible(true); 
		this.setVisible(false);
		
		
		
	}
	public void Table4 () {
		
		table4 t4 = new table4 ();
		t4.setVisible(true);
		this.setVisible(false);
	}
	
	
	public void roundedButton () {
		 
	}
}
