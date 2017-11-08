package createsurvey;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Textfield_Panel extends JPanel {

	JTextField question;
	JTextArea textAreaInfo;
	
	public Textfield_Panel() {
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
	
		 
		 JLabel hint=new JLabel("<html>Provide the information about the answer you need<br><br>No Of lines in answer field you need (Maximum 10) and Size of the font <br>seprated with ( ; ) in between</html>");
		 hint.setBounds(50,100, 1160, 150);
		 hint.setFont(new Font("Simsun",Font.ITALIC,22));
		  add(hint);
		 add(provideTextAreaInfo());
		 setVisible(true);
	}

	
	
	
	
	public JTextField addquestion(){
		question=new JTextField();
		question.setText("Enter your question here");
		question.setBounds(50,50,1160,50);
		question.setFont(new Font("Simsun",Font.BOLD,26));
			return question;
		
	}

	
	public JTextArea provideTextAreaInfo(){
		
		textAreaInfo=new JTextArea();
		textAreaInfo.setText("5;18");
		textAreaInfo.setBounds(50,280,1160,250);
		textAreaInfo.setFont(new Font("Simsun",Font.BOLD,26));
		return textAreaInfo;
		
	}



}
