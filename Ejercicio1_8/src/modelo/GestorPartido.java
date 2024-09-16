package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import pojo.Partido;

public class GestorPartido {
	private static final String RUTA = "Resultados.dat";

	public ArrayList<Partido> CargarFicPartidos() {
		ArrayList<Partido> ret = null;

		try {
			File fichero = new File(RUTA);
			FileInputStream fic = new FileInputStream(fichero);
			String equipoLocal = null;
			String equipoVisitante = null;
			int golesLocal = 0;
			int golesVisitante = 0;
			String lugar = null;
			String fecha = null;

			String linea;
			int i;

			while ((i = fic.read()) != -1) {
				linea = Character.toString((char) +i);

				if (linea.contains("******************")) {
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

				} else {

					String[] partes = linea.split(":", 2);

					if (partes.length == 2) {
						String clave = partes[0].trim();
						String valor = partes[1].trim();

						switch (clave.toLowerCase()) {
						case "equipo Local":
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

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
