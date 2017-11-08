package createsurvey;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.SurveyDAOImplements;
import DBConn.DataSource;
//import javafx.scene.AmbientLight;

public class SurveyName extends JFrame {

	private JPanel contentPane;
	JPanel iniialpanel;
	JPanel currentpanel;
	PreparedStatement ps;
	JTextField surveyname;
	String surveynewname;
	String emailid;
	ResultSet rs;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	public SurveyName(String emailid) {
		
		this.emailid=emailid;
		
		setBounds(screenwidth-400,screenHeight-300 ,800, 600);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 133, 51));
		setResizable(false);
		surveyname=new JTextField("Enter_Survey_Name");
		surveyname.setHorizontalAlignment(JTextField.CENTER);
		surveyname.setFont(new Font("Simsun",Font.BOLD,24));
		surveyname.setBounds(150, 150,500, 40);
		setUndecorated(true);
		contentPane.add(surveyname);
		
		
		JLabel next=new JLabel("NEXT");
		next.setFont(new Font("Simsun",Font.BOLD,24));
		next.setForeground(Color.BLACK);
		next.setBounds(200,300,100,30);
		contentPane.add(next);

		JLabel cancel=new JLabel("CANCEL");
		cancel.setFont(new Font("Simsun",Font.BOLD,24));
		cancel.setForeground(Color.black);
		cancel.setBounds(500,300,100,30);
		contentPane.add(cancel);

		
		
		
		 next.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mouseClicked(java.awt.event.MouseEvent evt){
		    		
		    		CreateSurvey();
		    		New_Questions n=new New_Questions(surveynewname,emailid);
		    		System.out.println(surveynewname);
		    		dispose();
		    		n.setVisible(true);
		    	}
		    	
	});


		 cancel.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mouseClicked(java.awt.event.MouseEvent evt){
		    		
		    		dispose();		    	
		    	}});

		setContentPane(contentPane);

		
		
		
		
	}



	
	private void CreateSurvey() {
	
		
		try {
			ps=DataSource.con.prepareStatement("select * from surveycount");
			rs=ps.executeQuery();
			int surveyno=0;
			if(rs.next())
			{
				surveyno=Integer.parseInt(rs.getString(1));
				ps=DataSource.con.prepareStatement("update surveycount set i="+(++surveyno));
				rs=ps.executeQuery();
				System.out.println("DONe");
				
			}
			surveynewname=surveyname.getText().concat(Integer.toString(surveyno));
			SurveyDAOImplements sdao=new  SurveyDAOImplements();
			try {
				if(sdao.createTable(surveynewname))
				System.out.println("Successfully Table created");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*	
		
			*/
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	



}






