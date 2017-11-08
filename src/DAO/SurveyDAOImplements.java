package DAO;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Beans.SurveyBeans;
import Beans.UserBeans;
import DBConn.DataSource;
import Login.MySurveys;
import createsurvey.New_Questions;

public class SurveyDAOImplements 
{
	public boolean createResponseTable(String tablename) throws SQLException, ClassNotFoundException
	{
		String columnnames="User_Email_add varchar2(250),";
		int i=1;
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt=DataSource.con.prepareStatement("select * from "+tablename);
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
		pstmt=DataSource.con.prepareStatement("create table "+tablename+"answer ("+columnnames+")");
		pstmt.execute();
		return true;
	}
	
	
	
	
	
	
	
	public boolean createTable(String surveynewname ) throws SQLException, ClassNotFoundException
	{
		PreparedStatement ps;
		ResultSet rs;
		String query="create table "+surveynewname+"(Question varchar2(500),Type varchar2(50),Value varchar2(550))";
		System.out.println(query);
			
				ps=DataSource.con.prepareStatement(query);
				ps.execute();
				return true;
		
	}
	
	

	public String[] getFillSurveys(String email,String profession) throws SQLException, ClassNotFoundException
	{
		int count=Integer.parseInt(getRowsNumber("Survey"));
		String[] name=new String[count];
		int i=1;
		PreparedStatement pstmt;
		ResultSet rs;
		
		pstmt=DataSource.con.prepareStatement("select SURVEY_NAME ,SURVEY_ENDDATE,REWARD_AMOUNT,TARGET_AUDIENCE from Survey where SURVEY_STATUS='1'");
		rs=pstmt.executeQuery();
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
					i++;
					break;
				}
			}
		}
		name[0]=Integer.toString(i-1);
		System.out.println("ssssssssss");
		return name;
		
	}
	
	
	public String getUserName(String email) throws SQLException, ClassNotFoundException
	{
		//getDBConnection();
		String name="";
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt=DataSource.con.prepareStatement("Select name from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		name=rs.getString(1);
		}
		return name;
		
	}
	public Double getCreationAmount(String Surveyname) throws SQLException, ClassNotFoundException
	{
		//getDBConnection();
		Double creationamt=0.0;
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt=DataSource.con.prepareStatement("Select CREATION_AMOUNT from survey where SURVEY_NAME='"+Surveyname+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		creationamt=Double.parseDouble(rs.getString(1));
		}
		return creationamt;
		
	}
	public String getSurveyName(String email) throws SQLException, ClassNotFoundException
	{
		String name="";
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt=DataSource.con.prepareStatement("Select survey_name from survey where email_address='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		name+=rs.getString(1)+";";
		}
		return name;
		
	}
	public String getRowsNumber(String Tablename) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String name="";
		pstmt=DataSource.con.prepareStatement("Select count(*) from "+Tablename);
		rs=pstmt.executeQuery();
		rs.next();
		String count=rs.getString(1);
		rs.close();
		return count;
		
	}

	
	public boolean DropTable(String Tablename) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
			pstmt=DataSource.con.prepareStatement("Drop table "+Tablename);
		pstmt.execute();
		return true;
		
	}
	

	
	public SurveyBeans getCompleteSurvey(String Surveyname) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		SurveyBeans sb=new SurveyBeans();
		ResultSet rs;
		String qa="";
		pstmt=DataSource.con.prepareStatement("Select * from Survey where SURVEY_NAME='"+Surveyname+"'");
		rs=pstmt.executeQuery();
	
		rs.next();
		sb.setCreationDate(rs.getDate(4));
		sb.setStartDate(rs.getDate(5));
		sb.setEndDate(rs.getDate(6));
		sb.setSurveyName(Surveyname);
		sb.setTargetAudience(rs.getString(3));
		sb.setSurveyStatus(rs.getString(7));
		
		return sb;
		
	}

	
	public String getEmailidFromSurveyname(String Surveyname) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String qa="";
		pstmt=DataSource.con.prepareStatement("Select EMAIL_ADDRESS from survey where SURVEY_NAME='"+Surveyname+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		qa=rs.getString(1);
		}
		return qa;
	}
	
	
	public String getSurvey(String Surveyname) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String qa="";
		pstmt=DataSource.con.prepareStatement("Select * from "+Surveyname);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		qa=rs.getString(3)+"*"+rs.getString(4)+"*"+rs.getString(5)+"*"+rs.getString(6);
		}

		return qa;
		
	}
	
	public boolean UpdateState(String surveyname,int state) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String query="update survey set SURVEY_STATUS='"+state+"' where SURVEY_NAME='"+surveyname+"'";
		pstmt=DataSource.con.prepareStatement(query);
		pstmt.executeUpdate();
		if(state==1)
			UpdateDates(surveyname); 
		return true;
		
	}
	
	
	public void UpdateDates(String surveyname) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt=DataSource.con.prepareStatement("Select WORKING_DAYS from survey where SURVEY_NAME='"+surveyname+"'");
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
		pstmt=DataSource.con.prepareStatement(query);
		pstmt.setDate(1,n.getdate());
		pstmt.setDate(2,sqlDate);
		pstmt.executeUpdate();
	}
	
	public boolean isSurveyFilledName(String email,String Surveyname) throws SQLException, ClassNotFoundException
	{

		PreparedStatement pstmt;
		ResultSet rs;
		System.out.println(email);
		System.out.println(Surveyname);
		String query="Select USER_EMAIL_ADD from "+Surveyname+"answer where USER_EMAIL_ADD='"+email+"'";
		pstmt=DataSource.con.prepareStatement(query);
		System.out.println(query);
		rs=pstmt.executeQuery();
		
		if(rs.next())
			{
			return false;
			}
		else {
			System.out.println("Pehle se not present here");
			return true;
		}
	}
	
	
	
	public  ArrayList getStates() throws SQLException, ClassNotFoundException
	{

		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList arr=new ArrayList();
		String query="Select * from states";
		pstmt=DataSource.con.prepareStatement(query);
		System.out.println(query);
		rs=pstmt.executeQuery();
		
		while(rs.next())
			{
			arr.add(rs.getString(1));
			}
		return arr;
	}
	
		
	
	
	public void CheckCompletion() throws SQLException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		String query="update survey set SURVEY_STATUS='"+2+"' where SURVEY_ENDDATE <= ? AND SURVEY_STATUS='1'";
		pstmt=DataSource.con.prepareStatement(query);
		pstmt.setDate(1,sqlDate);
		pstmt.executeUpdate();
	
			
	}
	
	public void DeleteSurvey(String Surveyname) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String query="delete from survey where SURVEY_NAME='"+Surveyname+"'";
		pstmt=DataSource.con.prepareStatement(query);
		pstmt.executeUpdate();
		DropTable(Surveyname);
		DropTable(Surveyname+"answer");

	}



	public void InsertUserResponse(String Surveyname,int questionno,String RESPONSE,String emailid) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String query="";
		for(int i=0;i<questionno;i++)
		{
			query+="?,";
		}
		query+="?,";
		query=query.substring(0, query.length() - 1);
		pstmt=DataSource.con.prepareStatement("insert into "+Surveyname+"answer values("+query+")");
		System.out.println("----"+query+questionno);
		StringTokenizer st=new StringTokenizer(RESPONSE,";");
		
		for(int i=0;i<questionno;i++)
		{
					pstmt.setString(i+2,st.nextToken());
			
		}
		pstmt.setString(1,emailid);
		rs=pstmt.executeQuery();
		
		
	}

	

}
