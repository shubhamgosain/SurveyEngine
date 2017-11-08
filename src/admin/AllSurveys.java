package admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConn.DataSource;
import Login.SuccessfullyLoginMesssage;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllSurveys extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;

	public AllSurveys() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(screenwidth-680,screenHeight-384, 1360,768);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel title =new JLabel("ALL SURVEYS");
		title.setFont(new Font("Simsun",Font.BOLD,35));
		title.setBounds(555,10,250,45);
		contentPane.add(title);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(6,70,1348, 562);
		contentPane.add(scrollPane);
	
		         
		        //actual data for the table in a 2d array
		        //create table with data
		        table = new JTable();		
		        table.setModel(new javax.swing.table.DefaultTableModel(
		                new Object [][] {

		                },
		                new String [] {
		                		"Survey Name", "Owner's email", "Target Audience", "Create Date","Start Date","End Date","Survey Status","Working Days"
		                }
		            ){
		            boolean[] canEdit = new boolean [] {
		                    false, false, false, false, false, false, false, false
		                };

		                public boolean isCellEditable(int rowIndex, int columnIndex) {
		                    return canEdit [columnIndex];
		                }
		            });

				String query="Select * from survey";
		        try {
					adminshowdata a =new adminshowdata();
					a.AddTableData(table,query,"All Surveys");
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
				
		        table.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		  try{
		  		        	int index=table.getSelectedRow();
		  			        TableModel model=table.getModel();
		  			        String name=model.getValueAt(index,0).toString();
		  			        String email=model.getValueAt(index,1).toString();
		  			        String audience=model.getValueAt(index,2).toString();
		  			        String create=model.getValueAt(index,3).toString();
		  			        String start=model.getValueAt(index,4).toString();
		  			        String end=model.getValueAt(index,5).toString();
		  			        String status=model.getValueAt(index,6).toString();
		  			        int remain=Integer.parseInt(model.getValueAt(index, 7).toString());
		  			        
		  			        System.out.println(name+"\n"+email+"\n"+audience+"\n"+create+"\n"+start+"\n"+end+"\n"+status+"\n"+remain);
		  		        }
		  		        catch(Exception i){
		  		        	JOptionPane.showMessageDialog(null, e);
		  		        }
		        	}
		        });
		      
		scrollPane.setViewportView(table);
		
		
		
	}
	
	
	
	private void AddTableData() throws ClassNotFoundException, SQLException {
		String query="Select * from survey";
		try{
			DefaultTableModel model = (DefaultTableModel)table.getModel();//(new String[]{"SURVEY_NAME","EMAIL_ADDRESS","TARGET_AUDIENCE","CREATION_DATE","SURVEY_STARTDATE","SURVEY_ENDDATE","SURVEY_STATUS","WORKING_DAYS"}, 0);

			ps=DataSource.con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				 String a= rs.getString("SURVEY_NAME");
				    String b = rs.getString("EMAIL_ADDRESS");
				    String c = rs.getString("TARGET_AUDIENCE");
				    String d= rs.getString("CREATION_DATE");
				    String e = rs.getString("SURVEY_STARTDATE");
				    String f = rs.getString("SURVEY_ENDDATE");
				    String g= rs.getString("SURVEY_STATUS");
				    String h = rs.getString("WORKING_DAYS");
				    model.addRow(new Object[]{a,b,c,d, e, f,g,h});
			}
			table.setModel(model);
		}
		catch (SQLException sqe)
		{
		
		}
	}
	

}
