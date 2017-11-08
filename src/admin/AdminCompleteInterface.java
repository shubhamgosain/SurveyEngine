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
import Login.GetSurveyResult;
import fill.FillSurvey;
//import fill.Survey_db;

public class AdminCompleteInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String Surveyname;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
		


	public AdminCompleteInterface(String Surveyname){
		this.Surveyname=Surveyname;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(screenwidth-640,screenHeight-360, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				      
		   
			JPanel adminoptions = new JPanel();
			adminoptions.setBounds(50, 50, 1150, 520);
			adminoptions.setBorder(new EmptyBorder(5, 5, 5, 5));
			adminoptions.setVisible(true);
			adminoptions.setBackground(new Color(255, 234, 188));
			
			adminoptions.setLayout(null);
			add(adminoptions);
		
			JLabel message1=new JLabel();
			message1.setHorizontalAlignment(JLabel.CENTER);
			message1.setForeground(Color.BLACK);
			message1.setFont(new Font("Tahoma", Font.PLAIN, 30));
			message1.setBounds(290, 117, 641, 50);
			message1.setText("Welcome To this Completed Survey ");
		
			
			
			JLabel jdelete=new JLabel("DELETE Survey");
			jdelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jdelete.setForeground(Color.DARK_GRAY);
			jdelete.setHorizontalAlignment(JLabel.CENTER);
			jdelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
			jdelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			jdelete.setBounds(249, 451, 188, 37);
			
			JLabel jResults=new JLabel();
			jResults.setText("RESULTS" );
			jResults.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jResults.setForeground(Color.DARK_GRAY);
			jResults.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			jResults.setHorizontalAlignment(JLabel.CENTER);
			jResults.setFont(new Font("Tahoma", Font.PLAIN, 20));
			jResults.setBounds(554, 451, 131, 37);
			
			JLabel jcancel = new JLabel("CANCEL");
			jcancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jcancel.setForeground(Color.DARK_GRAY);
			jcancel.setHorizontalAlignment(JLabel.CENTER);
			jcancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			jcancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.lightGray));
			jcancel.setBounds(794, 451, 188, 37);
			
			
			
			adminoptions.add(jdelete);
			adminoptions.add(jResults);
			adminoptions.add(jcancel);
			adminoptions.add(message1);
			
			
			
			

			jcancel.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
			dispose();	
		
			
		}});
		    
			
			
			
			
			jdelete.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
		DeleteSurvey();
			
		}});
		        
		     
			jResults.addMouseListener(new java.awt.event.MouseAdapter()
		{
		public void mouseClicked(java.awt.event.MouseEvent evt)
		{
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GetSurveyResult frame=new GetSurveyResult(Surveyname);
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});	
		}}
		);
		        
	}

public void DeleteSurvey()
{
	SurveyDAOImplements sdao=new SurveyDAOImplements();
	try {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure You Want to Delete Survey","Warning",JOptionPane.YES_OPTION);
		if(dialogResult == 0){
			sdao.DeleteSurvey(Surveyname);
			JOptionPane.showMessageDialog(null,"Survey is Succesfully Removed");
			dispose();
		}
		
	} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}


}
