package Login;
import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.UserDAOImplements;

public class SuccessfullyLoginMesssage  {

	
JFrame jf;
int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
String emailid;
String username;
public SuccessfullyLoginMesssage(String emailid) {
	
this.emailid=emailid;
UserDAOImplements udao=new UserDAOImplements();
try {
	username=udao.getUserName(emailid);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

void WelcomeMessage()
{
	jf=new JFrame();
	jf.setLayout(null);
	jf.setBounds(screenwidth-400,screenHeight-300,800,600);
	jf.setUndecorated(true);
	jf.setVisible(true);
	JLabel jl=new JLabel();
	jl.setSize(800,600);
	jf.setContentPane(jl);
	jl.setIcon(new ImageIcon("src/Images/aaa.jpg"));

	
	JLabel click=new JLabel();
	jf.add(click);
	click.setBounds(340,510, 110,30);
	click.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	jf.dispose();
        	usernew u=new usernew(emailid,username);
        	u.implement();
			
        	
        }
    });
	
	
		
	JTextField jt=new JTextField();
	jt.setEditable(false);
	jt.setOpaque(false);
	jf.add(jt);
	
	jt.setBounds(20,190,760,250);
	jt.setFont(new Font("Simsun",Font.BOLD,40));
	jt.setForeground(Color.WHITE);
	jt.setHorizontalAlignment(SwingConstants.CENTER);
	jt.setAlignmentX(SwingConstants.CENTER);
	jt.setAlignmentY(SwingConstants.CENTER);
	jt.setText("Welcome "+username);
	

}


}
