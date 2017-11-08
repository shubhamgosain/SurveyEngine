package createsurvey;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import DBConn.DataSource;
//import Login.Registration_DB;
import Login.usernew;
//import fill.Survey_db;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class New_Questions extends JFrame {

	private JPanel contentPane;
	JPanel iniialpanel;
	JPanel currentpanel;
	String Tablename;
	PreparedStatement ps;
	String emailid;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	MCQ_Panel m;
	DropDown_Panel d;
	CheckBox_Panel c;
	Textfield_Panel t;
	String current="x";
	Double SurveyCreationAmount=0.0;
	Double Balance=0.0;
	Double Fillingreward=0.0;
	int nooOfQuestons=0;
		public New_Questions(String Tablename,String emailid) {
		
		
		this.Tablename=Tablename;
		this.emailid=emailid;
		UserDAOImplements udao=new UserDAOImplements();
		try {
			Balance=udao.getAmount(emailid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
setLayout(null);
		setBounds(screenwidth-680,screenHeight-384,1360,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		setUndecorated(true);
		contentPane.setBackground(new Color(255, 204, 128));
		
		
		
		iniialpanel = new JPanel();
		iniialpanel.setBounds(45,50,1260,570);
		iniialpanel.setLayout(null);
		iniialpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		contentPane.add(iniialpanel);
		currentpanel=iniialpanel;
		
		
		
		JButton btnTextfield = new JButton("TextField");
		btnTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentpanel.setVisible(false);
	    		currentpanel=new Textfield_Panel();
	    		t=(Textfield_Panel) currentpanel;
				contentPane.add(currentpanel);
				current="t";
				}});
		btnTextfield.setBounds(45, 650, 155, 50);
		btnTextfield.setFont(new Font("Simsun",Font.BOLD,20));
		contentPane.add(btnTextfield);
		btnTextfield.setForeground(Color.black);

		
		
		
		JButton btncheckboxButton = new JButton("Check Box");
		btncheckboxButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentpanel.setVisible(false);
	    		currentpanel=new CheckBox_Panel();
	    		c=(CheckBox_Panel) currentpanel;
				contentPane.add(currentpanel);
				current="c";
			}});
		contentPane.add(btncheckboxButton);
		btncheckboxButton.setBounds(425, 650, 155, 50);
		btncheckboxButton.setFont(new Font("Simsun",Font.BOLD,20));
		
		
		
		
		
		JButton btnDropDownButton_1 = new JButton("Drop Down");
		btnDropDownButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentpanel.setVisible(false);
	    		currentpanel=new DropDown_Panel();
	    		d=(DropDown_Panel) currentpanel;
				contentPane.add(currentpanel);
				current="d";
			}});
		contentPane.add(btnDropDownButton_1);
		btnDropDownButton_1.setBounds(800, 650, 155, 50);
		btnDropDownButton_1.setFont(new Font("Simsun",Font.BOLD,20));
		
		
		
		JButton btnMCQButton_2 = new JButton("MCQ");
		btnMCQButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentpanel.setVisible(false);
	    		currentpanel=new MCQ_Panel();
	    		m=(MCQ_Panel) currentpanel;
				contentPane.add(currentpanel);
				current="m";
			}
		});
		contentPane.add(btnMCQButton_2);
		
		btnMCQButton_2.setBounds(1150, 650, 155, 50);
		btnMCQButton_2.setFont(new Font("Simsun",Font.BOLD,20));
		
		
		
		
		
		
		
		JLabel lblDefault = new JLabel("<html>&emsp &emsp &emsp ADD NEW QUESTION<br><br>Select a Type from the Underlying options</html>");
		lblDefault.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDefault.setFont(new Font("Simsun",Font.BOLD,26));
		lblDefault.setBounds(350, 131,900, 150);
		iniialpanel.add(lblDefault);
		
		
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(570, 10, 150, 30);
		btnCancel.setFont(new Font("Simsun",Font.BOLD,20));
		
		contentPane.add(btnCancel);
		btnCancel.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mouseClicked(java.awt.event.MouseEvent evt){
		
		    		SurveyDAOImplements sdao=new SurveyDAOImplements();
		    		try {
		    			sdao.DropTable(Tablename);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		dispose();
		    	}});
		
		
		JButton btnNewButton_4 = new JButton("NEXT");
		btnNewButton_4.setBounds(1150, 10, 155, 30);
		btnNewButton_4.setFont(new Font("Simsun",Font.BOLD,20));
		
		contentPane.add(btnNewButton_4);
		 btnNewButton_4.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mousePressed(java.awt.event.MouseEvent evt){
		    		if(current.equals("x"))
	    			{
	    			JOptionPane.showMessageDialog(null,"Insert A question First");
	    			}
		    		else if((nooOfQuestons*5)>=Balance-10)
		    		{
		    			JOptionPane.showMessageDialog(null,"You Dont have enough money to create this Question !!!!Click Finish to Create this Survey");
		    		}
		    		else{
		    			nooOfQuestons++;
		    			currentpanel.setVisible(false);
		    			
		    		CreateQuestion();
		    		iniialpanel.setVisible(true);
		    		currentpanel=iniialpanel;
		    		JOptionPane.showMessageDialog(null,"Question Successfully Registered");
		    		current="x";
		    			}

		    	}
		  });

		
		 
		 
		 JButton btnNewButton_5 = new JButton("Finish");
		 btnNewButton_5.setBounds(45, 10, 155, 30);
		 btnNewButton_5.setFont(new Font("Simsun",Font.BOLD,20));
			
			contentPane.add(btnNewButton_5);
			btnNewButton_5.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mouseClicked(java.awt.event.MouseEvent evt){
		    		JOptionPane.showMessageDialog(null,nooOfQuestons+" Survey Questions Created");
		    		
		    		Panel end=new Panel(nooOfQuestons,Balance);
		    		contentPane.setVisible(false);
		    		setContentPane(end);
		    		JButton finish=new JButton("Finish");
		    		finish.setBounds(550,620, 150, 50);
		    		end.add(finish);
		    		 finish.addMouseListener(new java.awt.event.MouseAdapter(){
		    		    	public void mouseClicked(java.awt.event.MouseEvent evt){
		    		    		
		    		    		if(CreateSurvey(end)==0)
		    		    		JOptionPane.showMessageDialog(null,"Creation Amount Exceeds your Balance!!!  Make Choices Accordingly");
		    		    		else
		    		    		ThankYou(end);
		    		    		
		    		    	}});
		    		
		    		
		    		   	}});
		 
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 640, 378);
		lblNewLabel.setLayout(null);
		contentPane.add(lblNewLabel);
	}




