package Login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.SurveyDAOImplements;
import DBConn.DataSource;
import admin.adminshowdata;
import fill.FillSurvey;
import fill.Survey_db;


public class GetSurveyResult extends JFrame {

int count;
	JTable table;
	
	
	ResultSet rs;
	PreparedStatement pstmt;

	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
	
	
	public GetSurveyResult(String Surveyname) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(screenwidth-700, screenHeight-400,1400, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(6, 6, 1400, 820);
		contentPane.add(scrollPane);
	
		
		
		SurveyDAOImplements sdb=new SurveyDAOImplements();
		
		try {
			count=Integer.parseInt(sdb.getRowsNumber(Surveyname));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String[] columns = new String[count+1];
	columns[0]="Email Address ";
		for(int i=1;i<=count;i++)
		{
			columns[i]="Question "+(i);
		}
	
		
		
		System.out.println(count);
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
	        

			String query="Select * from "+Surveyname+"answer";
	        try {
	        	DefaultTableModel model = (DefaultTableModel)table.getModel();
	    		pstmt=DataSource.con.prepareStatement(query);
	    		rs=pstmt.executeQuery();
	    		Object[] o=new Object[count+1];
	    		while(rs.next())
	    		{
	    			String data;
	    			for (int i=0;i<=count;i++)
	    			{
	    				o[i]=rs.getString(i+1);
	    				System.out.println(o[i]);
	    				
	    			}
	    			model.addRow(o);
	    		}
	    		table.setModel(model);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        table.setRowHeight(24);
	        table.setAlignmentX(JTable.CENTER_ALIGNMENT);
	        table.setFont(new Font("Simsun", Font.BOLD,22 ));
	        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
	        scrollPane.setViewportView(table);
			

	
	
	
	}
	
	
	
	
	
void showdata	()
{
	
}
	
	

}
