package fill;

import javax.swing.JPanel;
import javax.swing.JComboBox;

public class Combobox extends JPanel {

	/**
	 * Create the panel.
	 */
	public Combobox() {

		setBounds(100,250,1820,600);
		setLayout(null);
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		comboBox.setBounds(800,100,150,30);
		comboBox.addItem("asdf");
		comboBox.addItem("bbbbf");
		Object cmboitem = comboBox.getSelectedItem();
	    System.out.println(cmboitem);
		
	}

}
