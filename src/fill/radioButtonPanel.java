package fill;
import java.awt.Color;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class radioButtonPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JRadioButton[] J=new JRadioButton[10];
	int i;
	String Response="";
	
	public String showstate()
	{
		System.out.println(i);

		for(int j=0;j<i;j++)
		{
			
				{
				if(J[j].isSelected())
				{	Response+=J[j].getText();
			 break;
				}
				}
		}
		return Response;
	}
	public radioButtonPanel(String value) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,130,1240,450);
		setVisible(true);
		setLayout(null);
		
		StringTokenizer st=new StringTokenizer(value,";");
		J=new JRadioButton[st.countTokens()];
		ButtonGroup bg=new ButtonGroup();
		i=0;
		while(st.hasMoreTokens())
		{
			
			J[i]=new JRadioButton();
			J[i].setFont(new Font("Simsun",Font.BOLD,24));
			J[i].setBounds(50,50+80*i,250,50);
			J[i].setText(st.nextToken());
			add(J[i]);
			bg.add(J[i]);
			i++;
		}
	}

}
