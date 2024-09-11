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

	private static final String RUTA = "c:\\Trastero\\Mensajes.txt";

	public ArrayList<Mensaje> cargarMensajes() {
		ArrayList<Mensaje> ret = null;

		if (Sesion.getInstance().getMensajes() != null) {
			ret = Sesion.getInstance().getMensajes();

		} else {
			ret = new ArrayList<Mensaje>();
		}

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
					/*
					 * aqui ademas de asignar valores a las variables, tabien se quita los prefijos
					 * de lectura que viene antes del dato que nos interesa, como por ejemplp
					 * fecha:, hora:, de:, etc. Al seperar la linea en dos partes, asignamos el
					 * prefijo a la posicion 0 de un array y el dato a la parte 1, luego se ultiliza
					 * la parte 0 como clave para un switch case
					 */
					String[] partes = linea.split(":", 2);

					if (partes.length == 2) {
						String clave = partes[0].trim();
						String valor = partes[1].trim();

						switch (clave.toLowerCase()) {
						case "fecha":
							fecha = valor;
							break;
						case "hora":
							hora = valor;
							break;
						case "para":
							para = valor;
							break;
						case "de":
							de = valor;
							break;
						case "asunto":
							asunto = valor;
							break;
						case "contenido":
							contenido = valor;
							break;
						}
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
