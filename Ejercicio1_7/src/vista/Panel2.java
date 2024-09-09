package vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

public class Panel2 {
	private JPanel panel = null;

	public Panel2(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 905, 589);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(304, 253, 269, 116);
		panel.add(btnNewButton);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
