package createsurvey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DropDown_Panel extends JPanel {
	JTextField question;
	JTextArea dropDowndata;
	public DropDown_Panel() {
	
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,50,1260,570);
		setLayout(null);
		add(addquestion());
		
		 question.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mousePressed(java.awt.event.MouseEvent evt){
		    		if(question.getText().equals("Enter your question here"))
		    			question.setText("");
		    	}

	});
	
		
		 
		 	JComboBox comboBox = new JComboBox();
			add(comboBox);
			comboBox.setBounds(50,150, 556, 40);
			

			comboBox.addItem("Select Type");
			comboBox.addItem("Age");
			comboBox.addItem("States");
			comboBox.addItem("Custom");
			comboBox.setFont(new Font("Simsun",Font.ITALIC,26));
			 
			
			
			dropDowndata=new JTextArea();
			dropDowndata=provideDropDowndata();
			dropDowndata.setText("a");
			
			
			 JLabel hint=new JLabel("<html>Enter all the Choices Fields with a Delimiter( ; ) in between </html>");
			 hint.setBounds(50,200, 1160, 60);
			 hint.setFont(new Font("Simsun",Font.ITALIC,26));
			  hint.setVisible(false);
			
			 comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getItem().equals("Custom"))
					{
						hint.setVisible(true);
					
					dropDowndata.setText("value1;value2;value3;value4");
					dropDowndata.setEditable(true);
					}
					else{
						if(e.getItem().equals("Age"))
						dropDowndata.setText("a");
						else if(e.getItem().equals("States"))
							dropDowndata.setText("s");
						dropDowndata=provideDropDowndata();
						hint.setVisible(false);
						
						}
								
				}
			});
			
			
			add(hint);
		    add(provideDropDowndata());
			 setVisible(true);
	
	}

	
	
	
	
	public JTextField addquestion(){
		question=new JTextField();
		question.setText("Enter your question here");
		question.setBounds(50,50,1160,50);
		question.setFont(new Font("Simsun",Font.BOLD,26));
		
				return question;
		
	}

	
	public JTextArea provideDropDowndata(){
		dropDowndata.setEditable(false);
		dropDowndata.setBounds(50,330,1160,200);
		dropDowndata.setFont(new Font("Simsun",Font.BOLD,26));
		return dropDowndata;
		
	}
}
