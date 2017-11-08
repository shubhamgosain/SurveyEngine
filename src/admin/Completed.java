package admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Completed extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;

		public Completed() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(screenwidth-680,screenHeight-384, 1360,768);
		

		JLabel title =new JLabel("COMPLETED SURVEYS");
		title.setFont(new Font("Simsun",Font.BOLD,35));
		title.setBounds(480,10,400,45);
		contentPane.add(title);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(6,70,1348, 562);
		contentPane.add(scrollPane);
		
		        table = new JTable();		
		        table.setModel(new javax.swing.table.DefaultTableModel(
		                new Object [][] {

		                },
		                new String [] {
		                		"Survey Name", "Owner's email", "Target Audience", "Create Date","Start Date","End Date","Survey Status"
		                }
		            ){
		            boolean[] canEdit = new boolean [] {
		                    false, false, false, false, false, false, false, false
		                };

		                public boolean isCellEditable(int rowIndex, int columnIndex) {
		                    return canEdit [columnIndex];
		                }
		            });
		        table.setBackground(new Color(255,235,204));
		        table.setRowHeight(26);
		        table.setAlignmentX(JTable.CENTER_ALIGNMENT);
		        table.setFont(new Font("Tahoma", Font.PLAIN,18 ));
		        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		        String query="Select * from survey where SURVEY_STATUS='2'";
		    	
		        try {
		        	adminshowdata a =new adminshowdata();
					a.AddTableData(table,query,"Completed");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        table.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		try{
		  		        	int index=table.getSelectedRow();
		  			        TableModel model=table.getModel();
		  			        String Surveyname=model.getValueAt(index,0).toString();
		  			   		
		  			      EventQueue.invokeLater(new Runnable() {
		  					public void run() {
		  						try {
		  							AdminCompleteInterface frame=new AdminCompleteInterface(Surveyname);
		  							frame.setVisible(true);
		  							dispose();
		  						} catch (Exception e) {
		  							e.printStackTrace();
		  						}
		  					}
		  				});
		        		  
		        		  }
		  		        catch(Exception i){
		  		        	System.out.println(i);
		  		        }
	
		        	}
		        });
		      
		scrollPane.setViewportView(table);
		
		
		
	}
	
		


}
