package Login;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import admin.requestpassinterface;
import fill.FillSurvey;
import fill.Survey_db;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class SurveyFilling extends JPanel{

	private JLabel lblNewLabel;
	private JTable table;
	public SurveyFilling(String email) {
		
		setBounds(0,100,1036,568);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setOpaque(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(10,10,1046,548);
		scrollPane.setOpaque(false);
		add(scrollPane);
		
		String[] columns = new String[] {
		            "Survey Name","Last Date To Fill","Reward Amount"
		        };
		         
		  table = new JTable();		       
	      
		 table.setModel(new javax.swing.table.DefaultTableModel(
	                new Object [][] {

	                },
	                columns
	            ){
	            boolean[] canEdit = new boolean [] {
	                    false, false, false, false, false, false, false, false
	                };
	            
	           
	            
	                public boolean isCellEditable(int rowIndex, int columnIndex) {
	                    return canEdit [columnIndex];
	                }
	            });
		 		
			 	UserDAOImplements udao=new UserDAOImplements();
			 	String Profession="";
				try {
					Profession = udao.getProfession(email);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
			 	SurveyDAOImplements sdao=new SurveyDAOImplements();
			 	String[] tablerowsdb={};
				try {
					tablerowsdb = sdao.getFillSurveys(email, Profession);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 	

	    		table.setBackground(new Color(255,235,204));
		        table.setRowHeight(26);
		        table.setAlignmentX(JTable.CENTER_ALIGNMENT);
		        table.setFont(new Font("Tahoma", Font.PLAIN,18 ));
		        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				
				
				
			 	DefaultTableModel model = (DefaultTableModel)table.getModel();
	    		Object[] o=new Object[3];
	    		int i=Integer.parseInt(tablerowsdb[0]);
	    		System.out.println("i value is "+i);
	    		for (int j=1;j<=i;j++)
	    		{
	    		StringTokenizer st=new StringTokenizer(tablerowsdb[j],"*");
	    		o[0]=st.nextToken();
	    		try {
					if(sdao.isSurveyFilledName(email,o[0].toString()))
					{System.out.println("table="+o[0]);
					o[1]=st.nextToken();
					System.out.println("table="+o[1]);
					o[2]=st.nextToken();
					System.out.println("table="+o[2]);
					model.addRow(o);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
	    		table.setModel(model);
	    		System.out.println("problem no");
				
		//create table with data
	            table.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		  try{
		  		        	int index=table.getSelectedRow();
		  			        TableModel model=table.getModel();
		  			        String name=model.getValueAt(index,0).toString();
		  			       Double reward=Double.parseDouble(model.getValueAt(index,2).toString());
		  			     System.out.println(reward);
		  			       EventQueue.invokeLater(new Runnable() {
		  					public void run() {
		  						try {
		  							FillSurvey frame = new FillSurvey(name,email);
		  							frame.setVisible(true);
		  							
		  							} catch (Exception e) {
		  							e.printStackTrace();
		  						}
		  					}
		  				});
		  			    UserDAOImplements udao=new UserDAOImplements();
		  				try {
		  					udao.setAmount(email,udao.getAmount(email)+reward);
		  				} catch (ClassNotFoundException e1) {
		  					// TODO Auto-generated catch block
		  					e1.printStackTrace();
		  				} catch (SQLException e1) {
		  					// TODO Auto-generated catch block
		  					e1.printStackTrace();
		  				}
		  				
		        		  }
		  		        catch(Exception i){
		  		        	System.out.println(i);
		  		        }
		        	}
		        });
		      
	    		
	    		
	    		
		      
		scrollPane.setViewportView(table);
		
		
		
		
	
}
}
