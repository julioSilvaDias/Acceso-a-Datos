package ejercicio1_7;

import java.awt.EventQueue;
import java.util.ArrayList;
import vista.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ejercicio1_7 {

	public JFrame frame;
	public ArrayList<JPanel> paneles=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ejercicio1_7().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio1_7() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 794, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		paneles = new ArrayList<JPanel>();
		
		Panel panelMenu = new Panel(paneles, frame);
		JPanel panel1 = panelMenu.getPanel();
		panel1.setVisible(true);
		
		paneles.add(panel1);
		frame.getContentPane().add(panel1);
		
		Panel1 panelImprimir = new Panel1(paneles);
		JPanel panel2 = panelImprimir.getPanel();
		panel2.setVisible(false);
		
		paneles.add(panel2);
		frame.getContentPane().add(panel2);
		
		
	}

}
