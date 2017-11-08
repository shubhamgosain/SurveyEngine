package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class User1LoginDisplay  extends JPanel{
	JLabel jl;
	
	
	public User1LoginDisplay() {
			setLayout(null);
			setOpaque(false);
			setBounds(428,317,856,354);
			
			jl= new JLabel();
			add(jl);
			
			jl.setSize(856,634);
		
	}


}