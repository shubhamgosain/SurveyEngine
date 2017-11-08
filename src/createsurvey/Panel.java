package createsurvey;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Panel extends JPanel {


	String Tablename;
	String username;
	JCheckBox checkBox_0,checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6,checkBox_7;
	String profession="";
	JComboBox comboBox ;
	Double cost;
	int dayscost=1;
	Double eachTargetAudienceCost=0.0;
	
	public Panel(int noofquestions,Double Balance) {
		eachTargetAudienceCost=Double.valueOf(noofquestions*5);
		dayscost*=noofquestions;
		cost=Double.valueOf(5+5*noofquestions)+dayscost;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		setBounds(25, 25, 1230, 670);
		setBackground(new Color(255, 242, 191));
		JLabel help = new JLabel("<html>HINT: You are left with "+(Balance-5*noofquestions-5)+"Rs and each Target Audience Choice will cost you "+(eachTargetAudienceCost)+"Rs <br>and For Number of Days...each day will cost you "+noofquestions+"Rs<html>" );
		help.setBounds(150, 50, 930, 100);
		help.setFont(new Font("Simsun",Font.PLAIN,25));
		add(help);
		
		JLabel label123 = new JLabel("COST :");
		label123.setBounds(1110,10,110, 100);
		label123.setFont(new Font("Simsun",Font.PLAIN,32));
		add(label123);
		
		JLabel costlabel = new JLabel();
		costlabel.setBounds(1220,10,150, 100);
		costlabel.setFont(new Font("Tahoma",Font.BOLD,34));
		add(costlabel);
		costlabel.setForeground(Color.BLUE);
		costlabel.setText(cost.toString());
		
		
		JLabel lblTargetAudience = new JLabel("TARGET AUDIENCE");
		lblTargetAudience.setBounds(500, 170, 300, 30);
		add(lblTargetAudience);
		lblTargetAudience.setFont(new Font("Tahoma",Font.BOLD,25));
		
		checkBox_0 = new JCheckBox("Doctor ");
		checkBox_0.setBounds(150, 250, 150, 30);
		checkBox_0.setFont(new Font("Simsun",Font.PLAIN,24));
		add(checkBox_0);
		
		 checkBox_1 = new JCheckBox("Engineer");
		checkBox_1.setBounds(430, 250, 128, 30);
		checkBox_1.setFont(new Font("Simsun",Font.PLAIN,24));
		add(checkBox_1);
		
		checkBox_2 = new JCheckBox("C. A.");
		checkBox_2.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_2.setBounds(710,250, 128, 23);
		add(checkBox_2);
		
		checkBox_3 = new JCheckBox("Student");
		checkBox_3.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_3.setBounds(1000, 250, 128, 23);
		add(checkBox_3);
		
		checkBox_4 = new JCheckBox("Business");
		checkBox_4.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_4.setBounds(150, 330, 128, 23);
		add(checkBox_4);
		
		checkBox_5 = new JCheckBox("Teacher");
		checkBox_5.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_5.setBounds(430, 330, 128, 23);
		add(checkBox_5);
		
		checkBox_6 = new JCheckBox("Lawyer");
		checkBox_6.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_6.setBounds(710, 330, 128, 23);
		add(checkBox_6);
		checkBox_7 = new JCheckBox("Homemaker");
		checkBox_7.setFont(new Font("Simsun",Font.PLAIN,24));
		checkBox_7.setBounds(1000, 330, 128, 23);
		add(checkBox_7);
		
		JLabel lblNumberOfDays = new JLabel("NUMBER OF DAYS");
		lblNumberOfDays.setBounds(550, 450,150, 30);
		add(lblNumberOfDays);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"}));
		comboBox.setBounds(550,500 ,150, 30);

		comboBox.setFont(new Font("Simsun",Font.PLAIN,24));
		add(comboBox);
		
		

		
		checkBox_0.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_1.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_2.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_3.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_4.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_5.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_6.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 checkBox_7.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					 if (e.getStateChange() == ItemEvent.SELECTED) {
					       	cost+=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
					    } else {
					    	cost-=eachTargetAudienceCost;
					       	costlabel.setText(cost.toString());
				}
				}});
		 comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					cost-=dayscost;
					dayscost=Integer.parseInt(e.getItem().toString())*noofquestions;
					cost+=dayscost;
					costlabel.setText(cost.toString());	
								
				}
			});
			


	}
	
	
	
	public String checkvalue()
	{
		profession="";
		if(checkBox_0.isSelected())
			profession+="0";
		if(checkBox_1.isSelected())
			profession+="1";
		if(checkBox_2.isSelected())
			profession+="2";
		if(checkBox_3.isSelected())
			profession+="3";
		if(checkBox_4.isSelected())
			profession+="4";
		if(checkBox_5.isSelected())
			profession+="5";
			if(checkBox_6.isSelected())
				profession+="6";
			if(checkBox_7.isSelected())
				profession+="7";
						
	return profession;
		
		
	}
	
	
}
