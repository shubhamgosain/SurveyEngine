package Login;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import Beans.SurveyBeans;
import Beans.UserBeans;
import DAO.SurveyDAOImplements;
import fill.Survey_db;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MySurveys extends JPanel {

	
	JButton btnResults;
	
	public MySurveys()
	{
		
	}
	
	public MySurveys(String email,String allmysurvey) {
		setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"List of all Surveys"}));
		comboBox.setBounds(376, 21, 300, 40);
		comboBox.setFont(new Font("Simsun", Font.BOLD, 24));
		add(comboBox);
		Font f=new Font("Simsun",Font.PLAIN, 22);
		Font f1=new Font("Simsun",Font.BOLD, 23);
		
		allmysurvey=allmysurvey.substring(0,allmysurvey.length()-1);
		StringTokenizer st=new StringTokenizer(allmysurvey,";");
		while(st.hasMoreTokens())
		{
			comboBox.addItem(st.nextToken());
		}
		
		
			
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 1042, 500);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		panel.setFont(f);
		
		JLabel lblCreationDate = new JLabel("Creation Date :");
		lblCreationDate.setBounds(15, 40, 180, 25);
		panel.add(lblCreationDate);
		lblCreationDate.setFont(f);
		
		JLabel lblStartDate = new JLabel("Start Date :");
		lblStartDate.setBounds(15, 150, 150, 25);
		panel.add(lblStartDate);
		lblStartDate.setFont(f);
		
		JLabel lblEndDate = new JLabel("End Date :");
			lblEndDate.setBounds(15, 260, 150, 25);
		panel.add(lblEndDate);
		lblEndDate.setFont(f);
		
		JLabel lblTargetAudience = new JLabel("Target Audience :");
		lblTargetAudience.setBounds(450, 40, 230, 25);
		panel.add(lblTargetAudience);
		lblTargetAudience.setFont(f);
		
		JLabel lblSurveyStatus = new JLabel("Survey Status :");
		lblSurveyStatus.setBounds(450, 150, 230, 25);
		panel.add(lblSurveyStatus);
		lblSurveyStatus.setFont(f);
		
		
		JLabel lblNoOfResponses = new JLabel("No. of responses received :");
		lblNoOfResponses.setBounds(450, 260, 230, 25);
		panel.add(lblNoOfResponses);
		lblNoOfResponses.setFont(f);
		
		
		
		
		
		JLabel lblCreationDateR = new JLabel("Creation Date :");
		lblCreationDateR.setBounds(200, 40,200, 30);
		panel.add(lblCreationDateR);
		lblCreationDateR.setFont(f1);
		
		JLabel lblStartDateR = new JLabel("Response Start Date :");
		lblStartDateR.setBounds(200, 150, 200, 30);
		panel.add(lblStartDateR);
		lblStartDateR.setFont(f1);
		
		JLabel lblEndDateR = new JLabel("Response End Date :");
		lblEndDateR.setBounds(200, 260, 200, 30);
		panel.add(lblEndDateR);
		lblEndDateR.setFont(f1);
		
		
		JTextArea lblTargetAudienceR = new JTextArea();
		lblTargetAudienceR.setBounds(680, 40,350, 30);
		panel.add(lblTargetAudienceR);
		lblTargetAudienceR.setFont(f1);
		lblTargetAudienceR.setLineWrap(true);
		
		
		JLabel lblSurveyStatusR = new JLabel("Response Survey Status :");
		lblSurveyStatusR.setBounds(680, 150, 350, 30);
		panel.add(lblSurveyStatusR);
		lblSurveyStatusR.setFont(f1);
		
		JLabel lblNoOfResponsesR = new JLabel("Response No. of responses received :");
		lblNoOfResponsesR.setBounds(680, 260, 350, 30);
		panel.add(lblNoOfResponsesR);
lblNoOfResponsesR.setFont(f1);
		
		
		
		btnResults = new JButton("Results");
		btnResults.setBounds(800, 650,150, 60);
		btnResults.setFont(f1);
		add(btnResults);
		btnResults.setVisible(false);
		btnResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	EventQueue.invokeLater(new Runnable() {
    				public void run() {
    					try {
    						GetSurveyResult frame=new GetSurveyResult(comboBox.getSelectedItem().toString());
    						frame.setVisible(true);
    					} catch (Exception e) {
    						e.printStackTrace();
    					}
    				}
    			});
    		        
            }
        });
	
		
		
		 comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					panel.setVisible(true);
					
					SurveyDAOImplements sdao=new SurveyDAOImplements();
					SurveyBeans sb=new SurveyBeans();
					try {
						
						sb=sdao.getCompleteSurvey(e.getItem().toString());
					lblCreationDateR.setText(sb.getCreationDate().toString());
					lblStartDateR.setText(sb.getStartDate().toString());
					lblEndDateR.setText(sb.getEndDate().toString());
					lblSurveyStatusR.setText(returnstatus(sb.getSurveyStatus()));
						lblTargetAudienceR.setText(targetAudience(sb.getTargetAudience()));
						panel.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black),sb.getSurveyName()));
						lblNoOfResponsesR.setText(sdao.getRowsNumber(sb.getSurveyName()+"answer"));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
	}


public String returnstatus(String state)
{
	if(state.equals("1"))
	{
 btnResults.setVisible(true);
	 return "Ongoing";
	}

	else if(state.equals("0"))
	{
		 btnResults.setVisible(false);
	 return "Requested";
	}

	else if(state.equals("2"))
	{

		 btnResults.setVisible(true);
	 return "Completed";
	}

	else if(state.equals("3"))
	{
	 btnResults.setVisible(false);
		return "Discarded";
	}

	return "";
}



public String targetAudience(String ta)
{
	String audience="";

ta=ta.replaceAll(""," ");

	StringTokenizer st=new StringTokenizer(ta," ");
	while(st.hasMoreTokens())
	{switch(st.nextToken())
		{
		case "0":audience+="Doctor,";
		break;
		case "1":audience+="Engineer,";
		break;
		case "2":audience+="CA,";
		break;
		case "3":audience+="Student,";
		break;
		case "4":audience+="Bussiness,";
		break;
		case "5":audience+="Teacher,";
		break;
		case "6":audience+="Lawyer,";
		break;
		case "7":audience+="Homemaker,";
		break; 
	}
	}
	audience=audience.substring(0, audience.length()-1);
return audience;
}


}
