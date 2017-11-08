package MainPackage;
import java.sql.Connection;

import DBConn.DataSource;

import Login.UserLogin;
import startup.initialvalidate;
public class MainClass 
{	


	public static void main(String args[])
	{
		DataSource ds=new DataSource();
		initialvalidate t1=new initialvalidate();  
		t1.StartProject(); 
		UserLogin login=new UserLogin();
		
	}
}
