package vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Sesion;
import pojo.Mensaje;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel1 {

	private JPanel panel = null;
	private JTable table;
	private String[] columnas = { "DE", "PARA", "FECHA", "HORA", "ASUNTO", "CONTENIDO" };
	private Object[][] datos = null;
	private DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
	private ArrayList<Mensaje> mensajes = null;

	public Panel1(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 845, 572);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 61, 740, 283);
		panel.add(scrollPane);

		table = new JTable(modeloTabla);
		scrollPane.setViewportView(table);

		JButton btn_menu = new JButton("Menu");
		btn_menu.setBounds(21, 397, 103, 33);
		panel.add(btn_menu);

		JButton btn_Imprimir = new JButton("Imprimir");
		btn_Imprimir.setBounds(658, 397, 103, 33);
		panel.add(btn_Imprimir);

		btn_Imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajes = Sesion.getInstance().getMensajes();
				for (Mensaje mensaje : mensajes) {
					Object[] fila = { mensaje.getDe(), mensaje.getPara(), mensaje.getFecha(), mensaje.getHora(),
							mensaje.getAsunto(), mensaje.getContenido() };

					modeloTabla.addRow(fila);

				}
			}
		});
		
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}
