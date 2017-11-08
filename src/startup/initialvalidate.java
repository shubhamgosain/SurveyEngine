package startup;

import java.sql.Date;
import java.sql.SQLException;

import DAO.SurveyDAOImplements;

public class initialvalidate {  
public void StartProject(){  
	 java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    System.out.println("utilDate:" + utilDate);
	    System.out.println("sqlDate:" + sqlDate);
	    SurveyDAOImplements sdao=new SurveyDAOImplements();
	    try {
			sdao.CheckCompletion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Logo l=new Logo();
	    try {
			Thread.sleep(4000);
			l.dispose();
	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

}  
 
}  