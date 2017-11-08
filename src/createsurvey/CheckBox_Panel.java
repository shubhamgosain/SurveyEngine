package createsurvey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CheckBox_Panel extends JPanel {

	
	JTextField question;
	JTextArea checkboxdata;
	
	public CheckBox_Panel() {
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
	
		 
		 JLabel hint=new JLabel("<html>Enter all the CheckBox Fields with a Delimiter( ; ) in between <br>(Maximum of 5 options)</html>");
		 hint.setBounds(50,100, 1160, 60);
		 hint.setFont(new Font("Simsun",Font.ITALIC,22));
		  add(hint);
		 add(providecheckboxdata());
		 setVisible(true);
	}

	
	
	
	
	public JTextField addquestion(){
		question=new JTextField();
		question.setText("Enter your question here");
		question.setBounds(50,50,1160,50);
		question.setFont(new Font("Simsun",Font.BOLD,26));
		return question;
		
	}

	
	public JTextArea providecheckboxdata(){
		
		checkboxdata=new JTextArea();
		checkboxdata.setText("item1;item2;item3;item4");
		checkboxdata.setBounds(50,250,1160,250);
		checkboxdata.setFont(new Font("Simsun",Font.BOLD,26));
		return checkboxdata;
		
	}

	
	
}
