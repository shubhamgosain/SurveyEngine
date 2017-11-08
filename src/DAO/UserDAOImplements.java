package DAO;
import DBConn.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import Beans.LoginBeans;
import Beans.UserBeans;
//import Login.Registration_DB;

public class UserDAOImplements implements UserDAO
{
	public UserBeans getTable(String email) throws SQLException, ClassNotFoundException
	{
		//DataSource.con=getDataSource();
		ResultSet rs;
		UserBeans ub=new UserBeans();
		PreparedStatement pstmt;
		pstmt=DataSource.con.prepareStatement("Select * from information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		ub.setSq1(rs.getString(3));
		ub.setSq2(rs.getString(4));
		ub.setA1(rs.getString(5));
		ub.setA2(rs.getString(6));
		ub.setEmail(rs.getString(10));
		}

		//closeAll();
		return ub;
		
	}

	public String getUserName(String email) throws SQLException 
	{


		//DataSource.con=getDataSource();
		//DataSource.con=getDataSource();
		PreparedStatement pstmt;
		ResultSet rs;
		//getDBConnection(DataSource.con);
		String name="";
		pstmt=DataSource.con.prepareStatement("Select name from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		name=rs.getString(1);
		}
		//closeAll();
		return name;
		
	}

	
	public String getProfession(String email) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		String profession="";
		pstmt=DataSource.con.prepareStatement("Select PROFESSION from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		profession=rs.getString(1);
		}
		return profession;
		
	}
	
	public Double getAmount(String email) throws SQLException, ClassNotFoundException
	{

		PreparedStatement pstmt;
		ResultSet rs;
		Double amount=0.0;
		pstmt=DataSource.con.prepareStatement("Select ACCOUNT_BALANCE from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		amount=Double.parseDouble(rs.getString(1));
		}
		//closeAll();
		return amount;
	}
	
	

	public boolean setAmount(String email,Double Balance) throws SQLException, ClassNotFoundException
	{
		PreparedStatement pstmt;
		ResultSet rs;
		
		Double amount=0.0;
		pstmt=DataSource.con.prepareStatement("update information set ACCOUNT_BALANCE="+Balance.toString()+"where email='"+email+"'");
		pstmt.executeUpdate();
		return true;
		
	}
	
	
	
	public boolean UpdatePassword(String email,String newpass) throws SQLException, ClassNotFoundException
	{

		PreparedStatement pstmt;
		ResultSet rs;
		String query="update information set \"Password\"='"+newpass+"' where email='"+email+"'";
		pstmt=DataSource.con.prepareStatement(query);
		pstmt.executeUpdate();
		pstmt=DataSource.con.prepareStatement("update Login set \"PASSWORD\"='"+newpass+"' where Username='"+email+"'");
		pstmt.executeUpdate();
		return true;
		
		
	}
	public boolean insertData(UserBeans ub) throws SQLException, ClassNotFoundException
	{

		ResultSet rs;
		String query = "insert into information values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = DataSource.con.prepareStatement(query);
      	preparedStmt.setString(1,ub.getName());
      	preparedStmt.setString(2,ub.getGender());
      	preparedStmt.setString(3,ub.getSq1());
      	preparedStmt.setString(4,ub.getSq2());
      	preparedStmt.setString(5,ub.getA1());
      	preparedStmt.setString(6,ub.getA2());
      	preparedStmt.setString(7,ub.getProfession());
      	preparedStmt.setString(8,ub.getState());
      	preparedStmt.setString(9,ub.getAge());
      	preparedStmt.setString(10,ub.getEmail());
      	preparedStmt.setString(11,ub.getPassword());
      	preparedStmt.setString(12, ub.getAmount());
      preparedStmt.executeUpdate();
      
      
      preparedStmt=DataSource.con.prepareStatement("insert into login values(?,?)");
      preparedStmt.setString(1,ub.getEmail());
      preparedStmt.setString(2,ub.getPassword());
      preparedStmt.executeUpdate();
      return true;
		
      
      
	}
}
