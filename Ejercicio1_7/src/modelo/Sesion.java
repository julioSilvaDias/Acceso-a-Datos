package modelo;

import java.util.ArrayList;

import pojo.Mensaje;

public class Sesion {
	private static Sesion instance = null;

	private ArrayList<Mensaje> mensajes = null;

	private Sesion() {

	}

	public static Sesion getInstance() {
		if (null == instance) {
			instance = new Sesion();
		}

		return instance;
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

}
