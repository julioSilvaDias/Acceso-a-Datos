package modelo;

import java.util.ArrayList;

import pojo.Partido;

public class Sesion {
	private static Sesion instance = null;

	private ArrayList<Partido> partidos = null;

	private Sesion() {

	}

	public static Sesion getInstance() {
		if (null == instance) {
			instance = new Sesion();
		}

		return instance;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

}
