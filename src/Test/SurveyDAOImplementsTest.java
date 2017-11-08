package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import Beans.SurveyBeans;
import DAO.SurveyDAOImplements;
import DAO.UserDAOImplements;
import DBConn.DataSource;
import MainPackage.MainClass;

public class SurveyDAOImplementsTest {

	public SurveyDAOImplements sdao=new SurveyDAOImplements();
	public SurveyDAOImplementsTest() {
		DataSource ds=new DataSource();
		sdao=new SurveyDAOImplements();
		
	}
	
	@Test
	public void testcreateTable(){
		try {
			assertEquals(true,sdao.createTable("Test"));
			sdao.DropTable("Test");
		} catch (ClassNotFoundException e) {
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
			try {
				check = sdao.getUserName(("gosain86.shubham"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			assertEquals("Shubham Gosain",check);
		
	
	}

	@Test
	public void testGetSurveyName() {
		try {
			assertEquals("4",sdao.getRowsNumber("FirstCheck41"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	public void testGetRowsNumber() {
		try {
			assertEquals("4",sdao.getRowsNumber("FirstCheck41"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDropTable() {
		try {
			sdao.createTable("Test");
			assertEquals(true,sdao.DropTable("Test"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCompleteSurvey() {
		try {
			SurveyBeans sb=sdao.getCompleteSurvey("FirstCheck41");
			assertEquals("FirstCheck41",sb.getSurveyName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetEmailidFromSurveyname() {
		try {
			assertEquals("gosain.shubham",sdao.getEmailidFromSurveyname("FirstCheck41"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Test
public void testGetSurvey() {
		try {
			assertEquals("1346*06-JUL-17*06-JUL-17*26-JUL-171",sdao.getSurvey("FirstCheck41"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	public void testUpdateState() {
		try{
		assertEquals(true,sdao.UpdateState("survey143",2));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	
	@Test
	public void testIsSurveyFilledName() {
		try{
		assertEquals(false,sdao.isSurveyFilledName("gosain86.shubham","FirstCheck41"));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	
	
	@Test
	public void testgetCreationAmount() {
	try {
		assertEquals("165.0",sdao.getCreationAmount("FirstCheck41").toString());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
