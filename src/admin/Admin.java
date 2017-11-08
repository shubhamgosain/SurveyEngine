package admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import DAO.SurveyDAOImplements;
import Login.UserLogin;
//import fill.Survey_db;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane,panel_2;
	private JLabel label;
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;

	

	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenwidth-680,screenHeight-384, 1360,768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1360, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSurveykshan = new JLabel("Survekshan");
		lblSurveykshan.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblSurveykshan.setForeground(Color.orange);
		lblSurveykshan.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		lblSurveykshan.setFont(new Font("SimSun", Font.BOLD, 30));
		lblSurveykshan.setBounds(6, 6, 298, 50);
		lblSurveykshan.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblSurveykshan);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.ORANGE));
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserLogin login=new UserLogin();
				//login.setVisible(true);
				dispose();
			}
		});
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setFont(new Font("Simsun", Font.PLAIN, 22));
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setBounds(1230, 6, 110, 50);
		panel.add(lblLogout);
		
		JLabel lblHiAdmin = new JLabel("Hi, Admin");
		lblHiAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHiAdmin.setForeground(Color.WHITE);
		lblHiAdmin.setFont(new Font("Tohima", Font.PLAIN, 18));
		lblHiAdmin.setBounds(1130, 6, 80, 50);
		panel.add(lblHiAdmin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 68, 304, 703);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(310, 68,1250, 700);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255,235,204));
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setBounds(400, 100, 350, 50);
		lblWelcome.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
		lblWelcome.setForeground(new Color(64,64,0));
		panel_2.add(lblWelcome);
		
		JLabel Info = new JLabel();
		Info.setBounds(100, 200, 1150, 200);
		Info.setFont(new Font("Simsun", Font.BOLD, 28));
		//Survey_db sdb=new Survey_db();
		SurveyDAOImplements sdao=new SurveyDAOImplements();
		try {
			Info.setText("We are Registering a Total of "+sdao.getRowsNumber("information")+" Users on Sarvekshan");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Info.setForeground(new Color(128,64,0));
		panel_2.add(Info);
		
		
		JLabel AllSurvey = new JLabel("All Surveys");
		AllSurvey.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AllSurveys all=new AllSurveys();
				all.setVisible(true);
			}
		});
		AllSurvey.setBounds(80, 70, 200, 29);
		AllSurvey.setOpaque(false);
		AllSurvey.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AllSurvey.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.ORANGE));
		AllSurvey.setForeground(Color.WHITE);
		AllSurvey.setHorizontalAlignment(SwingConstants.RIGHT);
		AllSurvey.setFont(new Font("Serif", Font.PLAIN, 22));
		
		panel_1.add(AllSurvey);
		
		JLabel Request = new JLabel("Requests");
		Request.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Requests req=new Requests();
				req.setVisible(true);
			}
		});
		Request.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.ORANGE));
		Request.setHorizontalAlignment(SwingConstants.RIGHT);
		Request.setForeground(Color.WHITE);
		Request.setFont(new Font("Serif", Font.PLAIN, 22));
		Request.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Request.setBounds(80, 113, 200, 29);
		panel_1.add(Request);
		
		JLabel CompSurvey = new JLabel("Completed Surveys");
		CompSurvey.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CompSurvey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Completed comp=new Completed();
				comp.setVisible(true);
			}
		});
		CompSurvey.setHorizontalAlignment(SwingConstants.RIGHT);
		CompSurvey.setForeground(Color.WHITE);
		CompSurvey.setFont(new Font("Serif", Font.PLAIN, 22));
		CompSurvey.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.ORANGE));
		CompSurvey.setBounds(80, 156, 200, 29);
		panel_1.add(CompSurvey);
	}
}