void ThankYou(Panel end)
{
	end.setVisible(false);
	JPanel p=new JPanel();
	

	p.setLayout(null);
	p.setBounds(100, 100, 1180, 620);
	p.setVisible(true);
	JLabel complete=new JLabel("<html>Your Survey is Created with "+nooOfQuestons+" Questions...And its Request is been sent<br>The Survey Cost you "+SurveyCreationAmount+"<html>");
	complete.setBounds(15,15,1000,60);
	
			
	complete.setFont(new Font("Simsun",Font.BOLD,22));
	p.add(complete);
	setContentPane(p);
	JButton jb=new JButton("Continue");
	jb.setBounds(500,500,150,50);
	p.add(jb);
	jb.addMouseListener(new java.awt.event.MouseAdapter(){
    	public void mouseClicked(java.awt.event.MouseEvent evt){
    		//Survey_db db=new Survey_db();
    		SurveyDAOImplements sdao=new SurveyDAOImplements();
    		try {
				sdao.createResponseTable(Tablename);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	dispose();
	
    	}});
}




private void CreateQuestion() {
	
	String query="insert into "+Tablename+" values(?,?,?)";
	System.out.println(query);
	try {
			ps=DataSource.con.prepareStatement(query);
			
			
			switch (current) {
			case "m":ps.setString(1,m.question.getText());
			ps.setString(3,m.MCQdata.getText());
			break;

			case "c":ps.setString(1,c.question.getText());
			ps.setString(3,c.checkboxdata.getText());
			break;

			case "d":ps.setString(1,d.question.getText());
				ps.setString(3,d.dropDowndata.getText());
				
			break;

			case "t":ps.setString(1,t.question.getText());
			ps.setString(3,t.textAreaInfo.getText());
				break;

			}
			ps.setString(2,current);
			
			
			
			ps.executeUpdate();
			System.out.println("Successfully inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("2");	
}


public int CreateSurvey(Panel end) {
	
System.out.println("1");
System.out.println(end.comboBox.getSelectedItem().toString());
System.out.println(end.checkvalue().length());
SurveyCreationAmount=(nooOfQuestons*(Double.parseDouble(end.comboBox.getSelectedItem().toString())+end.checkvalue().length()*5+5)) +5;
System.out.println("ErrorHandling");
System.out.println(SurveyCreationAmount);

if(SurveyCreationAmount<=Balance)
	{
	try {
		String query="insert into Survey values(?,?,?,?,?,?,?,?,?,?)";
			ps=DataSource.con.prepareStatement(query);
			ps.setString(1, Tablename);
			ps.setString(2, emailid);
			ps.setString(3, end.checkvalue());
			ps.setDate(4, getdate());
			ps.setDate(5,null);
			ps.setDate(6,null);
			ps.setString(7,"0");
			ps.setString(8,end.comboBox.getSelectedItem().toString());
			ps.setString(9,Double.toString(SurveyCreationAmount));
			Fillingreward=SurveyCreationAmount/20;
			System.out.println(Fillingreward);
			ps.setString(10,Double.toString(Fillingreward));
			
			ps.executeUpdate();
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
else return 0; 
return 0;
}



public java.sql.Date getdate()
{
	java.util.Date date = new java.util.Date();
    long t = date.getTime();
    java.sql.Date sqlDate = new java.sql.Date(t);	
	return sqlDate;
}

public New_Questions(){

}



}





