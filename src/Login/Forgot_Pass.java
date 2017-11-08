package Login;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Beans.UserBeans;
import DAO.UserDAOImplements;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Forgot_Pass extends JFrame {

	private JPanel contentPane,panel1,panel2;
	private JTextField email_text;
	private JTextField security_answer_1;
	private JTextField security_answer_2;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JLabel security_ques_1,security_ques_2;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	
	String emailaddress;
	JLabel submit ;
	String 	a1,a2;
	PreparedStatement ps;
	ResultSet rs;
	Font f=new Font("Simsun",Font.PLAIN,20);
	
	

	public Forgot_Pass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenwidth-400,screenHeight-320, 800,640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		
		JLabel email = new JLabel("E-mail Address");
		email.setFont(f);
		email.setForeground(Color.WHITE);
		email.setBounds(27, 30, 173, 29);
		contentPane.add(email);
		
		email_text = new JTextField();
		email_text.setBounds(200, 27, 400, 40);
		contentPane.add(email_text);
		email_text.setColumns(10);
		email_text.setFont(new Font("Tahoma",Font.PLAIN, 28));
		
		submit = new JLabel("SUBMIT");
		submit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		submit.setForeground(Color.WHITE);
		submit.setHorizontalAlignment(JButton.CENTER);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		submit.setBounds(310, 75,180 , 32);
		contentPane.add(submit);
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               try {
				checkAccount(email_text.getText());
               } 
               catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        });
		
		
		panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
			panel1.setBounds(15, 130, 745,450 );
		contentPane.add(panel1);
		panel1.setLayout(null);
	panel1.setVisible(false);
		
		JLabel security1 = new JLabel("Security Question 1 :");
		security1.setForeground(Color.WHITE);
		security1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security1.setBounds(6, 25, 220, 26);
		panel1.add(security1);
		
		security_ques_1 = new JLabel("New label");
		security_ques_1.setForeground(Color.WHITE);
		security_ques_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security_ques_1.setBounds(230, 25,500, 26);
		panel1.add(security_ques_1);
		
		JLabel answer1 = new JLabel("Security Answer 1    :");
		answer1.setForeground(Color.WHITE);
		answer1.setBounds(6,100 , 220, 26);
		answer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel1.add(answer1);
		
		security_answer_1 = new JTextField();
		security_answer_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security_answer_1.setBounds(230,100,300, 26);
		panel1.add(security_answer_1);
		security_answer_1.setColumns(10);
		
		JLabel security2 = new JLabel("Security Question 2 :");
		security2.setForeground(Color.WHITE);
		security2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security2.setBounds(6,175, 220, 21);
		panel1.add(security2);
		
		security_ques_2 = new JLabel("New label");
		security_ques_2.setForeground(Color.WHITE);
		security_ques_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security_ques_2.setBounds(230,175,500, 19);
		panel1.add(security_ques_2);
		
		JLabel answer2 = new JLabel("Security Answer 2    :");
		answer2.setForeground(Color.WHITE);
		answer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		answer2.setBounds(6, 250, 220, 21);
		panel1.add(answer2);
		
		security_answer_2 = new JTextField();
		security_answer_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		security_answer_2.setColumns(10);
		security_answer_2.setBounds(230,250,300, 26);
		panel1.add(security_answer_2);
		
		JLabel confirm = new JLabel("CONFIRM");
		confirm.setBounds(302, 350, 120, 29);
		panel1.add(confirm);
		confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if((a1.toLowerCase()).equals(security_answer_1.getText().toLowerCase())&&(a2.toLowerCase()).equals(security_answer_2.getText().toLowerCase()))
        			{panel1.setVisible(false);
        			panel2.setVisible(true);}
            	else JOptionPane.showMessageDialog(null,"Wrong Answers....Pls Enter Correct Responses");
        		
        			// changePassword(email);
        }});
		confirm.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		confirm.setForeground(Color.WHITE);
		confirm.setHorizontalAlignment(JButton.CENTER);
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panel2 = new JPanel();
		panel2.setLayout(null);
			panel2.setBounds(25, 130, 750,450);
		panel2.setBackground(Color.DARK_GRAY);
		contentPane.add(panel2);
		panel2.setVisible(false);
		
		JLabel new_pass = new JLabel("Enter new password :");
		new_pass.setForeground(Color.WHITE);
		new_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		new_pass.setBounds(6, 56, 280, 30);
		panel2.add(new_pass);
		
		pass1 = new JPasswordField();
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass1.setColumns(10);
		pass1.setBounds(300, 52, 165, 29);
		panel2.add(pass1);
		
		JLabel renew_pass = new JLabel("Re-enter new password:");
		renew_pass.setForeground(Color.WHITE);
		renew_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		renew_pass.setBounds(6, 120, 280, 30);
		panel2.add(renew_pass);
		
		pass2 = new JPasswordField();
		pass2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass2.setColumns(10);
		pass2.setBounds(300, 120, 165, 30);
		panel2.add(pass2);
		
		JLabel done = new JLabel("DONE");
		done.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		done.setForeground(Color.WHITE);
		done.setHorizontalAlignment(JButton.CENTER);
		done.setFont(new Font("Tahoma", Font.PLAIN, 20));
		done.setBounds(302, 180, 120, 30);
		panel2.add(done);
		done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	
            if((pass1.getText().length()>2)&&(pass1.getText().equals(pass2.getText())))
            		{
            	try {
					changePassword(pass1.getText());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            		}
            else JOptionPane.showMessageDialog(null,"Password Didn't Matched");
    		
        			// changePassword(email);
        }});
		
	}
	
	void checkAccount(String email) throws ClassNotFoundException, SQLException
	{
			UserDAOImplements udao=new UserDAOImplements();
	UserBeans ub=new UserBeans();
	
		ub=udao.getTable(email);
		emailaddress=email;
		if(ub.getEmail().equals(""))
			JOptionPane.showMessageDialog(null,"No such Email Adress Found");
		else
			{
				security_ques_1.setText(ub.getSq1());
				security_ques_2.setText(ub.getSq2());
				a1=ub.getA1();
				a2=ub.getA2();
				panel1.setVisible(true);
				submit.setVisible(false);
			}
		
		
	}
	
	void changePassword(String newpass) throws ClassNotFoundException, SQLException
	{
		
	
		UserDAOImplements udao=new UserDAOImplements();
		if(udao.UpdatePassword(emailaddress,newpass))
		{	
		JOptionPane.showMessageDialog(null,"Sucessfully Updated Password");
		new UserLogin();
		dispose();
		}
		
	}
	
	
	
}
