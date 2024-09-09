package pojo;

import java.util.Objects;

public class Mensaje {
	public String fecha;
	public String hora;
	public String para;
	public String de;
	public String asunto;
	public String contenido;

	@Override
	public int hashCode() {
		return Objects.hash(asunto, contenido, de, fecha, hora, para);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(asunto, other.asunto) && Objects.equals(contenido, other.contenido)
				&& Objects.equals(de, other.de) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(para, other.para);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Mensaje [fecha=" + fecha + ", hora=" + hora + ", para=" + para + ", de=" + de + ", asunto=" + asunto
				+ ", contenido=" + contenido + "]";
	}

}
