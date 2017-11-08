package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import Beans.UserBeans;
import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import DBConn.DataSource;

public class UserDAOImplementsTest {

	public UserDAOImplements udao;
	public UserDAOImplementsTest() {
		DataSource ds=new DataSource();
		udao=new UserDAOImplements();
	}
	
	@Test
	public void testGetTable() {
		try {
			UserBeans ub=udao.getTable("gosain86.shubham");
			
			assertEquals("gosain86.shubham",ub.getEmail());
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testGetUserName() {
		String check="";
		try {
			check = udao.getUserName("gosain86.shubham");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertEquals("Shubham Gosain",check);
		
	}

	
	@Test
	public void testGetProfession() {
		try {
			assertEquals("Engineer",udao.getProfession("gosain86.shubham"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAmount() {
		
		try {
			assertEquals("32.0",udao.getAmount("gosain86.shubham").toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Test
	public void testSetAmount() {
		try {
			assertEquals(true,udao.setAmount("gosain86.shubham",32.0));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdatePassword() {
		try {
			assertEquals(true,udao.UpdatePassword("gosain86.shubham","12345"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
