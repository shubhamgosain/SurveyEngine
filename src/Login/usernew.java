package Login;

import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import createsurvey.SurveyName;



public class usernew {
	
	
	JFrame jframe4;
	JSplitPane jsp,jsprightvertical;
	JPanel panel1,jpaneladdnewForm,jPanelfill,initialrightupper;
	JLabel jleftcreate1,jleftcreate2,jbackground,jclose,initialrightLAbel;
	JScrollPane jScroll;
	User1LoginDisplay initalrightlower;
	String emailid;
	JLabel amountlabel;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	
	private String name;
	private double amount;
	public usernew(String emailid,String name)
	{
		this.emailid=emailid;
		this.name=name;

	}
	public usernew(String emailid)
	{

	}
		
	
	public void implement()
	{
		jframe4=new JFrame();
		jframe4.setLayout(null);
		jframe4.setUndecorated(true);
		jframe4.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
		jframe4.setBounds(screenwidth-683,screenHeight-384,1366,768);
		jframe4.setVisible(true);
		
		jbackground=new JLabel();
		jbackground.setBounds(0,0,1366,768);
		ImageIcon ic=new ImageIcon("src/Images/Background_result.jpg");
		jbackground.setIcon(ic);
		jframe4.setContentPane(jbackground);

		jsp=new JSplitPane();
		jsp.setBounds(0,0,1366,768);
		jsp.setDividerLocation(300);
		jsp.setDividerSize(5);
		jsp.setOpaque(false);
		jframe4.add(jsp);
		
		
		initialrightLAbel=new JLabel();
		initialrightLAbel.setOpaque(false);
		jsp.setRightComponent(initialrightLAbel);
		
		
		jsprightvertical=new JSplitPane();
		jsprightvertical.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		jsprightvertical.setOpaque(false);
		jsprightvertical.setDividerLocation(200);
		jsprightvertical.setDividerSize(1);
		jsp.setRightComponent(jsprightvertical);
		
		
	initialrightupper=new JPanel();
	initialrightupper.setLayout(null);
		initialrightupper.setOpaque(false);
		JLabel rupeeicon=new JLabel();
		rupeeicon.setBounds(780,20,64, 64);
		rupeeicon.setIcon(new ImageIcon("src/Images/rupeeicon.png"));
		rupeeicon.setOpaque(false);
		initialrightupper.add(rupeeicon);
		
		getUserValues();
		
		
		amountlabel=new JLabel("Amount");
		amountlabel.setBounds(860,20,250, 64);
		amountlabel.setOpaque(false);
		amountlabel.setText(Double.toString(amount));
		amountlabel.setFont(new Font("Simsun",Font.BOLD,50));
		amountlabel.setForeground(Color.ORANGE);
		initialrightupper.add(amountlabel);
		jsprightvertical.setLeftComponent(initialrightupper);
		
		
		
		
		
	initalrightlower=new User1LoginDisplay();
	initalrightlower.setOpaque(false);
		jsprightvertical.setRightComponent(initalrightlower);
		panel1=new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(null);
		jsp.setLeftComponent(panel1);
		jsp.setDividerLocation(300);
		jsprightvertical.setDividerLocation(200);

		JLabel userdisplay=new JLabel();
		userdisplay.setForeground(Color.ORANGE);
		userdisplay.setFont(new Font("Simsun",Font.BOLD , 34));
		userdisplay.setBounds(0,90,300,50);
		userdisplay.setHorizontalAlignment(JLabel.CENTER);
		userdisplay.setText(name);
		panel1.add(userdisplay);
		
		jleftcreate1 =new JLabel();
		jleftcreate1.setForeground(Color.WHITE);
		jleftcreate1.setFont(new Font("Simsun",Font.PLAIN , 24));
		jleftcreate1.setBounds(20,270,200,30);
		jleftcreate1.setText("SURVEY");
		panel1.add(jleftcreate1);
		

		JLabel refreshicon=new JLabel();
		refreshicon.setBounds(20,470,64, 64);
		refreshicon.setIcon(new ImageIcon("src/Images/refresh.png"));
		refreshicon.setOpaque(false);
		panel1.add(refreshicon);
		
		
		
		
		jleftcreate2 =new JLabel();
		jleftcreate2.setForeground(Color.WHITE);
		jleftcreate2.setText("FILL SURVEY");
		jleftcreate2.setFont(new Font("Simsun",Font.PLAIN , 24));
		jleftcreate2.setBounds(20,370,200,50);
		panel1.add(jleftcreate2);
		
		jleftcreate1.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){

	    		MainSurveyPanel();
	    	}
	    	
		});
		refreshicon.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){
	    		getUserValues();
	    		amountlabel.setText(Double.toString(amount));
	    		
	    	    
	    	}});

		jleftcreate2.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){

	    		FillForm(); 
	    		
	    	}});

		
	
		
		jclose=new JLabel();
		jclose.setForeground(Color.LIGHT_GRAY);
		jclose.setBounds(20,670,200, 50);
		jclose.setText("LOGOUT");
		jclose.setFont(new Font("Simsun",Font.BOLD , 24));
		panel1.add(jclose);
		
		jclose.addMouseListener(new java.awt.event.MouseAdapter(){
	    public void mousePressed(java.awt.event.MouseEvent evt){
	    	jframe4.dispose();
	    	UserLogin ul=new UserLogin();
	    
	    		
	    	}});

	
		
	}
	
	
	
	public void getUserValues()
	{
		
		UserDAOImplements udao=new UserDAOImplements();
		try {
			amount=udao.getAmount(emailid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void MainSurveyPanel()
	{
		jpaneladdnewForm=new JPanel();
		jpaneladdnewForm.setLayout(null);
		jpaneladdnewForm.setOpaque(false);
		JLabel addnew=new JLabel("Add a New Survey");
		addnew.setBounds(50,50,150,50);
		addnew.setFont(new Font("Arial",Font.PLAIN,18));
		addnew.setForeground(Color.WHITE);
		jpaneladdnewForm.add(addnew);
		
		JLabel mysurvey=new JLabel("My Surveys");
		mysurvey.setBounds(50,130,150,50);
		mysurvey.setFont(new Font("Arial",Font.PLAIN,18));
		mysurvey.setForeground(Color.WHITE);
		jpaneladdnewForm.add(mysurvey);
		
		
		jsprightvertical.setRightComponent(jpaneladdnewForm);
		jsprightvertical.setDividerLocation(200);
		
		addnew.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mousePressed(java.awt.event.MouseEvent evt){

	    		if(amount<15)
	    		{
	    			JOptionPane.showMessageDialog(null,"You Dont have Enough Balance , Minimum of Rs 15 is required");
	    		
	    		}
	    		else{
	    		SurveyName n=new SurveyName(emailid);
	    		n.setVisible(true);
	    		}
	    	}});

		mysurvey.addMouseListener(new java.awt.event.MouseAdapter(){
	    	public void mouseClicked(java.awt.event.MouseEvent evt){
	    		String allmysurvey="";
	    		SurveyDAOImplements sdb=new SurveyDAOImplements();
	    		try {
	    			allmysurvey=sdb.getSurveyName(emailid);
	    		} catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		if(allmysurvey.equals(""))
	    			JOptionPane.showMessageDialog(null,"You Dont have any Created Survey now");
	    		else{
	    		MySurveys ms=new MySurveys(emailid,allmysurvey); 
	    		jsprightvertical.setRightComponent(ms);
	    		}
	    	}});
		
		
	}

	public void FillForm()
	{
		SurveyFilling ms=new SurveyFilling(emailid);
		jsprightvertical.setRightComponent(ms);
				
				jsprightvertical.setDividerLocation(200);
				jframe4.repaint();	
	}


}
			
	
	
	

