package DBConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource 
{
	public static Connection con;
	
	public static Connection getCon() {
		return con;
	}

	

	public DataSource()
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		//String url="jdbc:oracle:thin:@192.168.43.35:1521:XE";
		String user="System";
		String pwd="root";
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection established!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeAll()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
