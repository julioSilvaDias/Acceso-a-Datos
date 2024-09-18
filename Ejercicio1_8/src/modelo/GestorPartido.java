package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import pojo.Partido;

public class GestorPartido {
	private static final String RUTA = "C:/trastero/Resultados.dat";

	public ArrayList<Partido> CargarFicPartidos() {
		ArrayList<Partido> ret = null;

		if (null == Sesion.getInstance().getPartidos()) {
			ret = new ArrayList<Partido>();
		} else {
			ret = Sesion.getInstance().getPartidos();
		}

		try {
			FileInputStream fichero = new FileInputStream(RUTA);
			DataInputStream fic = new DataInputStream(fichero);

			String equipoLocal = null;
			String equipoVisitante = null;
			int golesLocal = 0;
			int golesVisitante = 0;
			String lugar = null;
			String fecha = null;

			while (fichero.getChannel().position() < fichero.getChannel().size()) {
				String linea = fic.readUTF().trim();
				String[] partes = linea.split(":", 2);

				if (partes.length == 2) {
					String clave = partes[0].trim().toLowerCase();
					String valor = partes[1].trim();

					switch (clave) {
					case "equipo local":
						equipoLocal = valor;
						break;

					case "equipo visitante":
						equipoVisitante = valor;
						break;

					case "goles local":
						golesLocal = Integer.parseInt(valor);
						break;

					case "goles visitante":
						golesVisitante = Integer.parseInt(valor);
						break;

					case "lugar":
						lugar = valor;
						break;

					case "fecha":
						fecha = valor;
						break;
					}
				}

				if (linea.contains("***************************")) {
					Partido partido = new Partido();
					partido.setEquipoLocal(equipoLocal);
					partido.setEquipoVisitante(equipoVisitante);
					partido.setGolLocal(golesLocal);
					partido.setGolVisitante(golesVisitante);
					partido.setLugar(lugar);
					partido.setFecha(fecha);

					ret.add(partido);

					equipoLocal = null;
					equipoVisitante = null;
					golesLocal = 0;
					golesVisitante = 0;
					lugar = null;
					fecha = null;
				}
			}

			fic.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	public void guardarPartidos(ArrayList<Partido> partidos) {
		try {
			DataOutputStream fic = new DataOutputStream(new FileOutputStream(RUTA));
			String numGoles = null;

			for (Partido partido : partidos) {
				fic.writeUTF("\n" + "Equipo local: " + partido.getEquipoLocal() + "\n");
				fic.writeUTF("Equipo visitante: " + partido.getEquipoVisitante() + "\n");
				numGoles = "Goles local: " + partido.getGolLocal();
				fic.writeUTF(numGoles + "\n");
				numGoles = null;
				numGoles = "Goles visitante: " + partido.getGolVisitante();
				fic.writeUTF(numGoles + "\n");
				numGoles = null;
				fic.writeUTF("Lugar: " + partido.getLugar() + "\n");
				fic.writeUTF("fecha: " + partido.getFecha() + "\n");
				fic.writeUTF("***************************");
			}

			fic.close();
		} catch (Exception e) {
			e.getStackTrace();

		}
	}

}
