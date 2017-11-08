package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import Beans.UserBeans;
import DAO.UserDAOImplements;
import Login.UserLogin;
import createsurvey.New_Questions;
import oracle.jdbc.util.Login;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import oracle.jdbc.util.Login;
public class NewRegister {

	private JFrame frame;
	private JTextField txtemail;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JComboBox sq1;
	private JTextField a1;
	private JComboBox sq2;
	private JTextField a2;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	public NewRegister(){
	
		initialize();
	}
	


	 
	private void initialize() {
		frame = new JFrame();
		Font f=new Font("Simsun", Font.PLAIN, 28);
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1438, 879);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtemail = new JTextField("Enter Email Address");
		txtemail.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtemail.setText("");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
                if(txtemail.getText().equals("")||txtemail.getText().equals("Email"))
               txtemail.setText("Enter Email Address"); 	
        	}
		});


		txtemail.setHorizontalAlignment(SwingConstants.CENTER);
		txtemail.setForeground(Color.WHITE);
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtemail.setText("Email ID");
		txtemail.setToolTipText("Enter Email Address");
		txtemail.setBackground(new Color(0, 0, 0));
		txtemail.setCaretColor(Color.white);
		txtemail.setBounds(79, 84, 1201, 45);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtFirstName = new JTextField();
		

		txtFirstName.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
              txtFirstName.setText("");
        	}
			public void focusLost(java.awt.event.FocusEvent evt) {
                if(txtFirstName.getText().equals(""))
                	txtFirstName.setText("!!First name is mandatory");
        	}
		});
		
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtFirstName.setText("FIRST NAME");
		txtFirstName.setForeground(Color.WHITE);
		txtFirstName.setBackground(new Color(0, 0, 0));
		txtFirstName.setCaretColor(Color.white);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(79, 197, 636, 45);
		frame.getContentPane().add(txtFirstName);
		
		
		txtLastName = new JTextField();

		txtLastName.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
				  txtLastName.setText("");
        	}
			public void focusLost(java.awt.event.FocusEvent evt) {
				  if(txtLastName.getText().equals(""))
	                	txtLastName.setText("!!last name is mandatory");
			}
		});
		
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtLastName.setText("LAST NAME");
		txtLastName.setForeground(Color.WHITE);
		txtLastName.setBackground(new Color(0, 0, 0));
		txtLastName.setCaretColor(Color.white);
		txtLastName.setColumns(10);
		txtLastName.setBounds(725, 197, 555, 45);
		frame.getContentPane().add(txtLastName);
		

		
		JLabel label = new JLabel("GENDER");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		label.setBackground(new Color(0, 0, 0));
		label.setBounds(769, 252, 139, 46);
		frame.getContentPane().add(label);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setForeground(Color.WHITE);
		Male.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Male.setBackground(new Color(0, 0, 0));
		Male.setBounds(967, 252, 122, 45);
		frame.getContentPane().add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.setForeground(Color.WHITE);
		Female.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Female.setBackground(new Color(0, 0, 0));
		Female.setBounds(1110, 252, 145, 45);
		frame.getContentPane().add(Female);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(Male);bg.add(Female);
		
		
		JComboBox profession = new JComboBox();
		profession.setModel(new DefaultComboBoxModel(new String[] {"Profession", "Doctor ", "Engineer", "C. A.", "Student", "Business", "Teacher", "Lawyer", "Homemaker"}));
		profession.setFont(new Font("Times New Roman", Font.BOLD, 28));
		profession.setBackground(Color.WHITE);
		profession.setBounds(725, 325, 555, 45);
		frame.getContentPane().add(profession);
		
		JComboBox state = new JComboBox();
		state.setBackground(Color.WHITE);
		state.setModel(new DefaultComboBoxModel(new String[] {"State", "Andhra Pradesh ", "Arunachal Pradesh ", "Assam", "Bihar", "Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh ", "Jammu & Kashmir", "Jharkhand", "Karnataka ", "Kerala", "Madhya Pradesh ", "Maharashtra ", "Manipur ", "Meghalaya ", "Mizoram ", "Nagaland ", "Orissa ", "Punjab ", "Rajasthan ", "Sikkim", "Tamil Nadu ", "Telangana", "Tripura", "Uttar Pradesh ", "Uttarakhand ", "West Bengal"}));
		state.setFont(new Font("Times New Roman", Font.BOLD, 28));
		state.setBounds(79, 325, 635, 45);
		frame.getContentPane().add(state);
		
		

		
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtAge.setText("AGE");
		txtAge.setCaretColor(Color.white);
		txtAge.setForeground(Color.WHITE);
		txtAge.setBackground(new Color(0, 0, 0));
		txtAge.setColumns(10);
		txtAge.setBounds(79, 253, 636, 45);
		frame.getContentPane().add(txtAge);

		txtAge.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
				  txtAge.setText("");
        	}
			public void focusLost(java.awt.event.FocusEvent evt) {
				  if(txtAge.getText().equals(""))
	                	txtAge.setText("Enter Age please");
			}
		});
		
		
		
		
		sq1 = new JComboBox();
		sq1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		sq1.setModel(new DefaultComboBoxModel(new String[] {"Security Question 1","What is your mother's maiden name?", "What is the name of your pet?", "Which is your favourite food?", "What is the name of your first childhood friend?"}));
		sq1.setBackground(Color.WHITE);
		sq1.setBounds(79, 393, 1201, 45);
		frame.getContentPane().add(sq1);
		
		a1 = new JTextField();
		a1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		a1.setForeground(Color.WHITE);
		a1.setBackground(new Color(0, 0, 0));
		a1.setCaretColor(Color.white);
		a1.setColumns(10);
		a1.setBounds(79, 457, 1201, 45);
		frame.getContentPane().add(a1);
		
		sq2 = new JComboBox();
		sq2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		sq2.setModel(new DefaultComboBoxModel(new String[] {"Security Question 2","What is your mother's maiden name?", "What is the name of your pet?", "Which is your favourite food?", "What is the name of your first childhood friend?"}));
		sq2.setBackground(Color.WHITE);
		sq2.setBounds(79, 522, 1201, 45);
		frame.getContentPane().add(sq2);
		
		a2 = new JTextField();
		a2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		a2.setBackground(new Color(0, 0, 0));
		a2.setCaretColor(Color.white);
		a2.setForeground(Color.WHITE);
		a2.setColumns(10);
		a2.setBounds(79, 595, 1201, 45);
		frame.getContentPane().add(a2);
		
		lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(396, 11, 561, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(386, 46, 46, 14);
		frame.getContentPane().add(label_1);
		
		JButton RegisterButton = new JButton("Submit");
		RegisterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				UserBeans ub=new UserBeans();
				ub.setName(txtFirstName.getText()+" "+txtLastName.getText());
				ub.setSq1(sq1.getSelectedItem().toString());
				ub.setSq2(sq2.getSelectedItem().toString());
				ub.setPassword(passwordField.getText().toString());
				ub.setEmail(txtemail.getText());
				ub.setAge(txtAge.getText());
				ub.setProfession(profession.getSelectedItem().toString());
				ub.setState(state.getSelectedItem().toString());
				ub.setAmount("100");
				ub.setA1(a1.getText());
				ub.setA2(a2.getText());
				if (Female.isSelected())
				{
					ub.setGender("Female");
				}
				else
					{
					ub.setGender("Male");
					}
				
				UserDAOImplements udao=new UserDAOImplements();
						try {
							if(udao.insertData(ub))
								{System.out.println("Data inserted");
						      JOptionPane.showMessageDialog(null,"Successfully Registered");
								}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						frame.dispose();
						UserLogin u=new UserLogin();
					
						
						
						
						
						
			}
		});
		RegisterButton.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		RegisterButton.setBounds(638, 665, 150, 45);
		frame.getContentPane().add(RegisterButton);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password");

		passwordField.setText("Password");
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setCaretColor(Color.white);	
		passwordField.setBackground(new Color(0, 0, 0));
		passwordField.setBounds(79, 140, 1201, 45);
		passwordField.addFocusListener(new java.awt.event.FocusAdapter(){
			public void focusGained(java.awt.event.FocusEvent evt) {
				passwordField.setText("");
			}});

		frame.getContentPane().add(passwordField);
	}
}
