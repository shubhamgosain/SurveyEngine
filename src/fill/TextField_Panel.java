package fill;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class TextField_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	
JTextArea txtEnterAnswerHeredo ;

	public String showstate()
	{
		
		return txtEnterAnswerHeredo.getText();
	}
	
	int fontsize;
	int textfieldsize;
	public TextField_Panel(String value){
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,130,1240,450);
		setVisible(true);
		setLayout(null);
		StringTokenizer st=new StringTokenizer(value,";");
		int i=0;
		textfieldsize=Integer.parseInt(st.nextToken());
		fontsize=Integer.parseInt(st.nextToken());
		txtEnterAnswerHeredo = new JTextArea();
		txtEnterAnswerHeredo.setText("Enter answer here....do remove this text");
		txtEnterAnswerHeredo.setBounds(100,100,1000 , textfieldsize*(fontsize+6));
		txtEnterAnswerHeredo.setFont(new Font("Simsun",Font.PLAIN,26));
		txtEnterAnswerHeredo.setLineWrap(true);
		add(txtEnterAnswerHeredo);
		
	}

}
