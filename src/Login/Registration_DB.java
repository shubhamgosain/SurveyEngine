package Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Registration_DB 
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
	
	
	public String getProfession(String email) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String profession="";
		pstmt=con.prepareStatement("Select PROFESSION from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		profession=rs.getString(1);
		}
		closeAll();
		return profession;
		
	}
	
	
	
	public Double getAmount(String email) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		Double amount=0.0;
		pstmt=con.prepareStatement("Select ACCOUNT_BALANCE from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		amount=Double.parseDouble(rs.getString(1));
		}
		closeAll();
		return amount;
		
	}
	
	public void setAmount(String email,Double Balance) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		Double amount=0.0;
		pstmt=con.prepareStatement("update information set ACCOUNT_BALANCE="+Balance.toString()+"where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		amount=Double.parseDouble(rs.getString(1));
		}
		closeAll();
		
	}
	
	
	
	
	//gosain86.shubham@gmail.com
	public String getTable(String email) throws SQLException, ClassNotFoundException
	{
		getDBConnection();
		String qa="";
		pstmt=con.prepareStatement("Select * from Information where email='"+email+"'");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
		qa=rs.getString(3)+"*"+rs.getString(4)+"*"+rs.getString(5)+"*"+rs.getString(6);
		}

		closeAll();
		return qa;
		
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
	
	public void insertData(String name, String gender, String sq1, String sq2, String a1, String a2, String profession, String state, String age, String email, String pass ) throws SQLException, ClassNotFoundException
	{
		
		getDBConnection();
      String query = "insert into information values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
System.out.println("Wallah");
      PreparedStatement preparedStmt = con.prepareStatement(query);
     preparedStmt.setString(1,name);
      preparedStmt.setString(2,gender);
      preparedStmt.setString(3,sq1);
      preparedStmt.setString(4,sq2);
      preparedStmt.setString(5,a1);
      preparedStmt.setString(6,a2);
      preparedStmt.setString(7,profession);
      preparedStmt.setString(8,state);
      preparedStmt.setString(9,age);
      preparedStmt.setString(10,email);
      preparedStmt.setString(11,pass);
      preparedStmt.setString(12,"0");
      // execute the preparedstatement
      preparedStmt.executeUpdate();
      
      
      preparedStmt=con.prepareStatement("insert into login values(?,?)");
      preparedStmt.setString(1,email);
      preparedStmt.setString(2,pass);
      preparedStmt.executeUpdate();
      System.out.println("Data inserted");
      closeAll();
      JOptionPane.showMessageDialog(null,"Successfully Registered");
      
      
	}
	
	
	
	public void closeAll() throws SQLException
	{
		con.close();
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Registration_DB d=new Registration_DB();
		//d.getDBConnection();
		//d.insertData("Nancy Chess", "Female", "What is your mother's maiden name?", "What is the name of your first childhood friend", "Sarita", "Harshita","Engineer", "Delhi", 20, "chessrockz13@gmail.com", "asdfgh1234");
System.out.println("-----"+d.getUserName("gosain86.shubham@gmail.com"));

}
}