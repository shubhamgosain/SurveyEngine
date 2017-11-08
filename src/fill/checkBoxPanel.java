package fill;
import java.awt.Color;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class checkBoxPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	StringTokenizer st;
	JCheckBox[] J=new JCheckBox[10];
	int i;
	String Response="";
	
	public String showstate()
	{
System.out.println("i checkbox value is"+i);
		for(int j=0;j<i;j++)
		{
			
				{
				if(J[j].isSelected())
							Response+=J[j].getText()+",";
			}
		}
		Response=Response.substring(0, Response.length()-1);
		System.out.println("Response from checkbox is="+Response); 
		return Response;
	}
	
	public checkBoxPanel(String value) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,130,1240,450);
		setVisible(true);
		setLayout(null);
		st=new StringTokenizer(value,";");
		//J=new JCheckBox[st.countTokens()];
		i=0;
		int j=0;

		int x=50;
		while(st.hasMoreTokens())
		{
			J[i]=new JCheckBox();
			J[i].setFont(new Font("Simsun",Font.BOLD,24));
		
			J[i].setBounds(x,50+80*j,250,50);
			J[i].setText(st.nextToken());
			add(J[i]);	
			i++;j++;
			if(j==5)
			{
				x=350;j=0;
			}
		}
		
	
		
	}
	
	
	

}
