package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private String[] columnas = {"equipo local","equipo visitante","goles local","goles visitante","lugar","fecha"};
	private Object[][] datos = null;
	private DefaultTableModel modelo = new DefaultTableModel(datos, columnas);

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
		
		JLabel lblEquipoLoc = new JLabel("EquipoLocal");
		lblEquipoLoc.setBounds(10, 11, 56, 14);
		contentPane.add(lblEquipoLoc);
		
		JLabel lblEquipoVis = new JLabel("Equipo Visitante");
		lblEquipoVis.setBounds(10, 36, 76, 14);
		contentPane.add(lblEquipoVis);
		
		JLabel lblGolesLoc = new JLabel("Goles Local");
		lblGolesLoc.setBounds(10, 61, 56, 14);
		contentPane.add(lblGolesLoc);
		
		JLabel lblGolesVIs = new JLabel("Goles Visitante");
		lblGolesVIs.setBounds(10, 86, 70, 14);
		contentPane.add(lblGolesVIs);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 111, 27, 14);
		contentPane.add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 136, 46, 14);
		contentPane.add(lblFecha);
		
		textEquipoVis = new JTextField();
		textEquipoVis.setBounds(104, 33, 175, 20);
		contentPane.add(textEquipoVis);
		textEquipoVis.setColumns(10);
		
		textGolesLoc = new JTextField();
		textGolesLoc.setColumns(10);
		textGolesLoc.setBounds(104, 58, 175, 20);
		contentPane.add(textGolesLoc);
		
		textEquipoLoc = new JTextField();
		textEquipoLoc.setColumns(10);
		textEquipoLoc.setBounds(104, 8, 175, 20);
		contentPane.add(textEquipoLoc);
		
		textGolesVis = new JTextField();
		textGolesVis.setColumns(10);
		textGolesVis.setBounds(104, 83, 175, 20);
		contentPane.add(textGolesVis);
		
		textLoc = new JTextField();
		textLoc.setColumns(10);
		textLoc.setBounds(104, 108, 175, 20);
		contentPane.add(textLoc);
		
		TextFec = new JTextField();
		TextFec.setColumns(10);
		TextFec.setBounds(104, 133, 175, 20);
		contentPane.add(TextFec);
		
		JButton btnAnaidir = new JButton("Añadir");
		btnAnaidir.setBounds(10, 178, 89, 23);
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
	}
}
