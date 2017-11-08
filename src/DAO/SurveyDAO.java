package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.SurveyBeans;

public interface SurveyDAO 
{
	public boolean createResponseTable(String tablename) throws SQLException, ClassNotFoundException;
	public boolean createTable(String tablename) throws SQLException, ClassNotFoundException;
	public String[] getFillSurveys(String email,String profession) throws SQLException, ClassNotFoundException;
	public String getUserName(String email) throws SQLException, ClassNotFoundException;
	public String getCreationAmount(String Surveyname) throws SQLException, ClassNotFoundException;
	public String getSurveyName(String email) throws SQLException, ClassNotFoundException;
	public String getRowsNumber(String Tablename) throws SQLException, ClassNotFoundException;
	public boolean DropTable(String Tablename) throws SQLException, ClassNotFoundException;
	public SurveyBeans getCompleteSurvey(String Surveyname) throws SQLException, ClassNotFoundException;
	public String getEmailidFromSurveyname(String Surveyname) throws SQLException, ClassNotFoundException;
	public String getSurvey(String Surveyname) throws SQLException, ClassNotFoundException;
	public boolean UpdateState(String surveyname,int state) throws SQLException, ClassNotFoundException;
	public void UpdateDates(String surveyname) throws SQLException, ClassNotFoundException;
	public void UpdatePassword(String email,String newpass) throws SQLException, ClassNotFoundException;
	public boolean isSurveyFilledName(String email,String Surveyname) throws SQLException, ClassNotFoundException;
	public  ArrayList getStates() throws SQLException, ClassNotFoundException;
	public void CheckCompletion(String surveyname) throws SQLException, ClassNotFoundException;
	public void DeleteSurvey(String Surveyname) throws SQLException, ClassNotFoundException;
	public void InsertUserResponse(String Surveyname,int questionno,String RESPONSE,String emailid) throws SQLException, ClassNotFoundException;

}
		