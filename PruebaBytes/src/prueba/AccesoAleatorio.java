package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {
	private static final String RUTA = "C:/Trastero/AleatorioEmple.dat";

	public static void main(String[] args) {

		try {
			File fichero = new File(RUTA);
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			String apellido[] = { "FERNANDEZ", "GIL", "LOPEZ", "RAMOZ", "SEVILLA", "CASILLA", "REY" };
			int dep[] = { 10, 20, 10, 10, 30, 30, 20 };
			Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };
			StringBuffer buffer = null;
			int n = apellido.length;

			for (int i = 0; i < n; i++) {
				file.writeInt(i+1);
				buffer= new StringBuffer(apellido[i]);
				buffer.setLength(10);
				file.writeChars(buffer.toString());
				file.writeInt(dep[i]);
				file.writeDouble(salario[i]);
			}
			
			file.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
