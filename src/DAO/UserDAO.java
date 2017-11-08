package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import Beans.UserBeans;

public interface UserDAO 
{
	public UserBeans getTable(String email) throws SQLException, ClassNotFoundException;
	public String getUserName(String email) throws SQLException ;
	public Double getAmount(String email) throws SQLException, ClassNotFoundException;
	public boolean setAmount(String email,Double Balance) throws SQLException, ClassNotFoundException;
	public boolean UpdatePassword(String email,String newpass) throws SQLException, ClassNotFoundException;
	public boolean insertData(UserBeans ub) throws SQLException, ClassNotFoundException;
	public String getProfession(String email) throws SQLException, ClassNotFoundException;
	//void checkAccount(String email) throws ClassNotFoundException, SQLException;
	//public void closeAll() throws SQLException;
}
