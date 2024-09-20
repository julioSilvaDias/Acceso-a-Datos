package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import modelo.GestorPartido;
import modelo.Sesion;
import pojo.Partido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelPartido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEquipoVis;
	private JTextField textGolesLoc;
	private JTextField textEquipoLoc;
	private JTextField textGolesVis;
	private JTextField textLoc;
	private JTextField TextFec;
	private JTable tablaPartidos;
	private String[] columnas = { "equipo local", "equipo visitante", "goles local", "goles visitante", "lugar",
			"fecha" };
	private Object[][] datos = null;
	private DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
	private ArrayList<Partido> partidos = null;
	private GestorPartido gestorPartido = new GestorPartido();
	private JButton btnAnaidir = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPartido frame = new PanelPartido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelPartido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEquipoLoc = new JLabel("Equipo Local");
		lblEquipoLoc.setBounds(10, 11, 112, 14);
		contentPane.add(lblEquipoLoc);

		JLabel lblEquipoVis = new JLabel("Equipo Visitante");
		lblEquipoVis.setBounds(10, 36, 112, 14);
		contentPane.add(lblEquipoVis);

		JLabel lblGolesLoc = new JLabel("Goles Local");
		lblGolesLoc.setBounds(10, 61, 84, 14);
		contentPane.add(lblGolesLoc);

		JLabel lblGolesVIs = new JLabel("Goles Visitante");
		lblGolesVIs.setBounds(10, 86, 112, 14);
		contentPane.add(lblGolesVIs);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 111, 89, 14);
		contentPane.add(lblLugar);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 136, 46, 14);
		contentPane.add(lblFecha);

		textEquipoVis = new JTextField();
		textEquipoVis.setBounds(132, 33, 175, 20);
		contentPane.add(textEquipoVis);
		textEquipoVis.setColumns(10);

		textGolesLoc = new JTextField();
		textGolesLoc.setColumns(10);
		textGolesLoc.setBounds(132, 58, 175, 20);
		contentPane.add(textGolesLoc);

		textEquipoLoc = new JTextField();
		textEquipoLoc.setColumns(10);
		textEquipoLoc.setBounds(132, 8, 175, 20);
		contentPane.add(textEquipoLoc);

		textGolesVis = new JTextField();
		textGolesVis.setColumns(10);
		textGolesVis.setBounds(132, 83, 175, 20);
		contentPane.add(textGolesVis);

		textLoc = new JTextField();
		textLoc.setColumns(10);
		textLoc.setBounds(132, 108, 175, 20);
		contentPane.add(textLoc);

		TextFec = new JTextField();
		TextFec.setColumns(10);
		TextFec.setBounds(132, 133, 175, 20);
		contentPane.add(TextFec);

		btnAnaidir = new JButton("Añadir");
		btnAnaidir.setBounds(10, 178, 89, 23);
		btnAnaidir.setEnabled(false);
		contentPane.add(btnAnaidir);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(109, 178, 89, 23);
		contentPane.add(btnCargar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(208, 178, 89, 23);
		contentPane.add(btnGuardar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 372, 180);
		contentPane.add(scrollPane);

		tablaPartidos = new JTable(modelo);
		scrollPane.setViewportView(tablaPartidos);

		textEquipoLoc.getDocument().addDocumentListener(crearDocumentListener());
		textEquipoVis.getDocument().addDocumentListener(crearDocumentListener());
		textLoc.getDocument().addDocumentListener(crearDocumentListener());
		textGolesLoc.getDocument().addDocumentListener(crearDocumentListener());
		textGolesVis.getDocument().addDocumentListener(crearDocumentListener());
		TextFec.getDocument().addDocumentListener(crearDocumentListener());

		btnAnaidir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido partido = new Partido();
				int goles = 0;

				partido.setEquipoLocal(textEquipoLoc.getText());
				partido.setEquipoVisitante(textEquipoVis.getText());
				goles = Integer.parseInt(textGolesLoc.getText());
				partido.setGolLocal(goles);
				goles = 0;
				goles = Integer.parseInt(textGolesVis.getText());
				partido.setGolVisitante(goles);
				partido.setLugar(textLoc.getText());
				partido.setFecha(TextFec.getText());

				Object[] Fila = { partido.getEquipoLocal(), partido.getEquipoVisitante(), partido.getGolLocal(),
						partido.getGolVisitante(), partido.getLugar(), partido.getFecha() };

				modelo.addRow(Fila);

				textEquipoLoc.setText("");
				textEquipoVis.setText("");
				textGolesLoc.setText("");
				textGolesVis.setText("");
				textLoc.setText("");
				TextFec.setText("");

				if (null == Sesion.getInstance().getPartidos()) {
					partidos = new ArrayList<Partido>();

				} else {
					partidos = Sesion.getInstance().getPartidos();

				}

				partidos.add(partido);
				Sesion.getInstance().setPartidos(partidos);

			}
		});

		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partidos = gestorPartido.CargarFicPartidos();

				JOptionPane.showMessageDialog(null, "Se han cargado los partidos correctamente", "AVISO",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPartido.guardarPartidos(partidos);

				JOptionPane.showMessageDialog(null, "Se han guardado los partidos correctamente", "AVISO",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
	}

	private void actualizarEstadoBoton() {
		boolean habilitar = textEquipoLoc.getText().length() >= 1 && textEquipoLoc.getText().length() <= 20
				&& textEquipoVis.getText().length() >= 1 && textEquipoVis.getText().length() <= 20
				&& textLoc.getText().length() >= 1 && textLoc.getText().length() <= 20
				&& validarGoles(textGolesLoc.getText()) && validarGoles(textGolesVis.getText())&& validarFecha(TextFec.getText());

		btnAnaidir.setEnabled(habilitar);
	}
	
	private boolean validarFecha(String text) {
		if (text.matches("\\d{2}/\\d{2}/\\d{2}")) {
			try {
				SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
				simpleFormat.setLenient(false);  
				simpleFormat.parse(text);      
				return true;          
			} catch (ParseException e) {
				return false;         
			}
		} else {
			return false;
		}
	}

	private boolean validarGoles(String text) {
		return text.matches("\\d{1,2}");
	}

	private DocumentListener crearDocumentListener() {
		return new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				actualizarEstadoBoton();
			}

			public void removeUpdate(DocumentEvent e) {
				actualizarEstadoBoton();
			}

			public void changedUpdate(DocumentEvent e) {
				actualizarEstadoBoton();
			}
		};
	}
}
