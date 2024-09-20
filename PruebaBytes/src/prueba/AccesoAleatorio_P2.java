package prueba;

import java.io.File;
import java.io.RandomAccessFile;

public class AccesoAleatorio_P2 {

	private static final String RUTA = "C:/Trastero/AleatorioEmple.dat";

	public static void main(String[] args) {

		try {
			File fichero = new File(RUTA);
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			StringBuffer buffer = null;
			String apellido = "ETXEBERRIA";
			Double salario = 1230.87;
			int dep = 10;
			int id = 2;
			long posicion = (id - 1) * 36;
			file.seek(posicion);
			file.writeInt(id);
			buffer = new StringBuffer(apellido);
			buffer.setLength(10);
			file.writeChars(buffer.toString());
			file.writeInt(dep);
			file.writeDouble(salario);

			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
