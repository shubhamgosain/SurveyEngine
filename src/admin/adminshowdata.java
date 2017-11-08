package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBConn.DataSource;

public class adminshowdata {

	PreparedStatement ps;
	ResultSet rs;
	

	
	
	public void AddTableData(JTable table, String query,String Source) throws ClassNotFoundException, SQLException {
		//createconnection();
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
				    if(Source.equals("Completed"))
				    {	
					    model.addRow(new Object[]{a,b,c,d, e, f,g});
				    }
				    else{
				    	String h= rs.getString("WORKING_DAYS");
					    model.addRow(new Object[]{a,b,c,d, e, f,g,h});
				    }
				    }
			table.setModel(model);
		}
		catch (SQLException sqe)
		{
		
		}
	}

}
