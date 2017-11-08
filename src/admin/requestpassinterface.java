package admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import Login.Forgot_Pass;
import fill.FillSurvey;
//import fill.Survey_db;

public class requestpassinterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
		

	public requestpassinterface(String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(screenwidth-640,screenHeight-360, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				      
		   
			JPanel passrequest = new JPanel();
			passrequest.setBounds(50, 50, 1150, 520);
			passrequest.setBorder(new EmptyBorder(5, 5, 5, 5));
			passrequest.setVisible(true);
			passrequest.setBackground(new Color(255, 234, 188));
			
			passrequest.setLayout(null);
			add(passrequest);
		
			JLabel message1=new JLabel();
			message1.setHorizontalAlignment(JLabel.CENTER);
			message1.setForeground(Color.BLACK);
			message1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			message1.setBounds(290, 117, 641, 50);
			message1.setText("Welcome!!!  Please Pass this request  ");
		
			
			
			JLabel jdirectrequest=new JLabel("PASS REQUEST");
			jdirectrequest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jdirectrequest.setForeground(Color.DARK_GRAY);
			jdirectrequest.setHorizontalAlignment(JLabel.CENTER);
			jdirectrequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			jdirectrequest.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			jdirectrequest.setBounds(249, 451, 188, 37);
			
			JLabel fillbutton=new JLabel();
			fillbutton.setText("Fill Form" );
			fillbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			fillbutton.setForeground(Color.DARK_GRAY);
			fillbutton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			fillbutton.setHorizontalAlignment(JLabel.CENTER);
			fillbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			fillbutton.setBounds(554, 451, 131, 37);
			
			JLabel discardbutton = new JLabel("DISCARD REQUEST");
			discardbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			discardbutton.setForeground(Color.DARK_GRAY);
			discardbutton.setHorizontalAlignment(JLabel.CENTER);
			discardbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			discardbutton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			discardbutton.setBounds(794, 451, 188, 37);
			
			
			
			passrequest.add(jdirectrequest);
			passrequest.add(fillbutton);
			passrequest.add(discardbutton);
			passrequest.add(message1);
			
			
			
			

			discardbutton.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
			//Survey_db sdb=new Survey_db();
			SurveyDAOImplements sdao=new SurveyDAOImplements();
			try {
				sdao.UpdateState(name,3);
				JOptionPane.showMessageDialog(null,"Survey Request has been Discarded");
					dispose();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}});
		    
			
			
			
			
			jdirectrequest.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
			//Survey_db sdb=new Survey_db();
			SurveyDAOImplements sdao=new SurveyDAOImplements();
			try {
				String email=sdao.getEmailidFromSurveyname(name);
				UserDAOImplements udao=new UserDAOImplements();
				try {
					udao.setAmount(email, udao.getAmount(email)-sdao.getCreationAmount(name));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sdao.UpdateState(name,1);
				
				JOptionPane.showMessageDialog(null,"Request Accepted");
					dispose();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}});
		        
		     
			fillbutton.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
			
			
			EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FillSurvey frame = new FillSurvey(name,"admin");
							frame.setVisible(true);
							fillbutton.setVisible(false);
						passrequest.setVisible(true);
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
		}}
		);
		        
		        
		        
		        

		
	}

	


}
