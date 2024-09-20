package prueba;

import java.io.File;
import java.io.RandomAccessFile;

public class AccesoAleatorioLectura_P2 {
	private static final String RUTA = "C:/Trastero/AleatorioEmple.dat";

	public static void main(String[] args) {

		try {
			File fichero = new File(RUTA);
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			int id, dep, posicion;
			Double salario = null;
			char apellido[] = new char[10], aux = 0;

			int registro = Integer.parseInt(args[0]);
			posicion = (registro - 1) * 36;
			if (posicion >= file.length())
				System.out.printf("ID. %d, NO EXISTE EMPLEADO...", registro);
			else {
				file.seek(posicion);
				id = file.readInt();
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
				}

				String apellidoS = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();
				System.out.println("ID: " + registro + ", Apellido: " + apellidoS.trim() + ", Departamento: " + dep
						+ ", Salario: " + salario);
			}
			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
