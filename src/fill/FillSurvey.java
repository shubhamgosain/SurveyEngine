				package fill;
						import java.awt.BorderLayout;
						import java.awt.Color;
						import java.awt.EventQueue;
						import java.awt.Font;
						import java.awt.Toolkit;

						import javax.swing.JFrame;
						import javax.swing.JPanel;
						import javax.swing.border.EmptyBorder;

import DAO.SurveyDAOImplements;
import DBConn.DataSource;
						import createsurvey.CheckBox_Panel;
						import createsurvey.Panel;

						import javax.swing.JLabel;
						import javax.swing.BorderFactory;
						import javax.swing.JButton;
						import javax.swing.JTextField;
						import java.awt.event.ActionListener;
						import java.sql.Connection;
						import java.sql.DriverManager;
						import java.sql.PreparedStatement;
						import java.sql.ResultSet;
						import java.sql.SQLException;
						import java.util.StringTokenizer;
						import java.awt.event.ActionEvent;

						public class FillSurvey extends JFrame {

							private JPanel contentPane;
							JPanel previouspanel;
							String Surveyname,emailid;
							ResultSet rs;
							PreparedStatement pstmt;
							int questionno;
							String[] question;
							JLabel qLabel;
							int currentqueston=0;
							String RESPONSE="";
							TextField_Panel check1;
							checkBoxPanel check2;
							comboBoxPanel check3;
							radioButtonPanel check4;
							String previoustype;
							int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
							int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;

							

							/**
							 * Create the frame.
							 */
							public FillSurvey(String Surveyname,String emailid) {
								this.Surveyname=Surveyname;
								this.emailid=emailid;
								setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								contentPane = new JPanel();
								contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
								setContentPane(contentPane);
								contentPane.setLayout(null);
								previouspanel=new JPanel();
								setBounds(screenwidth-680,screenHeight-384,1360,768);
								setResizable(false);
								//setUndecorated(true);
								contentPane.setBackground(new Color(255, 204, 128));
								
								
								
								try {
									getSurvey(Surveyname);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JLabel l=new JLabel("Question:");
								l.setBounds(20,50,150,50);
								contentPane.add(l);
								l.setFont(new Font("Tahoma",Font.ITALIC,28));
								l.setForeground(Color.DARK_GRAY);

								qLabel = new JLabel("Enter question here..");
								qLabel.setBounds(200,50,1060,50);
								contentPane.add(qLabel);
								qLabel.setFont(new Font("Tahoma",Font.PLAIN,26));
								
								StringTokenizer st=new StringTokenizer(question[currentqueston],"~~");
								getquestionresponse(st.nextToken(),st.nextToken(),st.nextToken());
								currentqueston++;

									
								JButton btnNext = new JButton("NEXT");
								btnNext.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										RESPONSE+=checktype()+";";
										if(currentqueston<questionno)
										{
										StringTokenizer st=new StringTokenizer(question[currentqueston],"~~");
										getquestionresponse(st.nextToken(),st.nextToken(),st.nextToken());
										currentqueston++;
										}
										else 
											{
											try {

												SurveyDAOImplements sdao=new SurveyDAOImplements();
												sdao.InsertUserResponse(Surveyname,questionno,RESPONSE,emailid);
									
												
									} catch (ClassNotFoundException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											ThankYou();
											}
									
									
									}
								});
								btnNext.setBounds(45,620 , 150, 50);
								btnNext.setFont(new Font("Simsun",Font.BOLD,26));
								
								contentPane.add(btnNext);
							}

							public void getSurvey(String Surveyname) throws SQLException, ClassNotFoundException
							{
								this.Surveyname=Surveyname;
								
								pstmt=DataSource.con.prepareStatement("Select count(*) from "+Surveyname);
								rs=pstmt.executeQuery();
								if(rs.next())
								{
									questionno=rs.getInt(1);
								}
								question = new String[questionno];
								
								pstmt=DataSource.con.prepareStatement("Select * from "+Surveyname);
								rs=pstmt.executeQuery();
								int i=0;
								while(rs.next())
								{

								question[i]=rs.getString(1)+"~~"+rs.getString(2)+"~~"+rs.getString(3);
								i++;
								}
								
							}
							
							
							
														
							
							
						public void getquestionresponse(String q,String type,String value)
						{
							previoustype=type;
							System.out.println("Wallah "+type);
							
							switch(type)
						{
						case "t":{
							check1=new TextField_Panel(value);

							previouspanel.setVisible(false);
							previouspanel=check1;
							contentPane.add(check1);
							check1.setVisible(true);
							qLabel.setText(q);
							break;
						}

						case "c":{
							check2=new checkBoxPanel(value);
							previouspanel.setVisible(false);
							previouspanel=check2;
							contentPane.add(check2);
							check2.setVisible(true);
							qLabel.setText(q);
							
							break;
						}

						case "d":{
							check3=new comboBoxPanel(value);

							previouspanel.setVisible(false);
							previouspanel=check3;
							contentPane.add(check3);
							check3.setVisible(true);
							qLabel.setText(q);
							break;
						}

						case "m":{
							check4=new radioButtonPanel(value);

							previouspanel.setVisible(false);
							previouspanel=check4;
							contentPane.add(check4);
							check4.setVisible(true);
							qLabel.setText(q);
							break;
						}

						}}




						public String checktype()
						{

							System.out.println(previoustype);
							String response="";
							switch(previoustype)
						{
						case "t":{
							response=check1.showstate();
							break;
						}

						case "c":{

							response= check2.showstate();
						break;	
						}

						case "d":{
							response=check3.showstate();
							
						break;
						}

						case "m":{
							response=check4.showstate();
						break;
						}
						}
							System.out.println("********************"+response);
						return response;
						}




						void ThankYou()
						{
							JPanel p=new JPanel();
							
							p.setLayout(null);
							p.setBounds(100, 100, 670, 450);
							p.setVisible(true);
							p.setBackground(new Color(255,235,204));
						    
							JLabel complete=new JLabel();
							complete.setBounds(50,15,568,40);
							complete.setText("Your Response is submitted.....");
							complete.setFont(new Font("Simsun",Font.BOLD,26));
							contentPane.setVisible(false);
							p.add(complete);
							setContentPane(p);
							JButton jb=new JButton("Continue");
							jb.setBounds(50,160,100,50);
							p.add(jb);
							jb.addMouseListener(new java.awt.event.MouseAdapter(){
						    	public void mouseClicked(java.awt.event.MouseEvent evt){
						    		dispose();
							
						    	}});
						}


						}

						