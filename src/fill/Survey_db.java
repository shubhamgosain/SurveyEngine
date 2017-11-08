package fill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import Login.MySurveys;
import createsurvey.New_Questions;
public class Survey_db 
{
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;

	
	
	public void getDBConnection() throws SQLException, ClassNotFoundException
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="System";
		String pwd="root";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,user,pwd);
		System.out.println("Connection established!!");
	}
	
	
	public void createResponseTable(String tablename) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String columnnames="User_Email_add varchar2(250) PRIMARY KEY,";
		int i=1;
		pstmt=con.prepareStatement("select * from "+tablename);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			if(rs.getString(1).equals("t"))
				columnnames+="Q"+i+" varchar2(300) ,";
			else
			{
				columnnames+="Q"+i+" varchar2(50) ,";
			}
			i++;
		
		}
		columnnames=columnnames.substring(0, columnnames.length() - 1);
		pstmt=con.prepareStatement("create table "+tablename+"answer ("+columnnames+")");
		pstmt.execute();
		
		closeAll();

	}
	
	
	public String[] getFillSurveys(String email,String profession) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String[] name=new String[5];
		int i=0;

		pstmt=con.prepareStatement("select SURVEY_NAME ,SURVEY_ENDDATE,REWARD_AMOUNT,TARGET_AUDIENCE from Survey where SURVEY_STATUS='1'");
		rs=pstmt.executeQuery();

		i=1;
		while(rs.next())
		{
			MySurveys m=new MySurveys();
			System.out.println("Profession is "+rs.getString(4));
			StringTokenizer st=new StringTokenizer(m.targetAudience(rs.getString(4)),",");
			while(st.hasMoreTokens())
			{ 
			
				if(st.nextToken().equals(profession))
				{
					name[i]=rs.getString(1)+"*"+rs.getString(2)+"*"+rs.getString(3);
					System.out.println(name[i]);
					i++;
					break;
				}
			}
		}
		
		
		closeAll();
		name[0]=Integer.toString(i-1);
		System.out.println("ssssssssss");
		return name;
		
	}
	
	
	
	
	public boolean isSurveyFilledName(String email,String Surveyname) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		System.out.println(email);
		System.out.println(Surveyname);
		String query="Select USER_EMAIL_ADD from "+Surveyname+"answer where USER_EMAIL_ADD='"+email+"'";
		pstmt=con.prepareStatement(query);
		System.out.println(query);
		rs=pstmt.executeQuery();
		
		if(rs.next())
			{
			closeAll();
			return false;
			}
		else {
			closeAll();
			System.out.println("Pehle se present here");
			return true;
		}
	}

	
	
	
	public String getUserName(String email) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String name="";
		pstmt=con.prepareStatement("Select name from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		name=rs.getString(1);
		}
		closeAll();
		return name;
		
	}
	
	
	
	public String getSurveyName(String email) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String name="";
		pstmt=con.prepareStatement("Select survey_name from survey where email_address='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		name+=rs.getString(1)+";";
		}
		closeAll();
		return name;
		
	}
	
	
	public String getRowsNumber(String Tablename) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String name="";
		pstmt=con.prepareStatement("Select count(*) from "+Tablename);
		rs=pstmt.executeQuery();
		rs.next();
		String count=rs.getString(1);
		closeAll();
		rs.close();
		return count;
		
	}

	
	public void DropTable(String Tablename) throws SQLException, ClassNotFoundException
	{
		getDBConnection();

		pstmt=con.prepareStatement("Drop table "+Tablename);
		pstmt.execute();
		closeAll();
		
	}
	

	
	public ResultSet getCompleteSurvey(String Surveyname) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String qa="";
		pstmt=con.prepareStatement("Select * from Survey where SURVEY_NAME='"+Surveyname+"'");
		rs=pstmt.executeQuery();
	//	System.out.println(rs.getString(4));
		//closeAll();
		return rs;
		
	}

	
	public String getEmailidFromSurveyname(String Surveyname) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String qa="";
		pstmt=con.prepareStatement("Select EMAIL_ADDRESS from survey where SURVEY_NAME="+Surveyname);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		qa=rs.getString(1);
		}

		closeAll();
		return qa;
	}
	
	
	public String getSurvey(String Surveyname) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String qa="";
		pstmt=con.prepareStatement("Select * from "+Surveyname);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		qa=rs.getString(3)+"*"+rs.getString(4)+"*"+rs.getString(5)+"*"+rs.getString(6);
		}

		closeAll();
		return qa;
		
	}
	
	public void UpdateState(String surveyname,int state) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String query="update survey set SURVEY_STATUS='"+state+"' where SURVEY_NAME='"+surveyname+"'";
		pstmt=con.prepareStatement(query);
		pstmt.executeUpdate();
		if(state==1)
			UpdateDates(surveyname); 
		closeAll();
		
	}
	
	
	public void UpdateDates(String surveyname) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		pstmt=con.prepareStatement("Select WORKING_DAYS from survey where SURVEY_NAME='"+surveyname+"'");
		rs=pstmt.executeQuery();
		rs.next();
		int days=Integer.parseInt(rs.getString(1));

		java.util.Date date = new java.util.Date();
	   
		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days); 
	    java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
		
		New_Questions n=new New_Questions();
		String query="update survey set SURVEY_STARTDATE=?,SURVEY_ENDDATE=? where SURVEY_NAME='"+surveyname+"'";
		pstmt=con.prepareStatement(query);
		pstmt.setDate(1,n.getdate());
		pstmt.setDate(2,sqlDate);
		pstmt.executeUpdate();
		closeAll();
		
		
		

	}
	
	
	
	public void UpdatePassword(String email,String newpass) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String query="update information set \"Password\"='"+newpass+"' where email='"+email+"'";
		pstmt=con.prepareStatement(query);
		pstmt.executeUpdate();
		pstmt=con.prepareStatement("update Login set \"PASSWORD\"='"+newpass+"' where Username='"+email+"'");
		pstmt.executeUpdate();
		closeAll();
		
	}
		
	public void closeAll() throws SQLException
	{
		con.close();
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Survey_db d=new Survey_db();
		//d.getDBConnection();
		//d.insertData("Nancy Chess", "Female", "What is your mother's maiden name?", "What is the name of your first childhood friend", "Sarita", "Harshita","Engineer", "Delhi", 20, "chessrockz13@gmail.com", "asdfgh1234");
		d.UpdateDates("Cars17");
}
}