package vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import modelo.Sesion;
import pojo.Mensaje;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2 {
	private JPanel panel = null;
	private JTextField txtDia;
	private JTextField txtDe;
	private JTextField txtPara;
	private JTextField txtAsunto;
	private JTextField txtContenido;

	public Panel2(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 597, 366);
		panel.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(28, 58, 56, 35);
		panel.add(lblFecha);

		txtDia = new JTextField();
		txtDia.setBounds(87, 67, 37, 20);
		panel.add(txtDia);
		txtDia.setColumns(10);

		JComboBox desplegableMes = new JComboBox();
		desplegableMes.setModel(new DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Deciembre" }));
		desplegableMes.setSelectedIndex(11);
		desplegableMes.addItem("Enero");
		desplegableMes.addItem("Febrero");
		desplegableMes.addItem("Marzo");
		desplegableMes.addItem("Abril");
		desplegableMes.addItem("Mayo");
		desplegableMes.addItem("Junio");
		desplegableMes.addItem("Julio");
		desplegableMes.addItem("Agosto");
		desplegableMes.addItem("Septiembre");
		desplegableMes.addItem("Octubre");
		desplegableMes.addItem("Noviembre");
		desplegableMes.addItem("Deciembre");

		desplegableMes.setBounds(160, 66, 123, 22);
		panel.add(desplegableMes);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHora.setBounds(28, 104, 56, 35);
		panel.add(lblHora);

		JComboBox desplegableHora = new JComboBox();
		desplegableHora.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		desplegableHora.setSelectedIndex(23);
		desplegableHora.setBounds(87, 112, 37, 22);
		panel.add(desplegableHora);

		JLabel lblHora_1 = new JLabel(":");
		lblHora_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHora_1.setBounds(134, 104, 5, 35);
		panel.add(lblHora_1);

		JComboBox desplegableMinuto = new JComboBox();
		desplegableMinuto.setModel(new DefaultComboBoxModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		desplegableMinuto.setSelectedIndex(59);
		desplegableMinuto.setBounds(149, 112, 37, 22);
		panel.add(desplegableMinuto);

		JComboBox desplegableAnio = new JComboBox();
		desplegableAnio.setModel(new DefaultComboBoxModel(new String[] { "2024", "2025", "2026", "2027", "2028", "2029",
				"2030", "2031", "2032", "2033", "2034", "2035", "3036", "2037", "2038", "2039", "2040" }));
		desplegableAnio.setSelectedIndex(15);
		desplegableAnio.setBounds(314, 66, 76, 22);
		panel.add(desplegableAnio);

		JLabel lblDe = new JLabel("De");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDe.setBounds(28, 150, 56, 35);
		panel.add(lblDe);

		txtDe = new JTextField();
		txtDe.setColumns(10);
		txtDe.setBounds(64, 159, 219, 20);
		panel.add(txtDe);

		txtPara = new JTextField();
		txtPara.setColumns(10);
		txtPara.setBounds(74, 199, 219, 20);
		panel.add(txtPara);

		JLabel lblPara = new JLabel("Para");
		lblPara.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPara.setBounds(28, 190, 56, 35);
		panel.add(lblPara);

		txtAsunto = new JTextField();
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(84, 239, 219, 20);
		panel.add(txtAsunto);

		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAsunto.setBounds(28, 230, 56, 35);
		panel.add(lblAsunto);

		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContenido.setBounds(28, 270, 69, 35);
		panel.add(lblContenido);

		txtContenido = new JTextField();
		txtContenido.setColumns(10);
		txtContenido.setBounds(105, 280, 219, 63);
		panel.add(txtContenido);

		JButton btnCancelar = new JButton("Cancel");
		btnCancelar.setBounds(479, 332, 76, 23);
		panel.add(btnCancelar);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(400, 332, 69, 23);
		panel.add(btnOk);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Mensaje mensaje = new Mensaje();
				String txt = null;

				txt = txtDia.getText() + "/" + desplegableMes.getSelectedItem() + "/"
						+ desplegableAnio.getSelectedItem();
				mensaje.setFecha(txt);
				txtDia.setText("");
				txt = "";

				txt = desplegableHora.getSelectedItem() + ":" + desplegableMinuto.getSelectedItem();
				mensaje.setHora(txt);
				txt = "";

				txt = txtDe.getText();
				mensaje.setDe(txt);
				txtDe.setText("");
				txt = "";

				txt = txtPara.getText();
				txtPara.setText("");
				mensaje.setPara(txt);
				txt = "";

				txt = txtAsunto.getText();
				txtAsunto.setText("");
				mensaje.setAsunto(txt);
				txt = "";

				txt = txtContenido.getText();
				txtContenido.setText("");
				mensaje.setContenido(txt);

				ArrayList<Mensaje> mensajes = Sesion.getInstance().getMensajes();
				mensajes.add(mensaje);
				Sesion.getInstance().setMensajes(mensajes);

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
