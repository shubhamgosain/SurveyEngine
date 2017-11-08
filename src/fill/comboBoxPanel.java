package fill;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import DAO.SurveyDAOImplements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class comboBoxPanel extends JPanel {

	/**
	 * Create the panel.
	 */
String Response="";
JComboBox j;
	public String showstate()
	{
		
		Response=j.getSelectedItem().toString();
		return Response;
	}
	public comboBoxPanel(String value) {
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBounds(45,130,1240,450);
		setVisible(true);
		setLayout(null);
		setLayout(null);
		
		StringTokenizer st=new StringTokenizer(value,";");
		
		j=new JComboBox();
		j.setFont(new Font("Simsun",Font.BOLD,26));
		j.setBounds(150, 50, 400, 50);
		j.setOpaque(false);
		if(st.countTokens()==1)
		{
			String check=st.nextToken();
			if(check.equals("a"))
				for(int i=1;i<=100;i++)
					j.addItem(i);
			else if(check.equals("s"))
			{
				SurveyDAOImplements sdao=new SurveyDAOImplements();
				ArrayList arr;
				try {
					arr=sdao.getStates();
					Iterator i=arr.iterator();
					while(i.hasNext())
					{
						j.addItem(i.next());
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else j.addItem(check);
		}
		else
			{
			while(st.hasMoreTokens())
				{
					j.addItem(st.nextToken());
				}
			}		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Enter the answer---"}));
		add(j);

	}

}
