package Score.pkg;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;

public class stage3 extends JFrame {

	private JPanel contentPane;
	
	private JLabel  wordCountLabel; 
	private JTextArea textArea;
	
	
	Connection conn=null;
    ResultSet rs= null;
    PreparedStatement pst = null;

	private JLabel txtessay;

	private JButton btnnext;

	private JButton btnback;
	private JTextArea txtComment;
	private JButton btnComment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stage3 frame = new stage3();
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
	public stage3() {
		conn = SQLSignUp.COnnecrDB(); 
		
		GUI();
	}
		
		private void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		
		
		
		  wordCountLabel = new JLabel("Word Count: 0/650");
	        wordCountLabel.setBounds(124, 400, 150, 20); // Set appropriate position
	        contentPane.add(wordCountLabel);

		
		txtessay = new JLabel("Insert your common App Essay (max 650)");
		txtessay.setBounds(124, 62, 285, 35);
		contentPane.add(txtessay);
		
		btnnext = new JButton("Next");
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				collectInfo();
			//	add();
				
				
				

				try {
					String essay = textArea.getText();
					String comment=ChatGPT1.answerMe(essay);
					System.out.println(essay);
					System.out.println(comment);
					
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			
				next(); 
			}
		});
		btnnext.setBounds(553, 670, 117, 29);
		contentPane.add(btnnext);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				back();
			}
		});
		btnback.setBounds(157, 670, 117, 29);
		contentPane.add(btnback);
		
		txtComment = new JTextArea();
	
		btnComment = new JButton("Comment");
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String activity = textArea.getText();
					String score=ChatGPT1.answerMe(activity);
					System.out.println(activity);
					System.out.println(score);
					
				txtComment.setText(score);
				
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
			
			}
		});
		btnComment.setBounds(326, 442, 117, 29);
		contentPane.add(btnComment);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(124, 109, 530, 282);
		contentPane.add(scrollPane);

		JScrollPane scrollPaneComment11 = new JScrollPane(txtComment);
		scrollPaneComment11.setBounds(124, 469, 530, 144);
		contentPane.add(scrollPaneComment11);

		
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }

            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }
        });
    }
	
	   private void updateWordCount() {
	        String text = textArea.getText();
	        String[] words = text.split("\\s+"); // Split text into words
	        int wordCount = words.length;

	        if (!text.isEmpty() && words[0].isEmpty()) {
	            // Correct word count if text starts with space
	            wordCount--;
	        }

	        wordCountLabel.setText("Word Count: " + wordCount + "/650");

	        if (wordCount > 650) {
	            // Truncate text to 650 words
	            String newText = String.join(" ", Arrays.copyOf(words, 650));
	            textArea.setText(newText);
	        }
	    }
	   
	   
	   private void back() {
		   stage2 s2 = new stage2(); 
		   s2.setVisible(true);
		   this.setVisible(false);
		   
	   }
	   
	   private void next() {
		   
		   stage4 s4 = new stage4(); 
		   s4.setVisible(true);
		   this.setVisible(false);
		   
	   }
	   
	   private void collectInfo() {
			
			  DataModel dataModel = DataModelSingleton.getInstance();
			
			  dataModel.setEssay(textArea.getText());
			  dataModel.setComment(txtComment.getText());
			
		}
	   
	}

