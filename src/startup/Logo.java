package startup;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Logo extends JFrame {

	
	int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width/2;
	int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height/2;
		
public Logo() {


		setBounds(screenwidth-362,screenHeight-272,724,544);
		setLayout(null);
		setUndecorated(true);
		JLabel contentPane = new JLabel();
		setContentPane(contentPane);
		contentPane.setIcon(new ImageIcon("src/Images/logoimage.png"));
		setVisible(true);

}

}
