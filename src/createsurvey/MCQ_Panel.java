package createsurvey;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MCQ_Panel extends JPanel {

	JTextField question;
	JTextArea MCQdata;
	
	public MCQ_Panel(){
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,50,1240,500);
		setLayout(null);
		add(addquestion());
		
		 question.addMouseListener(new java.awt.event.MouseAdapter(){
		    	public void mousePressed(java.awt.event.MouseEvent evt){
		    		if(question.getText().equals("Enter your question here"))
		    			question.setText("");
		    	}

	});
	
		 
		 JLabel hint=new JLabel("<html>Enter all the Choices Fields with a Delimiter ( ; ) in between (Maximum of 5 choices )</html>");
		 hint.setBounds(50,100, 1160, 60);
		 hint.setFont(new Font("Simsun",Font.ITALIC,22));
		 add(hint);
		 add(provideMCQdata());
	

		 setVisible(true);

	
	
	}

	
	
	
	
	public JTextField addquestion(){
		question=new JTextField();
		question.setBounds(50,50,1160,50);
		question.setFont(new Font("Simsun",Font.BOLD,26));
		question.setText("Enter your question here");
		
		return question;
		
	}



	public JTextArea provideMCQdata(){
		MCQdata=new JTextArea();
		MCQdata.setText("choice1;choice2;choice3;choice4");
		MCQdata.setBounds(50,200,1160,250);
		MCQdata.setFont(new Font("Simsun",Font.BOLD,26));
		return MCQdata;
		
	}
}