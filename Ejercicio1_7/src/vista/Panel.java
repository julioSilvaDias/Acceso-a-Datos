package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.GestorFichero;
import modelo.Sesion;
import pojo.Mensaje;

public class Panel {

	private ArrayList<Mensaje> mensajes;
	private GestorFichero gestorFichero = new GestorFichero();
	private JPanel panel = null;

	public Panel(ArrayList<JPanel> paneles, JFrame frame) {
		panel = new JPanel();
		panel.setBounds(0, 0, 802, 517);
		panel.setLayout(null);

		JButton btn_CargarMensajes = new JButton("Cargar Mensajes");
		btn_CargarMensajes.setBounds(53, 63, 278, 63);
		panel.add(btn_CargarMensajes);

		JButton btn_anaidirMensajes = new JButton("Añadir Mensajes");
		btn_anaidirMensajes.setBounds(53, 226, 278, 63);
		panel.add(btn_anaidirMensajes);

		JButton btn_ImprimirMensaje = new JButton("Imprimir Mensaje");
		btn_ImprimirMensaje.setBounds(446, 226, 278, 63);
		panel.add(btn_ImprimirMensaje);

		JButton btn_GuardarMensajes = new JButton("Guardar Mensajes");

		btn_GuardarMensajes.setBounds(446, 63, 278, 63);
		panel.add(btn_GuardarMensajes);

		JButton btn_Salir = new JButton("Salir");
		btn_Salir.setBounds(608, 394, 115, 39);
		panel.add(btn_Salir);

		btn_CargarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajes = gestorFichero.cargarMensajes();

				int i = mensajes.size();
				JOptionPane.showMessageDialog(null, "Se han cargado " + i + " mensajes", "AVISO",
						JOptionPane.INFORMATION_MESSAGE);

				Sesion.getInstance().setMensajes(mensajes);

			}
		});

		btn_GuardarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorFichero.escribirMensajes(mensajes);

				JOptionPane.showMessageDialog(null, "Los mensajes en memoria, han sido guardados en mensajes.txt",
						"AVISO", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btn_ImprimirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
				
			}
		});
		
		btn_Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		
		btn_anaidirMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}
