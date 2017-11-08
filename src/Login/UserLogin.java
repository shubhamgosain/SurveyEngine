package Login;
import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import DBConn.DataSource;
import admin.Admin;
import fill.Survey_db;


public class UserLogin {

	JFrame jframe1;
	JTextField jusername;
	JPasswordField jpassword;
	JLabel jBackground,jClose,jMinimize,jDrag,jLogin,jForgotPassword;
	JLabel jcreate;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	int x,y,xmouse,ymouse;
	PreparedStatement ps;
	ResultSet rs;
	String Username;
	

	public UserLogin() {
	editLoginInfo();	
	}
	

	
	
	
	void editLoginInfo()
	{
		
		
		
		
		jframe1=new JFrame();
		jframe1.setLayout(null);
		jframe1.setBounds(screenwidth-428,screenHeight-317,856,634);
		jframe1.setUndecorated(true);
		jframe1.setVisible(true);

		
		jBackground =new JLabel();

		jframe1.setContentPane(jBackground);		
		jBackground.setSize(856,634);
		ImageIcon ic=new ImageIcon("src/Images/Capture.JPG");
		jBackground.setIcon(ic);

		
		
		jusername =new JTextField();
		jframe1.add(jusername);
		jusername.setBounds(220, 230,350, 60);
		Font f=new Font("Simsun",Font.PLAIN,26);
		jusername.setFont(f);
		jusername.setOpaque(true);
		jusername.setText("Email Address");
		jusername.setHorizontalAlignment(JTextField.CENTER);
		Color bg=new Color(25, 25, 25);
		jusername.setBackground(bg);
		jusername.setForeground(Color.gray);
		jusername.setCaretColor(Color.white);
		jusername.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
                jusernameFocusGained(evt);
        	}
			public void focusLost(java.awt.event.FocusEvent evt) {
                jusernameFocusLost(evt);
        	}
		});
		
		jpassword =new JPasswordField();
		jframe1.add(jpassword);
		jpassword.setBounds(220,320,350, 60);
		jpassword.setFont(f);
		jpassword.setOpaque(true);
		jpassword.setText("Password");
		jpassword.setHorizontalAlignment(JTextField.CENTER);
		jpassword.setBackground(bg);
		jpassword.setForeground(Color.GRAY);
		jpassword.setCaretColor(Color.white);
		jpassword.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
                jpasswordFocusGained(evt);
        	}
			
		});
		jClose=new JLabel();
		jframe1.add(jClose);
		jClose.setBounds(822,0,30,30);
		jClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl2MouseClicked(evt);
                DataSource.closeAll();
            }
        });
		
		jMinimize=new JLabel();
		jframe1.add(jMinimize);
		jMinimize.setBounds(792,0,30,30);
		jMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl3MouseClicked(evt);
            }
        });
		jDrag=new JLabel();
		jframe1.add(jDrag);
		jDrag.setBounds(10, 0,780,30);
		jDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jl4MousePressed(evt);
            }
        });
		jDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jl4MouseDragged(evt);
            }
        });
		
	    jLogin =new JLabel();
	    jframe1.add(jLogin);
	    jLogin.setBounds(220, 410, 420, 70);
	    jLogin.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){
	    		
	    		if(jusername.getText().equals("admin")&&jpassword.getText().equals("admin"))
	    			EventQueue.invokeLater(new Runnable() {
	    				public void run() {
	    					try {
	    						Admin frame = new Admin();
	    						frame.setVisible(true);
	    						jframe1.dispose();
	    					} catch (Exception e) {
	    						e.printStackTrace();
	    					}
	    				}
	    			});	
	    		else
	    		CheckLogin();
	    		System.out.println("clicked login");
	    	}

			
	    });
	    jForgotPassword=new JLabel();
	    jframe1.add(jForgotPassword);
		jForgotPassword.setBounds(210 ,520 ,160 ,30);   
		jForgotPassword.addMouseListener(new java.awt.event.MouseAdapter()
				{
				public void mouseClicked(java.awt.event.MouseEvent evt)
				{
					Forgot_Pass fp=new Forgot_Pass();
					jframe1.dispose();
					fp.setVisible(true);		
				}
				}
				);
	  jcreate=new JLabel();
	    jframe1.add(jcreate);
	    jcreate.setBounds(380, 520, 160, 30);
	    jcreate.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){
	    		
	    		EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					NewRegister window = new NewRegister();
	    					
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    			}
	    		});
	    		jframe1.dispose();	
	    	}
	    	
	    });
	    
	    
	
	
	
	}
	
	
	
	
	
	
	
	private void CheckLogin() 
	{
		
		String query="Select * from LOGIN where USERNAME='"+jusername.getText()+"' and PASSWORD='"+jpassword.getText()+"'";
		try{
			ps=DataSource.con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next())
			{
				Username=rs.getString(1);
				jframe1.dispose();
				SuccessfullyLoginMesssage sfm=new SuccessfullyLoginMesssage(Username);
				sfm.WelcomeMessage();
			}	
			else JOptionPane.showMessageDialog(null,"Incorrect Email Address or Password");
		}
		catch (SQLException sqe)
		{
		
		}
	}
	

	
	
	private void jpasswordFocusGained(FocusEvent evt) {
		
			jpassword.setText(null);
	}
	
	private void jusernameFocusGained(java.awt.event.FocusEvent evt)
	{
		if(jusername.getText().equals("Email Address"))
		jusername.setText(null);
		
		
	}
	private void jusernameFocusLost(java.awt.event.FocusEvent evt)
	{
		if(jusername.getText().isEmpty())
			jusername.setText("Email Address");
	}
	
	private void jl2MouseClicked(java.awt.event.MouseEvent evt)
	{
		
	System.exit(0);	
	}
	
	
	private void jl3MouseClicked(java.awt.event.MouseEvent evt)
	{
		System.out.println("S");
		jframe1.setExtendedState(JFrame.ICONIFIED);
	}
	
	
	private void jl4MousePressed(java.awt.event.MouseEvent evt)
	{
		xmouse=evt.getX();
		ymouse=evt.getY();

		System.out.println("A");
	}
	
	private void jl4MouseDragged(java.awt.event.MouseEvent evt)
	{
		x=evt.getXOnScreen();
		y=evt.getYOnScreen();
		jframe1.setLocation(x-xmouse,y-ymouse);
		
	}
	

	



}
