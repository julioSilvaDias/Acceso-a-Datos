package modelo;

import java.io.BufferedReader;
import pojo.Mensaje;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojo.Mensaje;

public class GestorFichero {

	private static final String RUTA = "c:\\Trastero\\mensajes.txt";

	public ArrayList<Mensaje> cargarMensajes() {
		ArrayList<Mensaje> ret = new ArrayList<Mensaje>();
		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(RUTA));
			String fecha = null;
			String hora = null;
			String para = null;
			String de = null;
			String asunto = null;
			String contenido = null;

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {
				if (linea.contains("******************")) {
					Mensaje mensaje = new Mensaje();
					mensaje.setFecha(fecha);
					mensaje.setHora(hora);
					mensaje.setPara(para);
					mensaje.setDe(de);
					mensaje.setAsunto(asunto);
					mensaje.setContenido(contenido);

					ret.add(mensaje);

					fecha = null;
					hora = null;
					para = null;
					de = null;
					asunto = null;
					contenido = null;

				} else {
					if (linea.startsWith("fecha:")) {
						fecha = linea;
					} else if (linea.startsWith("hora:")) {
						hora = linea;
					} else if (linea.startsWith("para:")) {
						para = linea;
					} else if (linea.startsWith("de:")) {
						de = linea;
					} else if (linea.startsWith("asunto:")) {
						asunto = linea;
					} else if (linea.startsWith("contenido:")) {
						contenido = linea;

					}

				}

			}
		} catch (FileNotFoundException fn) {
			System.out.println("Archivo no encontrado");

		} catch (IOException ioe) {
			System.out.println("ERROR DE E/S");
		}

		return ret;
	}

	public void escribirMensajes(ArrayList<Mensaje> mensajes) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(RUTA));

			for (Mensaje mensaje : mensajes) {
				bufferedWriter.write("fecha: " + mensaje.fecha);
				bufferedWriter.newLine();
				bufferedWriter.write("hora: " + mensaje.hora);
				bufferedWriter.newLine();
				bufferedWriter.write("para: " + mensaje.para);
				bufferedWriter.newLine();
				bufferedWriter.write("de: " + mensaje.de);
				bufferedWriter.newLine();
				bufferedWriter.write("asunto: " + mensaje.asunto);
				bufferedWriter.newLine();
				bufferedWriter.write("contenido: " + mensaje.contenido);
				bufferedWriter.newLine();
				bufferedWriter.write("******************");
				bufferedWriter.newLine();

			}
			bufferedWriter.close();
			
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
